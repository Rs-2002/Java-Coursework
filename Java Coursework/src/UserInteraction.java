import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInteraction {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner io = new Scanner(System.in);
        Server server = new Server();
        //System.out.println(server.nodeArrayLength());
        //System.out.println(server.toString());
        int currentNode = 0;
        boolean playGame = true;
        while (playGame == true){
            while (currentNode>=0){
                System.out.println(server.findIDReturnDescription(currentNode));
                System.out.println(server.findIDReturnOption1(currentNode)); 
                System.out.println(server.findIDReturnOption2(currentNode));
                System.out.println("Enter Option 1 or 2:");

                int nextChoice = io.nextInt();
                boolean allowed = server.checkAllowed(nextChoice);
                
                while(allowed == false){
                    System.out.println("Enter 1 or 2");
                    nextChoice = io.nextInt();
                    allowed = server.checkAllowed(nextChoice);
                }

                currentNode = server.findNextNode(currentNode,nextChoice);
                
            }
            System.out.println("do you want to start again? (1 For yes 2 for No)");
            int choice = io.nextInt();
            if (choice == 1){
                playGame = true;
                currentNode = 0;
            }
            else if (choice == 2){
                playGame = false;
            }
        }
        }
    }


