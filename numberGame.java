import java.util.*;
import java.util.Random;

class numberG
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Random rad = new Random();

        String play = "GO";

        while(play.equals("GO"))
        {
            int rNum = rad.nextInt(300);
            int t = 0;
            int guess = -1;
            
            while(guess!=rNum)
            {
              System.out.println("Guess the number between 1 and 300");
              guess = scan.nextInt();
              t++;

              if(guess==rNum)
              {
                System.out.println("Your guess is right");
                System.out.println("Number of tries took by the player:"+t);
                System.out.println("Would like to play again->'GO' or 'STOP'");
                play = scan.next();
              }
              else if(guess>rNum)
              {
                System.out.println("Your guess is high");
              }
              else if(guess<rNum)
              {
                System.out.println("Your guess is low");
              }
            }
        }
        scan.close();
    }
}