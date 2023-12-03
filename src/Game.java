import Leagues.*;

/**
 * Defines a scorable bowling game
 */
public class Game {
    private Scorer _scorer;
    private int[] _rolls = new int[21];
    private int _turn = 0;

    /**
     * Instantiates a new game using a scoring algorithm
     * @param scorer scorer calculates roll scores for the game
     */
    public Game(Scorer scorer) {
        _scorer = scorer;
    }

    /**
     * Updates game rolls with the number of pins 
     * @param pins count of pins scored
     */
    public void roll(int pins) {
        _rolls[_turn++] = pins;
    }

    /**
     * Scores the rolls of the game 
     */
    public int score() {
        return _scorer.score(_rolls);
    }
}
