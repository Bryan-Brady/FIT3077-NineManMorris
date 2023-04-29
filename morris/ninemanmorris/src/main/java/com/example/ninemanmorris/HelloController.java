package com.example.ninemanmorris;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.util.Random;

public class HelloController {

    private static Circle currentChip = null;


    @FXML
    private Circle piece1;

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
    Random rand = new Random();


    @FXML
    public void initialize() {
        //somehow initialize a status variable so each ball can know which node has a ball

    }

    @FXML
    void onBallClick(MouseEvent event) {
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

        this.currentChip =  piece1;
        System.out.println("Piece selected: " + piece1.getId());
        System.out.println("Piece X: " + piece1.getLayoutX());
        System.out.println("Piece Y: " + piece1.getLayoutY());

    }


    @FXML
    void onNode1Click(MouseEvent event) {
        if (this.currentChip != null) {
            setPos(this.currentChip, node1);
        }
    }

    @FXML
    void onNode2Click(MouseEvent event) {
        if (this.currentChip != null) {
            setPos(this.currentChip, node2 );
        }
    }

    @FXML
    void onNode3Click(MouseEvent event) {
        if (this.currentChip != null) {
            setPos(this.currentChip, node3);
        }
    }

    @FXML
    void onNode4Click(MouseEvent event) {
        if (this.currentChip != null) {
            setPos(this.currentChip, node4 );
        }
    }

    @FXML
    void onNode5Click(MouseEvent event) {
        if (this.currentChip != null) {
            setPos(this.currentChip, node5 );
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