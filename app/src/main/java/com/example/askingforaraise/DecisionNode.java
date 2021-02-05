package com.example.askingforaraise;



public class DecisionNode {

    int nodeID;
    int yesID;
    int noID;
    String description;
    String question;
    DecisionNode yesNode;
    DecisionNode noNode;

    DecisionNode linkedNode;

    public DecisionNode() {}

    public DecisionNode getLinkedNode() {return linkedNode;}
    public void setLinkedNode(DecisionNode linkedNode) {this.linkedNode = linkedNode;}

    public int getNodeID() {return nodeID;}
    public void setNodeID(int nodeID) {this.nodeID = nodeID;}
    public int getYesID() {return yesID;}
    public void setYesID(int yesID) {this.yesID = yesID; }
    public int getNoID() {return noID;}
    public void setNoID(int noID) {this.noID = noID;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description; }
    public String getQuestion() {return question;}
    public void setQuestion(String question) {this.question = question;}
    public DecisionNode getYesNode() {return yesNode;}
    public void setYesNode(DecisionNode yesNode) {this.yesNode = yesNode;}
    public DecisionNode getNoNode() {return noNode;}
    public void setNoNode(DecisionNode noNode) {this.noNode = noNode;}
}

