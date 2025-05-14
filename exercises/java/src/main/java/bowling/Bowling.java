package bowling;

import java.util.Arrays;
import java.util.stream.Stream;

public class Bowling {
    public int score(Integer[] rolls) {

        Stream<Integer> stream = Arrays.stream(rolls);

        return stream.mapToInt(Integer::intValue).sum();
    }
}
