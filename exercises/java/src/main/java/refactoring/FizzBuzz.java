package refactoring;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

class FizzBuzz {

    private int countsUpToOneHundred;
    private int countsUpToThree;
    private int countsDownFromFive = new int[]{0, 0, 0, 0, 0}.length;

    String doFizzBuzzUpTo100() {
        String resultString = "";
        int oneHundred = Byte.MAX_VALUE - 27;
        for (; countsUpToOneHundred < oneHundred; countsUpToOneHundred++) {
            String fizzOrBuzzPlusASpace = addFizzOrBuzz(countsUpToOneHundred) + " ";
            resultString += fizzOrBuzzPlusASpace;
        }
        String removeLastCharacter = resultString.substring(0, resultString.length() - 1);
        return removeLastCharacter;
    }

    private String addFizzOrBuzz(int number) {
        countsUpToThree++;
        countsDownFromFive--;
        int threeInBinary = 0b11;
        boolean isCountsDownFromFiveDivisibleByFive = countsDownFromFive == 0;
        boolean isCountsDownFromThreeDivisibleByThree = countsUpToThree == threeInBinary;
        String currentNumberInTheLoop = String.valueOf(number + 1);
        String fizzOrBuzz = isCountsDownFromThreeDivisibleByThree || isCountsDownFromFiveDivisibleByFive ? "" : currentNumberInTheLoop;
        if (isCountsDownFromThreeDivisibleByThree) fizzOrBuzz += fizz();
        if (isCountsDownFromFiveDivisibleByFive) fizzOrBuzz += buzz();
        return fizzOrBuzz;
    }

    private String buzz() {
        int five = new int[]{0, 0, 0, 0, 0}.length;
        countsDownFromFive = five;
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
