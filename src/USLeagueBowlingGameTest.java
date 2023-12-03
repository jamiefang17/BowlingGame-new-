import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Leagues.*;

public class USLeagueBowlingGameTest {
    
    @Test
    public void allGuttersGameScoreShouldBeZero() {
        Game game = new Game(new USLeagueScorer());
        rollMany(game,20, 0); 

        assertEquals(0, game.score());
    }
    
    @Test
    public void allOnesGameShouldScoreTwenty() {
        Game game = new Game(new USLeagueScorer());
        rollMany(game,20, 1); 

        assertEquals(20, game.score());
    }

    @Test
    public void spareShouldGetNextRollBonus() {
        Game game = new Game(new USLeagueScorer());
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(game,17, 0); 

        assertEquals(16, game.score());
    }

    @Test
    public void strikeShouldGetTwoRollBonus() {
        Game game = new Game(new USLeagueScorer());
        game.roll(10);  // strike 
        game.roll(2);             
        game.roll(7);
        rollMany(game, 16, 0);
        assertEquals(28,game.score());
    }

    @Test
    public void perfectGameShouldGetPerfectScore() {
        Game game = new Game(new USLeagueScorer());
        rollMany(game, 12, 10);
        assertEquals(300, game.score());
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