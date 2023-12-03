package Leagues;

/**
 * Defines the US League Bowling Game Scoring
 */
public final class USLeagueScorer extends  Scorer {

    @Override
    public int score(int[] rolls) {
        int score = 0;
        int roll = 0;

        // iterate over rolls by frame
        for (int frame = 0; frame < 10; frame++) {

            // determine the type of frame from the roll(s) score
            if (isStrikeFrame(rolls, roll)) {  
                score += scoreStrikeFrame(rolls, roll) ;
                roll += 1;  
            } else if (isSpareFrame(rolls, roll)) {
                score += scoreSpareFrame(rolls, roll);
                roll += 2;  
            } else {
                score += scoreOpenFrame(rolls, roll);;
                roll += 2;  
            }
        }

        return score;
    }

    /**
     * Calculates a strike score from a frame
     * @param rolls sequences of rolls
     * @param roll position in sequence
     * @return score of strike with bonus
     */
    private int scoreStrikeFrame(int[] rolls, int roll) {
        return 10 + rolls[roll + 1] + rolls[roll + 2];
    } 
    
    /**
     * Calculates a spare score from a frame
     * @param rolls sequences of rolls
     * @param roll position in sequence
     * @return score of spare with bonus
     */
    private int scoreSpareFrame(int[] rolls, int roll) {
        return 10 + rolls[roll + 2];
    }   

    /**
     * Calculates an score from a open frame
     * @param rolls sequences of rolls
     * @param roll position in sequence
     * @return score
     */
    private int scoreOpenFrame(int[] rolls, int roll) {
        return rolls[roll] + rolls[roll + 1];
    }
}
