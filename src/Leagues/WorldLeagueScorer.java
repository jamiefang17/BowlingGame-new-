package Leagues;

/**
 * Defines the World League Bowling Game Scoring
 */
public final class WorldLeagueScorer extends Scorer {

    @Override
    public int score(int[] rolls) {
        
        int score = 0; // Initialize total score
        int roll = 0; // Initialize the current roll index

        // Iterate over each frame (total 10 frames in a bowling game)
        for (int frame = 0; frame < 10; frame++) {
            if (isStrikeFrame(rolls, roll)) { // Check if the frame is a strike
                score += 10 + rolls[roll + 1] + rolls[roll + 2]; // Add score for strike frame
                roll += 1; // Move to the next roll (strike occupies one roll)
            } else if (isSpareFrame(rolls, roll)) { // Check if the frame is a spare
                score += 10 + rolls[roll + 2]; // Add score for spare frame
                roll += 2; // Move to the next frame (spare occupies two rolls)
            } else {
                score += rolls[roll] + rolls[roll + 1]; // Add score for an open frame
                roll += 2; // Move to the next frame
            }
        }
        return score; // Return the total score for the game
    }
}
