package bowling;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class BowlingTest {

    @Test
    public void givenRolls_whenGutterGame_thenScoreZero() {
        // given
        Integer[] rolls = new Integer[20];
        // Integer[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        // 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Arrays.fill(rolls, 0);

        // when
        Bowling bowling = new Bowling();
        int score = bowling.score(rolls);

        // then
        assertEquals(0, score);
    }

    @Test
    public void givenRolls_whenAllOnes_thenScoreTwenty() {
        // given
        Integer[] rolls = new Integer[20];
        Arrays.fill(rolls, 1);

        // when
        Bowling bowling = new Bowling();
        int score = bowling.score(rolls);

        // then
        assertEquals(20, score);
    }
}
