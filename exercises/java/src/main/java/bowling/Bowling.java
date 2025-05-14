package bowling;

public class Bowling {
    public int score(Integer[] rolls) {
        int score = 0;
        boolean strike = false;

        for (int i = 0; i < rolls.length; i += 2) {
            int frame = rolls[i] + rolls[i + 1];
            if (rolls[i] == 10) {
                strike = true;
                score += 10;
                i--;
            } else if (frame == 10) {
                score += frame + rolls[i + 2];
            } else {
                score += frame;
                if (strike) {
                    score += frame;
                    strike = false;
                }
            }
        }
        return score;
    }
}
