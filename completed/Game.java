/** Game is a game of Bulgarian Solitaire.
 * @author jdalbey
 * @version 2014.5.9
 */
public final class Game
{   
    /** The board used by this game */
    private Board board;
    /** The number of rounds played so far */
    private int rounds;
    
    /** Construct a game with a random board.
    */  
    public Game()
    {
        // Construct a random board
        board = new Board();
        // set rounds to zero
        rounds = 0;
    }

    /** Construct a game and initialize the board.
     * @param initialConfig the desired initial collection of piles
     *        to start the game.  A String of blank-delimited numbers
     *        representing the piles, e.,g "2 2 4 5 6 7 8 9"
     * (Precondition: the numbers must total 45.)
     * (Precondition: the numbers are all positive.)
     * (Postcondition: board is built with initial config if provided)
    */  
    public Game(String initialConfig)
    {
        // Construct a board from initialConfig
        board = new Board();
        board.setBoard(initialConfig);
        // set rounds to zero
        rounds = 0;
    }

    /** Performs rounds until the game is over. */
    public void run()
    {
        // WHILE board is not a win LOOP
        while (!board.isWin())
        {
            // play a round
            board.playRound();
            // increment number of rounds
            rounds++;
            // print the board
            System.out.println(board);
        }
        // PRINT end game message with number of rounds
        System.out.println("Game over after " + rounds + " rounds.");
    }

    /** Accessor to number of rounds */
    public int getRounds()
    {
        return rounds;
    }
}