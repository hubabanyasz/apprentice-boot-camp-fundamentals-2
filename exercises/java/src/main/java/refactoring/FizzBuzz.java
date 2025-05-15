package refactoring;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

class FizzBuzz {

    public static final int ONE_HUNDRED = Byte.MAX_VALUE - 27;
    public static final int THREE_IN_BINARY = 0b11;
    public static final int FIVE = new int[]{0, 0, 0, 0, 0}.length;

    public static final String FIZZ_HEX = "46697a7a";
    public static final String BUZZ_HEX = "42757a7a";

    private int countsUpToOneHundred;
    private int countsUpToThree;
    private int countsDownFromFive = FIVE;

    String doFizzBuzzUpTo100() {
        StringBuilder resultString = new StringBuilder();
        for (; countsUpToOneHundred < ONE_HUNDRED; countsUpToOneHundred++) {
            String fizzOrBuzzPlusASpace = addFizzOrBuzz(countsUpToOneHundred) + " ";
            appendFizzOrBuzzPlusASpace(resultString, fizzOrBuzzPlusASpace);
        }
        return getSubstring(resultString);
    }

    private static void appendFizzOrBuzzPlusASpace(StringBuilder resultString, String fizzOrBuzzPlusASpace) {
        resultString.append(fizzOrBuzzPlusASpace);
    }

    private static String getSubstring(StringBuilder resultString) {
        return resultString.substring(0, resultString.length() - 1);
    }

    private String addFizzOrBuzz(int number) {
        countsUpToThree++;
        countsDownFromFive--;

        boolean isDivisibleByFive = isIsDivisibleByFive();
        boolean isDivisibleByThree = isIsDivisibleByThree();

        String currentNumberInTheLoop = String.valueOf(number + 1);

        String fizzOrBuzz = isDivisibleByThree || isDivisibleByFive ? "" : currentNumberInTheLoop;
        fizzOrBuzz = getFizzOrBuzz(isDivisibleByThree, fizzOrBuzz, isDivisibleByFive);

        return fizzOrBuzz;
    }

    private boolean isIsDivisibleByThree() {
        return countsUpToThree == THREE_IN_BINARY;
    }

    private boolean isIsDivisibleByFive() {
        return countsDownFromFive == 0;
    }

    private String getFizzOrBuzz(boolean isDivisibleByThree, String fizzOrBuzz, boolean isDivisibleByFive) {
        if (isDivisibleByThree) fizzOrBuzz += fizz();
        if (isDivisibleByFive) fizzOrBuzz += buzz();
        return fizzOrBuzz;
    }

    private String buzz() {
        countsDownFromFive = FIVE;
        return decodeHexcode(BUZZ_HEX);
    }

    private String fizz() {
        countsUpToThree = 0;
        return decodeHexcode(FIZZ_HEX);
    }

    private static String decodeHexcode(String fizzHex) {
        try {
            return new String(Hex.decodeHex(fizzHex), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }
}
