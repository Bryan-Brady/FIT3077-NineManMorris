package com.example.ninemanmorris;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Arrays;

import static kotlin.jvm.internal.Reflection.typeOf;


public class Board {

    //Objects within this is instantiated immediately upon running HelloApplication.java
    @FXML
    private AnchorPane layout;
    private Chip currentChip = null;
    private Player1 player1 = Player1.getInstance();
    private Player2 player2 = Player2.getInstance();
    private Player currentPlayer = player1;

    private Move move = Move.getInstance();
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
        node1.setNodeNeighbours(new Node[]{node2, node10});
        node2.setNodeNeighbours(new Node[]{node1, node3, node5});
        node3.setNodeNeighbours(new Node[]{node2, node15});
        node4.setNodeNeighbours(new Node[]{node5, node11});
        node5.setNodeNeighbours(new Node[]{node4, node2, node8, node6});
        node6.setNodeNeighbours(new Node[]{node5, node14});
        node7.setNodeNeighbours(new Node[]{node8, node12});
        node8.setNodeNeighbours(new Node[]{node7, node5, node9});
        node9.setNodeNeighbours(new Node[]{node8, node13});
        node10.setNodeNeighbours(new Node[]{node1, node11, node22});
        node11.setNodeNeighbours(new Node[]{node10, node4, node12, node19});
        node12.setNodeNeighbours(new Node[]{node11, node7, node16});
        node13.setNodeNeighbours(new Node[]{node9, node14, node18});
        node14.setNodeNeighbours(new Node[]{node13, node6, node21, node15});
        node15.setNodeNeighbours(new Node[]{node3, node24, node14});
        node16.setNodeNeighbours(new Node[]{node12, node17});
        node17.setNodeNeighbours(new Node[]{node16, node18, node20});
        node18.setNodeNeighbours(new Node[]{node17, node13});
        node19.setNodeNeighbours(new Node[]{node11, node20});
        node20.setNodeNeighbours(new Node[]{node19, node17, node23, node21});
        node21.setNodeNeighbours(new Node[]{node20, node14});
        node22.setNodeNeighbours(new Node[]{node10, node23});
        node23.setNodeNeighbours(new Node[]{node22, node24, node20});
        node24.setNodeNeighbours(new Node[]{node23, node15});
    }
    @FXML
    void onLayoutClick() {
        //somehow initialize a status variable so each ball can know which node has a ball
    }

    @FXML
    void onChipClick(MouseEvent event) {

        System.out.println(event.getSource());


        Chip thisChip = ((Chip)event.getSource());
        this.currentChip = thisChip.checkPlayerChip(thisChip, this.currentPlayer);
    }



    @FXML
    void onNodeClick(MouseEvent event) {
        Node thisNode = ((Node)event.getSource());

        if (this.currentChip != null) {
            move.moveAnyWhere(this.currentChip, thisNode, this.currentPlayer);
            move.moveAdjacent(this.currentChip, thisNode, this.currentPlayer);

            if(this.currentPlayer.isPlayerMoved()) {
                // Only change turn when player made a valid move
                this.currentPlayer = this.currentPlayer.playerTurn(currentPlayer);
                this.currentPlayer.setPlayerMoved(false);
                System.out.println("NODECLICK " + this.currentPlayer.getPlayerType());
            }

            // reset currentChip to null
            this.currentChip = null;

        }
    }
    @FXML
    void onLineClick(MouseEvent event){

    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

}
