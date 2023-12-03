import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Leagues.Scorer;
import Leagues.WorldLeagueScorer;

public class WorldLeagueBowlingGameTest {
    
    @Test
    public void allGuttersGameScoreShouldBeZero() {
        Game game = new Game(new WorldLeagueScorer());
        rollMany(game,20, 0); 

        assertEquals(0, game.score());
    }
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
    /**
     * For many rolls, record a number of pins per roll in a game
     * @param game Game to repeat rolls in
     * @param rolls Number of rolls to repeat
     * @param pins Number of pins per roll to record
     */
    private static void rollMany(Game game, int rolls, int pins) {
        for(int roll = 0; roll < rolls; roll++){
            game.roll(pins);
        }
    }
}
