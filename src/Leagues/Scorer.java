package Leagues;

/**
 * Defines an abstract type for scoring of rolls from a bowling game league
 */
public abstract class Scorer {
    
    /**
     * Calculates the score from a sequence of rolls
     * @param rolls rolls to be scored
     * @return final score for sequence of rolls
     */
    public abstract int score(int[] rolls);

    /**
     * Determines if the first roll in a frame is a strike 
     * @param rolls sequence of rolls to check
     * @param roll first roll in frame
     * @return true if strike, otherwise false
     */
    protected static boolean isStrikeFrame(int[] rolls, int roll) {
        return rolls[roll] == 10;
    }

    /**
     * Determines if the rolls in a frame are a spare 
     * @param rolls sequence of rolls to check
     * @param roll first roll in frame
     * @return true if spare, otherwise false
     */
    protected static boolean isSpareFrame(int[] rolls, int roll) {
        return rolls[roll] + rolls[roll + 1] == 10;
    }
}
