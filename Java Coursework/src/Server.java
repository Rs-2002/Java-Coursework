import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    //DATA
    private ArrayList<Node> nodes;
    private Scanner fileLink;

    
    //CONSTRUCTOR
    public Server() throws FileNotFoundException {   
        
        nodes = new ArrayList<Node>();
        java.io.File prc = new java.io.File("src/Data.csv"); // Creating the adventure map using a csv file containing all necessary data
        fileLink = new Scanner(prc);
        while (hasAnotherLine()){ // Repeats creating the arrayList of Nodes for each line in the csv
            String line = getLine();

            String[] lineArray = splitLine(line);

            int NodeID=Integer.parseInt(lineArray[0]); // The ID of the line used for identification when traversing
            int yesID=Integer.parseInt(lineArray[1]);  // The reference for the ID of the Yes option 
            int noID=Integer.parseInt(lineArray[2]); // The reference for the ID of the No option 

            String description=(lineArray[3]); //String description of what is happening
            String question=(lineArray[4]); //String question for the next decision
            String option1 = (lineArray[5]); //String for one option of what to do next
            String option2 = (lineArray[6]); //String for second option of what to do next

            Node n = new Node(NodeID,yesID,noID,description,question,option1,option2); //Adds the above information into a node
            nodes.add(n); 
        }
    }
        
    //METHODS

    public String getLine() {
        return fileLink.nextLine();
    }
    public boolean hasAnotherLine(){
          return fileLink.hasNext(); 
        }
        
    public void close(){ fileLink.close();}


    public String toString() {
        String string = "";
        for(Node node:nodes){string +=node.toString()+"\n";}
        return string;
    }

    private String[] splitLine (String line){return line.split(",");}

    //finds and returns the description of the current node
    public String findIDReturnDescription(int currentNode){

        //loop through each item in arraylist
        for(Node node: nodes){
            int findID = node.getNodeID();
            if(findID == currentNode){
                String description = node.getDescription();
                String question = node.getQuestion();
                String sentence = description.trim() +"\n"+ question.trim();
                return sentence;
                
            }

        }

        return "NO MATCH FOUND";
    }
    //finds and returns the description for option 2 of the current node
    public String findIDReturnOption1(int currentNode){
        for(Node node: nodes){
            int findID = node.getNodeID();
            if(findID == currentNode){
                String option1 = node.getOption1();

                String sentence = option1.trim();
                return sentence;
                
            }

        }
        return "NO MATCH FOUND";
    }
    //finds the description for option 2 of the current node
    public String findIDReturnOption2(int currentNode){
        for(Node node: nodes){
            int findID = node.getNodeID();
            if(findID == currentNode){
                String option2 = node.getOption2();

                String sentence = option2.trim();
                return sentence;
                
            }

        }
        return "NO MATCH FOUND";
    }
/////// findNextNode() used to find the next node in the story by getting the ID from the Yes/No ID of the current node
    public int findNextNode(int currentNode, int nextChoice){

        for(Node node:nodes){
            int findID = node.getNodeID();
            
            if(findID == currentNode){
                if (nextChoice == 1){
                    nextChoice = node.getyesID();
                    
                }
                else if (nextChoice == 2){
                    nextChoice = node.getnoID();
                    
                }
            }
        }
        return nextChoice;
    }

    public int nodeArrayLength(){
        int nodeArrayLength = nodes.size();
        return nodeArrayLength;
    }

    public boolean checkAllowed(int nextChoice){
        if (1== nextChoice || nextChoice ==2){
            return true;
        }
        else{
            return false;
        }

    }
}
