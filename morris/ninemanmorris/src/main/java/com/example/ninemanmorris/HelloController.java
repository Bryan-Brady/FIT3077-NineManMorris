package com.example.ninemanmorris;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.lang.reflect.Array;

public class HelloController {

    //Objects within this is instantiated immediately upon running HelloApplication.java
    @FXML
    private AnchorPane layout;

    private static Circle currentChip = null;

    ///////////////////////////////////////////////////
    // Player 1 //
    @FXML
    private Circle p101;

    @FXML
    private Circle p102;

    @FXML
    private Circle p103;

    @FXML
    private Circle p104;

    @FXML
    private Circle p105;

    @FXML
    private Circle p106;

    @FXML
    private Circle p107;

    @FXML
    private Circle p108;

    @FXML
    private Circle p109;

    ////////////////////////////////////////////////////////
    // Player 2 //
    @FXML
    private Circle p201;

    @FXML
    private Circle p202;

    @FXML
    private Circle p203;

    @FXML
    private Circle p204;

    @FXML
    private Circle p205;

    @FXML
    private Circle p206;

    @FXML
    private Circle p207;

    @FXML
    private Circle p208;

    @FXML
    private Circle p209;
    ////////////////////////////////////////////////////////
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    @FXML
    private Circle node1;

    @FXML
    private Circle node2;

    @FXML
    private Circle node3;

    @FXML
    private Circle node4;

    @FXML
    private Circle node5;

    @FXML
    private Circle node6;

    @FXML
    private Circle node7;

    @FXML
    private Circle node8;

    @FXML
    private Circle node9;

    @FXML
    private Circle node10;

    @FXML
    private Circle node11;

    @FXML
    private Circle node12;

    @FXML
    private Circle node13;

    @FXML
    private Circle node14;

    @FXML
    private Circle node15;

    @FXML
    private Circle node16;

    @FXML
    private Circle node17;

    @FXML
    private Circle node18;

    @FXML
    private Circle node19;

    @FXML
    private Circle node20;

    @FXML
    private Circle node21;

    @FXML
    private Circle node22;

    @FXML
    private Circle node23;

    @FXML
    private Circle node24;



    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//    Random rand = new Random();

    //Here are the functions for the Button, Ball (or piece) and Node
    @FXML
    public void initialize() {
        //somehow initialize a status variable so each ball can know which node has a ball

    }

    @FXML
    void onLayoutClick(MouseEvent event) {

    }

    @FXML
    void onPieceClick(MouseEvent event) {
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

        Circle thisPiece = ((Circle)event.getSource());

        this.currentChip = thisPiece;

        System.out.println("Piece selected: " + thisPiece.getId());
        System.out.println("Piece X: " + thisPiece.getLayoutX());
        System.out.println("Piece Y: " + thisPiece.getLayoutY());

        System.out.println(event.getSource());
        System.out.println(event.getTarget());
        System.out.println(thisPiece);
        System.out.println(thisPiece.getId());

    }

    @FXML
    void onNodeClick(MouseEvent event) {
        Circle thisNode = ((Circle)event.getSource());
        if (this.currentChip != null) {
            setPos(this.currentChip, thisNode);
        }
    }

    public void setPos(Circle thisChip, Circle thisNode) {
        thisChip.setLayoutX(thisNode.getLayoutX());
        thisChip.setLayoutY(thisNode.getLayoutY());
        this.currentChip = null;

        System.out.println("This Piece: " + thisChip.getId());
        System.out.println("Moved to: " + thisNode.getId());
        System.out.println("Current Piece X: " + thisChip.getLayoutX());
        System.out.println("Current Piece Y: " + thisChip.getLayoutY());
    }
}
