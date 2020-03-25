
import java.util.ArrayList;
import java.util.Random;

/**
 * A class that plays Bulgarian Solitare.
 * Version 3: Complete the isDone method.
*/
public class Piles
{
    
       /**
          Checks whether the game is done.
          @return true when the piles have size
          1, 2, 3, 4, 5, 6, 7, 8, and 9, in some order.
       */
       public boolean isDone()
       {
          /*
             We are done when we have some combination of the numbers
             1 through 9 in the piles. Therefore, we can first check to
             make sure we have exactly 9 piles so we don't waste our time.
             We also need to take care that we have the exact numbers and
             avoid a situation like  1 1 3 4 5 6 7 8 10  which means we
             still aren't done.
          */
         
         if(piles.size()!=9)//check to see if it's right number of piles first
            return false;

         for(int i=1; i<10; i++)
         {
             if(!piles.contains(i))
             {
                 return false;
             }
         }
         
         return true;
         
         //other code that i gave up on bc it didn't work
         // int total = 0;
         // boolean has1=false, has2=false, has3=false, has4=false, has5=false, has6=false;
         // boolean has7=false, has8=false, has9=false, has10=false, has11=false, has12=false;
         // for(int k=0; k<9; k++)
         // {
             // switch(piles.get(k))
             // {
                 // case 1:
                    // if(has1=false){
                        // total++;
                        // has1=true;}
                    // break;
                    
                 // case 2:
                    // if(has2=false){
                        // total++;
                        // has2=true;}
                    // break;
                    
                 // case 3:
                    // if(has3=false){
                        // total++;
                        // has3=true;}
                    // break;
                    
                 // case 4:
                    // if(has4=false){
                        // total++;
                        // has4=true;}
                    // break;
                    
                 // case 5:
                    // if(has5=false){
                        // total++;
                        // has5=true;}
                    // break;
                    
                 // case 6:
                    // if(has6=false){
                        // total++;
                        // has6=true;}
                    // break;
                    
                 // case 7:
                    // if(has7=false){
                        // total++;
                        // has7=true;}
                    // break;
                    
                 // case 8:
                    // if(has8=false){
                        // total++;
                        // has8=true;}
                    // break;
                    
                 // case 9:
                    // if(has9=false){
                        // total++;
                        // has9=true;}
                    // break;
                    
                 // case 10:
                    // if(has10=false){
                        // total++;
                        // has10=true;}
                    // break;
                    
                 // case 11:
                    // if(has11=false){
                        // total++;
                        // has11=true;}
                    // break;
                    
                 // case 12:
                    // if(has12=false){
                        // total++;
                        // has12=true;}
                    // break;
                 
                 // default:
                    // System.out.println("Error.");
                    // break;
             // }
         // }
         // if(total == 9)
            // return true;
         
         // return false;
        
    
   }

   private ArrayList<Integer> piles;

   /**
      Sets up the game randomly with some number of piles of random
      size. The pile sizes add up to 45.
   */
   public Piles(Random generator)
   {
      piles = new ArrayList<Integer>();
      /* randomly divide up the deck into piles */
      int TOTAL_SIZE = 45;  // number of cards in a deck
      int numCards = TOTAL_SIZE;
      while (numCards > 0)
      {
         int pile = generator.nextInt(numCards) + 1;
         piles.add(pile);
         numCards -= pile;
      }
   }

   /**
      Set up a pile with a known (non-random) configuration for testing.
      @param pileSizes an array of numbers whose sum is 45
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
      return piles.toString();
   }

   /**
      Play one round of the game.
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
