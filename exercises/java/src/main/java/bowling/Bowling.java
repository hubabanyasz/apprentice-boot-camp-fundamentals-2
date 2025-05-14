package bowling;

public class Bowling {
    public int score(Integer[] rolls) {
        int score = 0;
        for (int i = 0; i < rolls.length; i += 2) {
            if (rolls[i] == 10) {
                score += 10 + rolls[i + 1] + rolls[i + 2];
                i--;
            } else if (rolls[i] + rolls[i + 1] == 10) {
                score += 10 + rolls[i + 2];
            } else {
                score += rolls[i] + rolls[i + 1];
            }
        }
        return score;
    }
}
