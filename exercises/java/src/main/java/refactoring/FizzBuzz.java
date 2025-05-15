package refactoring;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

class FizzBuzz {

    public static final int ONE_HUNDRED = Byte.MAX_VALUE - 27;
    public static final int THREE_IN_BINARY = 0b11;
    public static final int FIVE = new int[]{0, 0, 0, 0, 0}.length;
    private int countsUpToOneHundred;
    private int countsUpToThree;
    private int countsDownFromFive = FIVE;

    String doFizzBuzzUpTo100() {
        String resultString = "";
        for (; countsUpToOneHundred < ONE_HUNDRED; countsUpToOneHundred++) {
            String fizzOrBuzzPlusASpace = addFizzOrBuzz(countsUpToOneHundred) + " ";
            resultString += fizzOrBuzzPlusASpace;
        }
        String removeLastCharacter = resultString.substring(0, resultString.length() - 1);
        return removeLastCharacter;
    }

    private String addFizzOrBuzz(int number) {
        countsUpToThree++;
        countsDownFromFive--;
        boolean isCountsDownFromFiveDivisibleByFive = countsDownFromFive == 0;
        boolean isCountsDownFromThreeDivisibleByThree = countsUpToThree == THREE_IN_BINARY;
        String currentNumberInTheLoop = String.valueOf(number + 1);
        String fizzOrBuzz = isCountsDownFromThreeDivisibleByThree || isCountsDownFromFiveDivisibleByFive ? "" : currentNumberInTheLoop;
        if (isCountsDownFromThreeDivisibleByThree) fizzOrBuzz += fizz();
        if (isCountsDownFromFiveDivisibleByFive) fizzOrBuzz += buzz();
        return fizzOrBuzz;
    }

    private String buzz() {
        countsDownFromFive = FIVE;
        try {
            byte[] buzzInHexcode = Hex.decodeHex("42757a7a");
            return new String(buzzInHexcode, StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }

    private String fizz() {
        countsUpToThree = 0;
        try {
            byte[] fizzInHexcode = Hex.decodeHex("46697a7a");
            return new String(fizzInHexcode, StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }
}
