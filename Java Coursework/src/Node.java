public class Node {

    private int NodeID;
    private int yesID;
    private int noID;
    private String description;
    private String question;
    private String option1;
    private String option2;

    public Node() {
    }

    public Node(int nodeID, int yesID, int noID, String description, String question,String option1, String option2) {
        this.NodeID = nodeID;
        this.yesID = yesID;
        this.noID = noID;
        this.description =description ;
        this.question =question ;
        this.option1 = option1;
        this.option2 = option2;
        
    }

    public int getNodeID(){return NodeID;}
    public void setNodeID(int nodeID){NodeID = nodeID;}

    public int getyesID(){return yesID;}
    public void setyesID(int yesID){this.yesID = yesID;}

    public int getnoID(){return noID;}
    public void setnoID(int noID){this.noID = noID;}

    public String getDescription(){return description;}
    public void setNodeID(String description){this.description = description;}
 
    public String getQuestion(){return question;}
    public void setQuestion(String question){this.question = question;}

    public String getOption1(){return option1;}
    public void setOption1(String option1){this.option1 = option1;}

    public String getOption2(){return option2;}
    public void setOption2(String option2){this.option2 = option2;}

    @Override
    public String toString() {
        return "Node - " +
                "NodeID:" + NodeID +
                ", yesID:" + yesID +
                ", noID:" + noID +
                ", description:" + description +
                ", Question:" + question+
                ", Option 1" + option1+
                ", Option 2 " + option2+"\n";
    }
}
