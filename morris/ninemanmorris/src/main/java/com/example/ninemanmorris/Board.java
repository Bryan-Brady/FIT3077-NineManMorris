package com.example.ninemanmorris;

import javafx.fxml.FXML;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.Arrays;

=======
>>>>>>> Stashed changes
import static kotlin.jvm.internal.Reflection.typeOf;


public class Board {

    //Objects within this is instantiated immediately upon running HelloApplication.java
    @FXML
    private AnchorPane layout;
    private Chip currentChip = null;
    private Player1 player1 = Player1.getInstance();
    private Player2 player2 = Player2.getInstance();
    private Player currentPlayer = player1;
<<<<<<< Updated upstream

    private Move move = Move.getInstance();
=======

    private Rules rules = new Rules();
    private Move move = Move.getInstance();



>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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

//    public Board(Node node1, Node node2, Node node3, Node node4, Node node5, Node node6, Node node7, Node node8, Node node9, Node node10, Node node11, Node node12, Node node13, Node node14, Node node15, Node node16, Node node17, Node node18, Node node19, Node node20, Node node21, Node node22, Node node23, Node node24) {
//        this.node1 = node1;
//        this.node2 = node2;
//        this.node3 = node3;
//        this.node4 = node4;
//        this.node5 = node5;
//        this.node6 = node6;
//        this.node7 = node7;
//        this.node8 = node8;
//        this.node9 = node9;
//        this.node10 = node10;
//        this.node11 = node11;
//        this.node12 = node12;
//        this.node13 = node13;
//        this.node14 = node14;
//        this.node15 = node15;
//        this.node16 = node16;
//        this.node17 = node17;
//        this.node18 = node18;
//        this.node19 = node19;
//        this.node20 = node20;
//        this.node21 = node21;
//        this.node22 = node22;
//        this.node23 = node23;
//        this.node24 = node24;
//    }
=======
    private Node node1 = new Node();
    @FXML
    private Node node2 = new Node();
    @FXML
    private Node node3 = new Node();
    @FXML
    private Node node4 = new Node();
    @FXML
    private Node node5 = new Node();
    @FXML
    private Node node6 = new Node();
    @FXML
    private Node node7 = new Node();
    @FXML
    private Node node8 = new Node();
    @FXML
    private Node node9 = new Node();
    @FXML
    private Node node10 = new Node();
    @FXML
    private Node node11 = new Node();
    @FXML
    private Node node12 = new Node();
    @FXML
    private Node node13 = new Node();
    @FXML
    private Node node14 = new Node();
    @FXML
    private Node node15 = new Node();
    @FXML
    private Node node16 = new Node();
    @FXML
    private Node node17 = new Node();
    @FXML
    private Node node18 = new Node();
    @FXML
    private Node node19 = new Node();
    @FXML
    private Node node20 = new Node();
    @FXML
    private Node node21 = new Node();
    @FXML
    private Node node22 = new Node();
    @FXML
    private Node node23 = new Node();
    @FXML
    private Node node24 = new Node();
    private Line line1 = new Line();
    private Line line2 = new Line();
    private Line line3 = new Line();
    private Line line4 = new Line();
    private Line line5 = new Line();
    private Line line6 = new Line();
    private Line line7 = new Line();
    private Line line8 = new Line();
    private Line line9 = new Line();
    private Line line10 = new Line();
    private Line line11 = new Line();
    private Line line12 = new Line();
    private Line line13 = new Line();
    private Line line14 = new Line();
    private Line line15 = new Line();
    private Line line16 = new Line();

    private Chip[] chipsP1Array = {p101, p102, p103, p104, p105, p106, p107, p108, p109};
    private Chip[] chipsP2Array = {p201, p202, p203, p204, p205, p206, p207, p208, p209};
//    private Node[] nodeArray = {node1, node2, node3, node4, node5, node6, node7, node8, node9, node10,
//                                node11, node12, node13, node14, node15, node16, node17, node18, node19,
//                                node20,node21, node22, node23, node24};
    private Line[] lineArray = {line1, line2, line3, line4, line5, line6, line7, line8,
                                line9, line10, line11, line12, line13, line14, line15,
                                line16};
>>>>>>> Stashed changes

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
//    Random rand = new Random();

