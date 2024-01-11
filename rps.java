import java.util.Random;
import java.util.Scanner;

public class rps 
{
  public static void main(String[] args) 
  {    
    Scanner sc = new Scanner(System.in);
    
    while (true)
     {
      String[] item = {"R", "P", "S"};
      String choice_c = item[new Random().nextInt(item.length)];
      
      String choice_p;
      
      while(true) 
      {
        System.out.println("Enter your move (R, P, or S)");
        choice_p = sc.nextLine();
        if (choice_p.equals("R") || choice_p.equals("P") || choice_p.equals("S")) 
        {
          break;
        }
        System.out.println(choice_p + " is not a valid move.");
      }
      
      System.out.println("Computer played: " + choice_c);
      
      if (choice_p.equals(choice_c)) 
      {
        System.out.println("The game was a tie!");
      }
      else if (choice_p.equals("R")) 
      {
        if (choice_c.equals("P")) 
        {
          System.out.println("You lose!");
          
        } 
        else if (choice_c.equals("S")) 
        {
          System.out.println("You win!");
        }
      }
      else if (choice_p.equals("P")) 
      {
        if (choice_c.equals("R")) 
        {
          System.out.println("You win!");
          
        } 
        else if (choice_c.equals("S")) 
        {
          System.out.println("You lose!");
        }
      }
      else if (choice_p.equals("S")) 
      {
        if (choice_c.equals("P")) 
        {
          System.out.println("You win!");
          
        } 
        else if (choice_c.equals("R")) 
        {
          System.out.println("You lose!");
        }
      }
      
      System.out.println("Play again? (Yes or NO)");
      String wish = sc.nextLine();
      
      if (!wish.equals("Yes")) {
        break;
      }
    }
    sc.close();
  }
}