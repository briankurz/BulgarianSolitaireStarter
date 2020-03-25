import java.util.Collection;
import java.util.*;

/** A board is a collection of piles in Bulgarian Solitaire.
 * @author jdalbey
 * @version 2014.5.8
 */
public final class Board
{
    /** The Board is a collection of piles (integers)  */
     private List<Integer> board;
     
    /** Generate a random initial configuration.
    */
    public Board()
    {
      /* randomly divide up the deck into piles */
      // create board as ArrayList
      board = new ArrayList<Integer>();
      // set numCards to 45
      int numCards = 45;
      // WHILE numCards greater than zero LOOP
      while (numCards > 0)
      {
          // select a random number between 1 and numCards
          int randNum = 1 + (int)(Math.random() * numCards);
          // add number to board
          board.add(randNum);
          // decrement numCards by number
          numCards = numCards - randNum;
      // END LOOP
      }
           
    }
    
    /** Accessor to a copy of the board.
     * @return copy of board
     */
    List<Integer> getBoard()
    {
        return new ArrayList<Integer>(board);
    }
           
    /** Setup a desired preset initial configuration.
     * @param initialConfig the desired initial collection of piles
     *        to start the game.  A String of blank-delimited numbers
     *        representing the piles, e.,g "2 2 4 5 6 7 8 9"
     * (Precondition: the numbers must total 45.)
     * (Precondition: the numbers are all positive.)
     * (Postcondition: the board is set with the given piles)
     */
    public void setBoard(String initialConfig)
    {
        // Create an array of strings from initialConfig
        String[] initialStrings = initialConfig.trim().split(" ");
        // clear the current board
        board.clear();
        // FOR each number in array of Strings LOOP
        for (String item : initialStrings)
        {
            //    Convert string to integer
            int num = Integer.parseInt(item);
            //    Add integer to board
            board.add(num);
        }
    }
    
    /** Perform the "solitaire step" to determine the next configuration.
     *  Apply the rules of the game to transform the current board
     *  into the next configuration.  Specifically, take one card from each pile, 
     *  forming a new pile with these cards.
     */   
    public void playRound()
    {
        // Declare next as ArrayList to hold the next board
        ArrayList<Integer> next = new ArrayList<Integer>();
        // numPiles = size of board
        int numPiles = board.size();
        // FOR each item in board LOOP
        for (int count = 0; count < numPiles; count++)
        {
            // remove item from board
            int item = board.remove(0);
            // decrement item by one
            item--;
            // IF item > 0 THEN
            if (item > 0)
            {
                // add it to next
                next.add(item);
            }
        }
        // make board refer to next
        board = next;
        // add numPiles to board
        board.add(numPiles);
    }
     
    /** Report if the board is in the winning configuration or not.
     * @return true if the board has piles of size 1, 2, 3, 4, 5, 6, 7, 8, and 9, 
     *         in some order; false, otherwise.
     */
    public boolean isWin()
    {
        // SET result = true
        boolean result = true;
        // IF there's not 9 piles on the board THEN 
        if (board.size() != 9)
        {
            result = false;
        }
        else
        {
            // FOR count=1 to 9 LOOP
            for (int count = 1; count < 10; count++)
            {
                // IF board doesn't contains a pile with count items THEN
                if (!board.contains(count))
                {
                    result = false;
                }
            }
        }
        return result;
    }
     
    /** Return a printable representation of this board.
     *  @return a printable representation of this board.
     */
    @Override
    public String toString()
    {
        // SET result = board.toString()
        String result = board.toString();
        // Remove brackets and replace commas with blanks in result
        result = result.replace("[","");
        result = result.replace("]","");
        result = result.replace(",","");
        return result;
    }
}    
