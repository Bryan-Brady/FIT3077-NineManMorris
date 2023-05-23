package com.example.ninemanmorris;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

<<<<<<< Updated upstream


public class Node extends Circle {

    private static Node node1;
    
    private static Node node2;
    
    private static Node node3;
    
    private static Node node4;
    
    private static Node node5;
    
    private static Node node6;
    
    private static Node node7;
    
    private static Node node8;
    
    private static Node node9;
    
    private static Node node10;
    
    private static Node node11;
    
    private static Node node12;
    
    private static Node node13;
    
    private static Node node14;
    
    private static Node node15;
    
    private static Node node16;
    
    private static Node node17;
    
    private static Node node18;
    
    private static Node node19;
    
    private static Node node20;
    
    private static Node node21;
    
    private static Node node22;

    private static Node node23;
    private static Node node24;
    private Node[] nodeNeighbours;
    private Chip currentChip = null;
=======
import java.util.ArrayList;


public class Node extends Circle {
    private Node[] nodeNeighbours;
    private ArrayList<Line> linePart = new ArrayList<Line>();
    private Chip chip = null;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public Chip getCurrentChip() {
        return currentChip;
    }

    public void setCurrentChip(Chip currentChip) {
        this.currentChip = currentChip;
    }

    //Getters and setters for all nodes, nodes are set in initialize method on Board.java

    public static Node getNode1() {
        return node1;
    }

    public static void setNode1(Node node1) {
        Node.node1 = node1;
    }

    public static Node getNode2() {
        return node2;
    }

    public static void setNode2(Node node2) {
        Node.node2 = node2;
    }

    public static Node getNode3() {
        return node3;
    }

    public static void setNode3(Node node3) {
        Node.node3 = node3;
    }

    public static Node getNode4() {
        return node4;
    }

    public static void setNode4(Node node4) {
        Node.node4 = node4;
    }

    public static Node getNode5() {
        return node5;
    }

    public static void setNode5(Node node5) {
        Node.node5 = node5;
    }

    public static Node getNode6() {
        return node6;
    }

    public static void setNode6(Node node6) {
        Node.node6 = node6;
    }

    public static Node getNode7() {
        return node7;
    }

    public static void setNode7(Node node7) {
        Node.node7 = node7;
    }

    public static Node getNode8() {
        return node8;
    }

    public static void setNode8(Node node8) {
        Node.node8 = node8;
    }

    public static Node getNode9() {
        return node9;
    }

    public static void setNode9(Node node9) {
        Node.node9 = node9;
    }

    public static Node getNode10() {
        return node10;
    }

    public static void setNode10(Node node10) {
        Node.node10 = node10;
    }

    public static Node getNode11() {
        return node11;
    }

    public static void setNode11(Node node11) {
        Node.node11 = node11;
    }

    public static Node getNode12() {
        return node12;
    }

    public static void setNode12(Node node12) {
        Node.node12 = node12;
    }

    public static Node getNode13() {
        return node13;
    }

    public static void setNode13(Node node13) {
        Node.node13 = node13;
    }

    public static Node getNode14() {
        return node14;
    }

    public static void setNode14(Node node14) {
        Node.node14 = node14;
    }

    public static Node getNode15() {
        return node15;
    }

    public static void setNode15(Node node15) {
        Node.node15 = node15;
    }

    public static Node getNode16() {
        return node16;
    }

    public static void setNode16(Node node16) {
        Node.node16 = node16;
    }

    public static Node getNode17() {
        return node17;
    }

    public static void setNode17(Node node17) {
        Node.node17 = node17;
    }

    public static Node getNode18() {
        return node18;
    }

    public static void setNode18(Node node18) {
        Node.node18 = node18;
    }

    public static Node getNode19() {
        return node19;
    }

    public static void setNode19(Node node19) {
        Node.node19 = node19;
    }

    public static Node getNode20() {
        return node20;
    }

    public static void setNode20(Node node20) {
        Node.node20 = node20;
    }

    public static Node getNode21() {
        return node21;
    }

    public static void setNode21(Node node21) {
        Node.node21 = node21;
    }

    public static Node getNode22() {
        return node22;
    }

    public static void setNode22(Node node22) {
        Node.node22 = node22;
    }

    public static Node getNode23() {
        return node23;
    }

    public static void setNode23(Node node23) {
        Node.node23 = node23;
    }

    public static Node getNode24() {
        return node24;
    }

    public static void setNode24(Node node24) {
        Node.node24 = node24;
=======
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
>>>>>>> Stashed changes
    }
}
