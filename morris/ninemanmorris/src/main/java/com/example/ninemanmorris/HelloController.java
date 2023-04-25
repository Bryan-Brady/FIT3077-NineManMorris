package com.example.ninemanmorris;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.util.Random;

public class HelloController {

    private int status;


    @FXML
    private Circle circle;

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
        double x = rand.nextInt(-100, 300);
        double y = rand.nextInt(0, 300);
        circle.setCenterX(x);
        circle.setCenterY(y);


        System.out.println(circle.getCenterX());
        System.out.println(circle.getCenterY());

        System.out.println(node6.getCenterX());
    }



}
