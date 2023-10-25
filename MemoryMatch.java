import java.util.*;
public class MemoryMatch
{    
    public static void main(String[] args)
    {
        final int NUM_PAIRS = 4;
        int board[] = new int[NUM_PAIRS*2+1];  // ignore the ZERO element spot
        boolean printElement[] = new boolean[NUM_PAIRS*2+1];  // defaulted all to 'false'
        int temp, position1, position2,i;

        // fill board will fill with [1,1,2,2,3,3,4,4]
        int k=1;
        for (i=1; i<=NUM_PAIRS*2; i+=2)
        {
            board[i] = k;
            board[i+1] = k; 
            k++;
        }

        // shuffle the board 1000 times
        for (i=1; i<=1000; i++)
        {   // pick 2 random positions to swap
            position1 = (int) (Math.random() * (board.length-1) + 1);
            position2 = (int) (Math.random() * (board.length-1) + 1);   

            temp = board[position1];
            board[position1] = board[position2];
            board[position2] = temp;
        }

        System.out.print("SHUFFLED:    ");         
        for (i=1; i<board.length; i++)
        {
            System.out.print( " " + board[i] + " " );
        }           
        System.out.println("\n\n");
        System.out.print("printElement: ");         
        for (i=1; i<board.length; i++)
        {
            System.out.print( printElement[i] + ",     " );
        }          
        System.out.println("\n \n \n");

        int P1score=0, P2score=0, count=0;
        System.out.println("Player 1 name:");
        Scanner console=new Scanner (System.in);
        String P1=console.nextLine();
        System.out.println("Player 2 name:");
        String P2=console.nextLine();
        while (count<4)
        {           
            System.out.println(P1 + "'s 1st choice");
            int P1one=console.nextInt();
            printElement[P1one]=true;
            for (i=1; i<board.length; i++)// Print out 'board' via 'printElement'
            {
                if (printElement[i]==true)  // || i==guess1 || i==guess2)
                    System.out.print(" " +board[i] +  " ");
                else
                    System.out.print(" * ");
            }
            System.out.println();
            System.out.println(P1 + "'s 2nd choice");
            int P1two=console.nextInt();
            printElement[P1two]=true;
            for (i=1; i<board.length; i++)// Print out 'board' via 'printElement'
            {
                if (printElement[i]==true)  // || i==guess1 || i==guess2)
                    System.out.print(" " +board[i] +  " ");
                else
                    System.out.print(" * ");
            }
            printElement[P1one]=false;
            printElement[P1two]=false;
            System.out.println();
            if (board[P1one]!=board[P1two])
                System.out.println("No match. " + P2 + "'s turn");
            while (board[P1one]==board[P1two])
            {
                P1score++;
                System.out.println("Match! " + P1 + " goes again\n");
                System.out.println("Player 1: " + P1+ "  Score: " + P1score);
                System.out.println("Player 2: " + P2+ "  Score: " + P2score +"\n");                
                count++;
                P2=console.nextLine();
                System.out.println(P1 + "'s 1st choice");
                P1one=console.nextInt();
                printElement[P1one]=true;          
                for (i=1; i<board.length; i++)// Print out 'board' via 'printElement'
                {
                    if (printElement[i]==true)  // || i==guess1 || i==guess2)
                        System.out.print(" " +board[i] +  " ");
                    else
                        System.out.print(" * ");
                }
                System.out.println();
                System.out.println(P1 + "'s 2nd choice");
                P1two=console.nextInt();
                printElement[P1two]=true;
                for (i=1; i<board.length; i++)// Print out 'board' via 'printElement'
                {
                    if (printElement[i]==true)  // || i==guess1 || i==guess2)
                        System.out.print(" " +board[i] +  " ");
                    else
                        System.out.print(" * ");
                }
                printElement[P1one]=false;
                printElement[P1two]=false;
                System.out.println();
                if (board[P1one]!=board[P1two])
                    System.out.println("No match. " + P2 + "'s turn");
            }

            System.out.println(P2 + "'s 1st  choice");
            int P2one=console.nextInt();
            printElement[P2one]=true;
            for (i=1; i<board.length; i++)// Print out 'board' via 'printElement'
            {
                if (printElement[i]==true)  // || i==guess1 || i==guess2)
                    System.out.print(" " +board[i] +  " ");
                else
                    System.out.print(" * ");
            }
            System.out.println();
            System.out.println(P2 + "'s 2nd choice");
            int P2two=console.nextInt();
            printElement[P2two]=true;
            for (i=1; i<board.length; i++)// Print out 'board' via 'printElement'
            {
                if (printElement[i]==true)  // || i==guess1 || i==guess2)
                    System.out.print(" " +board[i] +  " ");
                else
                    System.out.print(" * ");
            }
            printElement[P2one]=false;
            printElement[P2two]=false;
            System.out.println();
            if (board[P2one]!=board[P2two])
                System.out.println("No match. " + P1 + "'s turn");
            while (board[P2one]==board[P2two])
            {
                P2score++;
                System.out.println("Match! " + P2 + " goes again\n");
                System.out.println("Player 1: " + P1+ "  Score: " + P1score);
                System.out.println("Player 2: " + P2+ "  Score: " + P2score + "\n");

                count++;
                P2=console.nextLine();
                System.out.println(P2 + "'s 1st choice");
                P2one=console.nextInt();
                printElement[P2one]=true;          
                for (i=1; i<board.length; i++)// Print out 'board' via 'printElement'
                {
                    if (printElement[i]==true)  // || i==guess1 || i==guess2)
                        System.out.print(" " +board[i] +  " ");
                    else
                        System.out.print(" * ");
                }
                System.out.println();
                System.out.println(P2 + "'s 2nd choice");
                P2two=console.nextInt();
                printElement[P2two]=true;
                for (i=1; i<board.length; i++)// Print out 'board' via 'printElement'
                {
                    if (printElement[i]==true)  // || i==guess1 || i==guess2)
                        System.out.print(" " +board[i] +  " ");
                    else
                        System.out.print(" * ");
                }
                printElement[P2one]=false;
                printElement[P2two]=false;
                System.out.println();
                if (board[P2one]!=board[P2two])
                    System.out.println("No match. " + P1 + "'s turn");
            }
        }
        if (P1score>P2score)
            System.out.println(P1 + " wins!");
        if (P2score>P1score)
            System.out.println(P2 + " wins!");
        else if(P1score==P2score)
            System.out.println("Tie!");

    }
}
