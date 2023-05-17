package com.example.ninemanmorris;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import com.example.ninemanmorris.Node;
import com.example.ninemanmorris.Chip;


import java.lang.reflect.Array;

public class Board {

    //Objects within this is instantiated immediately upon running HelloApplication.java
    @FXML
    private AnchorPane layout;

    private static Chip currentChip = null;

    ///////////////////////////////////////////////////
    //Player 1 //
    @FXML
    private Chip p101;

    @FXML
    private Chip p102;

    @FXML
    private Chip p103;

    @FXML
    private Chip p104;

    @FXML
    private Chip p105;

    @FXML
    private Chip p106;

    @FXML
    private Chip p107;

    @FXML
    private Chip p108;

    @FXML
    private Chip p109;


    // Player 2 //
    @FXML
    private Chip p201;

    @FXML
    private Chip p202;

    @FXML
    private Chip p203;

    @FXML
    private Chip p204;

    @FXML
    private Chip p205;

    @FXML
    private Chip p206;

    @FXML
    private Chip p207;

    @FXML
    private Chip p208;

    @FXML
    private Chip p209;

    ////////////////////////////////////////////////////////
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    @FXML
    private Node node1;

    @FXML
    private Node node2;

    @FXML
    private Node node3;

    @FXML
    private Node node4;

    @FXML
    private Node node5;

    @FXML
    private Node node6;

    @FXML
    private Node node7;

    @FXML
    private Node node8;

    @FXML
    private Node node9;

    @FXML
    private Node node10;

    @FXML
    private Node node11;

    @FXML
    private Node node12;

    @FXML
    private Node node13;

    @FXML
    private Node node14;

    @FXML
    private Node node15;

    @FXML
    private Node node16;

    @FXML
    private Node node17;

    @FXML
    private Node node18;

    @FXML
    private Node node19;

    @FXML
    private Node node20;

    @FXML
    private Node node21;

    @FXML
    private Node node22;

    @FXML
    private Node node23;

    @FXML
    private Node node24;



    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//    Random rand = new Random();

    //Here are the functions for the Button, Ball (or piece) and Node
    @FXML
    public void initialize() {
        //somehow initialize a status variable so each ball can know which node has a ball

    }
    @FXML
    void onLayoutClick() {
        //somehow initialize a status variable so each ball can know which node has a ball
    }
    @FXML
    void onChipClick(MouseEvent event) {
        //temporary testing function
//        double x = rand.nextInt(-100, 300);
//        double y = rand.nextInt(0, 300);
//        circle.setLayoutX(node1.getLayoutX());
//        circle.setLayoutY(node1.getLayoutY());
//
//
//        System.out.println(circle.getLayoutX());
//        System.out.println(circle.getLayoutY());
//
//        System.out.println("node 1 X:" + node1.getLayoutX());
//        System.out.println("node 1 Y:" + node1.getLayoutY());

        Chip thisChip = ((Chip)event.getSource());

        this.currentChip = thisChip;

        System.out.println("Piece selected: " + thisChip.getId());
        System.out.println("Piece X: " + thisChip.getLayoutX());
        System.out.println("Piece Y: " + thisChip.getLayoutY());

        System.out.println(event.getSource());
        System.out.println(event.getTarget());
        System.out.println(thisChip);
        System.out.println(thisChip.getId());

    }

    @FXML
    void onNodeClick(MouseEvent event) {
        Node thisNode = ((Node)event.getSource());
        if (this.currentChip != null) {
            setPos(this.currentChip, thisNode);
        }
    }

    public void setPos(Chip thisChip, Node thisNode) {
        thisChip.setLayoutX(thisNode.getLayoutX());
        thisChip.setLayoutY(thisNode.getLayoutY());
        this.currentChip = null;

        System.out.println("This Piece: " + thisChip.getId());
        System.out.println("Moved to: " + thisNode.getId());
        System.out.println("Current Piece X: " + thisChip.getLayoutX());
        System.out.println("Current Piece Y: " + thisChip.getLayoutY());
    }
}