    //Here are the functions for the Button, Ball (or piece) and Node
    @FXML
    public void initialize() {
<<<<<<< Updated upstream
        //somehow initialize a status variable so each ball can know which node has a ball
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

        node1.setNode1(node1);
        node2.setNode2(node2);
        node3.setNode3(node3);
        node4.setNode4(node4);
        node5.setNode5(node5);
        node6.setNode6(node6);
        node7.setNode7(node7);
        node8.setNode8(node8);
        node9.setNode9(node9);
        node10.setNode10(node10);
        node11.setNode11(node11);
        node12.setNode12(node12);
        node13.setNode13(node13);
        node14.setNode14(node14);
        node15.setNode15(node15);
        node16.setNode16(node16);
        node17.setNode17(node17);
        node18.setNode18(node18);
        node19.setNode19(node19);
        node20.setNode20(node20);
        node21.setNode21(node21);
        node22.setNode22(node22);
        node23.setNode23(node23);
        node24.setNode24(node24);
=======
        // Initializing line groups
        line1.setLineMember(new Node[]{node1, node2, node3});
        line2.setLineMember(new Node[]{node3, node15, node24});
        line3.setLineMember(new Node[]{node24, node23, node22});
        line4.setLineMember(new Node[]{node22, node10, node1});
        line5.setLineMember(new Node[]{node4, node5, node6});
        line6.setLineMember(new Node[]{node6, node14, node21});
        line7.setLineMember(new Node[]{node19, node20, node21});
        line8.setLineMember(new Node[]{node4, node11, node19});
        line9.setLineMember(new Node[]{node7, node8, node9});
        line10.setLineMember(new Node[]{node9, node13, node18});
        line11.setLineMember(new Node[]{node18, node17, node16});
        line12.setLineMember(new Node[]{node16, node12, node7});
        line13.setLineMember(new Node[]{node2, node5, node8});
        line14.setLineMember(new Node[]{node15, node14, node13});
        line15.setLineMember(new Node[]{node23, node20, node17});
        line16.setLineMember(new Node[]{node10, node11, node12});

        for(Line line : lineArray){
            for(Node node : line.getLineMember()){
                node.addLinePart(line);
            }
        }
>>>>>>> Stashed changes
    }
    @FXML
    void onLayoutClick(MouseEvent event) {
        //somehow initialize a status variable so each ball can know which node has a ball

//        if(this.currentChip == null){
//            Glow glow = new Glow();
//            glow.setLevel(0);
//            this.currentChip.setEffect(glow);
//        }
    }

    @FXML
    void onChipClick(MouseEvent event) {
<<<<<<< Updated upstream

        System.out.println(event.getSource());
=======
>>>>>>> Stashed changes



        Glow glow = new Glow();
        glow.setLevel(.8);
        Chip thisChip = ((Chip)event.getSource());
<<<<<<< Updated upstream
        this.currentChip = thisChip.checkPlayerChip(thisChip, this.currentPlayer);
=======
        thisChip.setEffect(glow);


        if(!this.currentPlayer.hasMill()) {
            this.currentChip = thisChip.checkPlayerChip(thisChip, this.currentPlayer);
        }else{
            // Selecting a different chip
            if(thisChip.checkPlayerChip(thisChip, this.currentPlayer.checkPlayerTurn(currentPlayer)) != null && thisChip.getChipStatus() == ChipStatus.ALIVE){
                this.currentChip = thisChip;
                move.moveKillChip(this.currentChip, this.currentPlayer);
                if(this.currentPlayer.isPlayerMoved()) {
                    this.currentPlayer = this.currentPlayer.checkPlayerTurn(currentPlayer);
                }
            }else{
                this.currentChip = null;
            }
        }
>>>>>>> Stashed changes
    }



    @FXML
    void onNodeClick(MouseEvent event) {

        Node thisNode = ((Node)event.getSource());

<<<<<<< Updated upstream
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

=======

        if (this.currentChip != null) {
            Glow glow = new Glow();
            glow.setLevel(0);
            this.currentChip.setEffect(glow);
            move.moveAnyWhere(this.currentChip, thisNode, this.currentPlayer);
            move.moveAdjacent(this.currentChip, thisNode, this.currentPlayer);
            rules.setMillStatusBoard(lineArray);
            if(rules.isGameEnd(player1, player2, chipsP1Array, chipsP2Array) != null){
                System.out.println("The Winner Is : " + rules.isGameEnd(player1, player2, chipsP1Array, chipsP2Array).getPlayerType());
            }
            // Check if player have three in a row
            if(!this.currentPlayer.hasMill()) {
                // Go in this if, only if player don't have three in a row
                // Changing player turn
                if(this.currentPlayer.isPlayerMoved()) {
                    this.currentPlayer = this.currentPlayer.checkPlayerTurn(currentPlayer);
                }
            }
            this.currentChip = null;
>>>>>>> Stashed changes
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
