package bowling;

public class Bowling {
    public int score(Integer[] rolls) {

        int score = 0;
        for (int i = 0; i < rolls.length; i += 2) {
            int frame = rolls[i] + rolls[i + 1];

            if (frame == 10) {
                score += frame + rolls[i + 2];
            } else {
                score += frame;
            }
        }
        return score;
    }
}
