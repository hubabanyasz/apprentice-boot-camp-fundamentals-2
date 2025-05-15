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
        for (; countsUpToOneHundred < Byte.MAX_VALUE - 27; countsUpToOneHundred++) resultString += addFizzOrBuzz(countsUpToOneHundred) + " ";
        return resultString.substring(0, resultString.length() - 1);
    }

    private String addFizzOrBuzz(int number) {
        countsUpToThree++;
        countsDownFromFive--;
        String fizzOrBuzz = countsUpToThree == 0b11 || countsDownFromFive == 0 ? "" : String.valueOf(number + 1);
        if (countsUpToThree == 0b11) fizzOrBuzz += fizz();
        if (countsDownFromFive == 0) fizzOrBuzz += buzz();
        return fizzOrBuzz;
    }

    private String buzz() {
        countsDownFromFive = new int[]{0, 0, 0, 0, 0}.length;
        try {
            return new String(Hex.decodeHex("42757a7a"), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }

    private String fizz() {
        countsUpToThree = 0;
        try {
            return new String(Hex.decodeHex("46697a7a"), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }
}
