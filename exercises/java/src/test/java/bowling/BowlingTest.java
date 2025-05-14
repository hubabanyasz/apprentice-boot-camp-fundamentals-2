package bowling;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BowlingTest {

    @Test
    public void givenRolls_whenGutterGame_thenScoreZero() {
        // given
        Bowling bowling = new Bowling();

        // when
        Integer[] rolls = new Integer[20];
        Arrays.fill(rolls, 0);
        int score = bowling.score(rolls);

        // then
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void givenRolls_whenAllOnes_thenScoreTwenty() {
        // given
        Bowling bowling = new Bowling();

        // when
        Integer[] rolls = new Integer[20];
        Arrays.fill(rolls, 1);
        int score = bowling.score(rolls);

        // then
        assertThat(score).isEqualTo(20);
    }

    @Test
    public void givenRolls_whenSpare_thenScoreCorrectValue() {
        // given
        Bowling bowling = new Bowling();

        // when
        Integer[] rolls = {5, 5, 1, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int score = bowling.score(rolls);

        // then
        assertThat(score).isEqualTo(12);
    }

    @Test
    public void givenRolls_whenStrike_thenScoreCorrectValue() {
        // given
        Bowling bowling = new Bowling();

        // when
        Integer[] rolls = {0, 0, 10, 1, 1, 0, 0, 0, 0, 0,
                0, 0, 0, 10, 1, 1, 0, 0};
        int score = bowling.score(rolls);

        // then
        assertThat(score).isEqualTo(28);
    }
}


