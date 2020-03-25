import java.util.Random;
/**
   Play the game of Bulgarian Solitare.
   Count how many turns it takes to print one turn.
*/
public class BulgarianSolitaireTester
{
   public static void main(String[] args)
   {
      Piles deck = new Piles(new Random(42));
      int turns = 0;
      while (! deck.isDone())
      {
         deck.playRound();
         turns++;
      }
      System.out.println(turns);
      System.out.println("Expected: 55");
      System.out.println(deck);
      System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 9, 8]");
      
      deck = new Piles(new Random(11));
      turns = 0;
      while (! deck.isDone())
      {
         deck.playRound();
         turns++;
      }
      System.out.println(turns);
      System.out.println("Expected: 38");
      System.out.println(deck);
      System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 9, 8]");
      
      deck = new Piles(new Random(10));
      turns = 0;
      while (! deck.isDone())
      {
         deck.playRound();
         turns++;
      }
      System.out.println(turns);
      System.out.println("Expected: 16");
      System.out.println(deck);
      System.out.println("Expected: [3, 1, 2, 4, 5, 6, 7, 9, 8]");

      deck = new Piles(new Random(185));
      turns = 0;
      while (! deck.isDone())
      {
         deck.playRound();
         turns++;
      }
      System.out.println(turns);
      System.out.println("Expected: 18");
      System.out.println(deck);
      System.out.println("Expected: [9, 1, 2, 3, 5, 4, 6, 7, 8]");
   }
}
