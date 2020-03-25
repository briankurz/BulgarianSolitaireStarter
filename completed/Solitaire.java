
/**
 * Bulgarian Solitaire Simulation, from Horstmann's Big Java.
 * 
 * @author jdalbey
 * @version 2014.5.9
 */
public class Solitaire
{
    /**
     * Entry point for the application.
     * 
     * @param args the desired initial collection of piles
     *        to start the game.  An array of numbers
     *        representing the piles, e.,g "2 2 4 5 6 7 8 9"
     * For correct results, the numbers must total 45,
     * the numbers are all positive.
     */
    public static void main(String[] args)
    {
        Game game = null;
        // IF there are no args THEN
        if (args.length == 0)
        {
            //    Construct a game
            game = new Game();
        }
        else
        {
            // Append all args to a single string
            String initialConfig = "";
            for (String item : args)
            {
                initialConfig += item + " ";
            }
            //    Construct a game from string            
            game = new Game(initialConfig);
        }
        // Run the game
        game.run();
    }
}
