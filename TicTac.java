import java.util.*;
class TicTac
{
    static ArrayList<Integer> position_player = new ArrayList<Integer>();
    static ArrayList<Integer> position_cpu = new ArrayList<Integer>();

    public static void main(String[] args)
    {
        char[][] gameboard = {{' ','|',' ','|',' '},
                          {'-','|','-','|','-'},
                          {' ','|',' ','|',' '},
                          {'-','|','-','|','-'},
                          {' ','|',' ','|',' '}};

        while(true)
        {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter your position->1-9");
          int pos = sc.nextInt();
          while(position_player.contains(pos)||position_cpu.contains(pos))
          {
            System.out.println("position taken");
            pos = sc.nextInt();
          }
          place(gameboard,pos,"player");
 
          Random ran = new Random();
          int pos_c = ran.nextInt(9)+1;
          while(position_player.contains(pos_c)||position_cpu.contains(pos_c))
          {
            pos_c = ran.nextInt(9)+1;
          }
          place(gameboard,pos_c,"CPU");
         
          display(gameboard);
          String winner = checkwinner();
          System.out.println(winner);
       }   
    }

    public static void display(char[][] gameboard)
    {
        for(char[] row:gameboard)
        {
            for(char c:row)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void place(char[][] gameboard, int pos, String user)
    {
        char symbol = ' ';
        if(user.equals("player"))
        {
            symbol = 'X';
            position_player.add(pos);
        }
        else if(user.equals("CPU"))
        {
            symbol = 'O';
            position_cpu.add(pos);
        }

        switch(pos)
        {
            case 1:gameboard[0][0] = symbol;
            break;
            case 2:gameboard[0][2] = symbol;
            break;
            case 3:gameboard[0][4] = symbol;
            break;
            case 4:gameboard[2][0] = symbol;
            break;
            case 5:gameboard[2][2] = symbol;
            break;
            case 6:gameboard[2][4] = symbol;
            break;
            case 7:gameboard[4][0] = symbol;
            break;
            case 8:gameboard[4][2] = symbol;
            break;
            case 9:gameboard[4][4] = symbol;
            break;
            default: System.out.println("wrong move");
            break;
        }
    }

    public static String checkwinner()
    {
        List topR = Arrays.asList(1,2,3);
        List midR = Arrays.asList(4,5,6);
        List botR = Arrays.asList(7,8,9);
        List lefC = Arrays.asList(1,4,7);
        List midC = Arrays.asList(2,5,8);
        List rigC = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> win = new ArrayList<List>();
        win.add(topR);
        win.add(midR);
        win.add(botR);
        win.add(lefC);
        win.add(midC);
        win.add(rigC);
        win.add(cross1);
        win.add(cross2);

        for(List l:win)
        {
            if(position_player.containsAll(l))
            {
                return "YOU WIN!!!";
            }
            else if(position_cpu.containsAll(l))
            {
                return "CPU WINS!!!";
            }
        }
        return "";
    }
}