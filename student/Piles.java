import java.util.ArrayList;
import java.util.Random;

/**
 * A class that plays Bulgarian Solitare. 
 * Version 1: Implement the playRound and toString methods.
 */
public class Piles
{
    private ArrayList<Integer> piles;

    /**
     * Create a set of piles with a known (non-random) configuration for testing.
     * @param pileSizes an array of numbers whose sum is 45
     */
    public Piles(int[] pileSizes)
    {
        piles = new ArrayList<>();
        for (int s : pileSizes)
            piles.add(s);
    }

    /**
     * Return the string representation of the piles.
     * @return the string representation of the piles.
     */
    public String toString()
    {
        String pilesStringRep = "[";
        
        for(int s : piles)
        {
            pilesStringRep += s+", ";
        }
        pilesStringRep += "]";
        
        return pilesStringRep;
    }

    /**
     * Play one round of the game.
     */
    public void playRound()
    {
        int newPile = 0;
        
        for(int i=0; i < piles.size(); i++)//Go through current piles and subtract 1
        {
            piles.set(i, piles.get(i)-1);
            newPile++;
        }
        
        for(int i = piles.size()-1; i >= 0; i--)//Remove any piles that are of size 0 after the subtract 1
        {
            if(piles.get(i) == 0)
            {
                piles.remove(i);
            }
        }
        
        piles.add(newPile);//Add new pile to end of the ArrayList
    }
}
