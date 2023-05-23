package com.example.ninemanmorris;

import javafx.scene.shape.Circle;

import java.util.ArrayList;


public class Node extends Circle {
    private Node[] nodeNeighbours;
    private ArrayList<Line> linePart = new ArrayList<Line>();
    private Chip chip = null;
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

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public ArrayList<Line> getLinePart() {
        return linePart;
    }

    public void addLinePart(Line linePart) {
        this.linePart.add(linePart);
    }
}
