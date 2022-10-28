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
        java.io.File prc = new java.io.File("src/Data.csv");
        fileLink = new Scanner(prc);
        while (hasAnotherLine()){
            String line = getLine();

            String[] lineArray = splitLine(line);

            int NodeID=Integer.parseInt(lineArray[0]);
            int yesID=Integer.parseInt(lineArray[1]);
            int noID=Integer.parseInt(lineArray[2]);

            String description=(lineArray[3]);
            String question=(lineArray[4]);
            String option1 = (lineArray[5]);
            String option2 = (lineArray[6]);

            Node n = new Node(NodeID,yesID,noID,description,question,option1,option2);
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