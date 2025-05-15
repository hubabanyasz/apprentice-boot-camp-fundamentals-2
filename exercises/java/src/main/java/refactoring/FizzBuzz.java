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
            resultString.append(fizzOrBuzzPlusASpace);
        }
        return resultString.substring(0, resultString.length() - 1);
    }

    private String addFizzOrBuzz(int number) {
        countsUpToThree++;
        countsDownFromFive--;

        boolean isDivisibleByFive = countsDownFromFive == 0;
        boolean isDivisibleByThree = countsUpToThree == THREE_IN_BINARY;

        String currentNumberInTheLoop = String.valueOf(number + 1);
        boolean isDivisibleByThreeOrFive = isDivisibleByThree || isDivisibleByFive;
        String fizzOrBuzz = isDivisibleByThreeOrFive ? "" : currentNumberInTheLoop;

        if (isDivisibleByThree) fizzOrBuzz += fizz();
        if (isDivisibleByFive) fizzOrBuzz += buzz();

        return fizzOrBuzz;
    }

    private String buzz() {
        countsDownFromFive = FIVE;
        try {
            return new String(Hex.decodeHex(BUZZ_HEX), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }

    private String fizz() {
        countsUpToThree = 0;
        try {
            return new String(Hex.decodeHex(FIZZ_HEX), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }
}
