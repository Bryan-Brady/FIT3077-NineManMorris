package com.example.ninemanmorris;

import javafx.scene.shape.Circle;



public class Node extends Circle {
    private Node[] nodeNeighbours;
    private Chip currentChip;
    // Implementation of Node
    public Node(){
        super();
    }

    public Node[]  getNodeNeighbours() {
        return nodeNeighbours;
    }

    public void setNodeNeighbours(Node[] nodeNeighbours) {
        this.nodeNeighbours = nodeNeighbours;
    }

    public Chip getCurrentChip() {
        return currentChip;
    }

    public void setCurrentChip(Chip currentChip) {
        this.currentChip = currentChip;
    }
}
