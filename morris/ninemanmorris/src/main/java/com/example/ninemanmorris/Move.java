package com.example.ninemanmorris;

import java.util.ArrayList;
import java.util.Arrays;

public class Move {
    private static Move move_instance = null;

    private static Node prevNode = null;

    public String s;
    private Move(){
        s = "This is a move singleton class";
    }

    // Create Singleton class of move
    public static synchronized Move getInstance(){
        if(move_instance == null){
            move_instance = new Move();
        }
        return move_instance;
    }
    private void setPos(Chip currentChip,Node thisNode, Player currentPlayer){

        // Setting the chips on the board position
        currentChip.setLayoutX(thisNode.getLayoutX());
        currentChip.setLayoutY(thisNode.getLayoutY());
        currentChip.setChipLocation(thisNode);
        
        // Sets so that current Node knows which chip is on top of it
        // Also records and set the previous node the chip was in to NULL
        thisNode.setCurrentChip(currentChip);
//        prevNode.setCurrentChip(null);
//        prevNode = thisNode;
        
        System.out.println("IN SET POS");
        currentPlayer.setPlayerMoved(true);

    }
    public void moveAnyWhere(Chip currentChip,Node thisNode, Player currentPlayer){
        boolean initialMoveCondition = (currentPlayer.getChipsReserve() <= 9 && currentPlayer.getChipsReserve() != 0 && currentChip.getChipStatus() == ChipStatus.RESERVE);
        boolean remainingThreeMoveCondition = (currentPlayer.getChipsAlive() <= 3 && currentPlayer.getChipsReserve() == 0 && currentChip.getChipStatus() == ChipStatus.ALIVE);
        if(initialMoveCondition){
            // Can move anywhere
            this.setPos(currentChip, thisNode, currentPlayer);
            // Set status on the chip, stating it is on the board
            currentChip.setChipStatus(ChipStatus.ALIVE);
            // Reduce chips reserve
            currentPlayer.reduceChipsReserve();
        }

        if(remainingThreeMoveCondition){

            this.setPos(currentChip, thisNode, currentPlayer);
        }
        checkMillMade(thisNode, currentPlayer);
    }

    public void moveKillChip(Chip currentChip, Node thisNode){
    }

    public void moveAdjacent(Chip currentChip, Node thisNode, Player currentPlayer){
        boolean moveAdjacentCondition = (currentPlayer.getChipsReserve() == 0 && currentChip.getChipStatus() == ChipStatus.ALIVE);
        // Move adjacent
        if(Arrays.asList(thisNode.getNodeNeighbours()).contains(currentChip.getChipLocation()) && moveAdjacentCondition){
            System.out.println("IN MOVE ADJ");
            this.setPos(currentChip, thisNode, currentPlayer);
        }
    }

    //Checks whether there is a MILL by using the stored value of getCurrentChip() executed in setNode(...) function
    // [essentially this means that node needs to know what chip is on top of it for the check to work]
    // Plus it needs all the objects that has been created in the Board class.
    public void checkMillMade(Node thisNode, Player currentPlayer){
        Board board = new Board();

        //Center nodes
        Node node2 = board.getNode2();
        Node node5 = board.getNode5();
        Node node8 = board.getNode8();
        Node node10 = board.getNode10();
        Node node11 = board.getNode11();
        Node node12 = board.getNode12();
        Node node13 = board.getNode13();
        Node node14 = board.getNode14();
        Node node15 = board.getNode15();
        Node node17 = board.getNode17();
        Node node20 = board.getNode20();
        Node node23 = board.getNode23();

        //Other Edge nodes
        Node node1 = board.getNode2();
        Node node3 = board.getNode2();
        Node node4 = board.getNode2();
        Node node6 = board.getNode2();
        Node node7 = board.getNode2();
        Node node9 = board.getNode2();
        Node node16 = board.getNode2();
        Node node18 = board.getNode2();
        Node node19 = board.getNode2();
        Node node21 = board.getNode2();
        Node node22 = board.getNode2();
        Node node24 = board.getNode2();

//        ArrayList<Node> middleNodes = new ArrayList<Node>();
//        middleNodes.add(node2);
//        middleNodes.add(node5);
//        middleNodes.add(node8);
//        middleNodes.add(node10);
//        middleNodes.add(node11);
//        middleNodes.add(node12);
//        middleNodes.add(node13);
//        middleNodes.add(node14);
//        middleNodes.add(node15);
//        middleNodes.add(node17);
//        middleNodes.add(node20);
//        middleNodes.add(node23);

        //Cases for player1
        if (currentPlayer.getPlayerType() == PlayerType.PLAYER1) {
            if (thisNode.equals(node2)) {
                // 1 2 3
                if (node1.getCurrentChip().getId().startsWith("p1") && node2.getCurrentChip().getId().startsWith("p1") && node3.getCurrentChip().getId().startsWith("p1")) {
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node5)) {
                // 4 5 6
                if(node4.getCurrentChip().getId().startsWith("p1") && node5.getCurrentChip().getId().startsWith("p1") && node6.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }
                // 2 5 8
                if(node2.getCurrentChip().getId().startsWith("p1") && node5.getCurrentChip().getId().startsWith("p1") && node8.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node8)) {
                // 7 8 9
                if(node7.getCurrentChip().getId().startsWith("p1") && node8.getCurrentChip().getId().startsWith("p1") && node9.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node10)) {
                // 1 10 22
                if(node1.getCurrentChip().getId().startsWith("p1") && node10.getCurrentChip().getId().startsWith("p1") && node22.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node11)) {
                // 4 11 19
                if(node4.getCurrentChip().getId().startsWith("p1") && node11.getCurrentChip().getId().startsWith("p1") && node19.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }
                // 10 11 12
                if(node10.getCurrentChip().getId().startsWith("p1") && node11.getCurrentChip().getId().startsWith("p1") && node12.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node12)) {
                // 7 12 16
                if(node7.getCurrentChip().getId().startsWith("p1") && node12.getCurrentChip().getId().startsWith("p1") && node16.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node13)) {
                // 9 13 18
                if(node9.getCurrentChip().getId().startsWith("p1") && node13.getCurrentChip().getId().startsWith("p1") && node18.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node14)) {
                // 6 14 21
                if(node6.getCurrentChip().getId().startsWith("p1") && node14.getCurrentChip().getId().startsWith("p1") && node21.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }
                // 13 14 15
                if(node13.getCurrentChip().getId().startsWith("p1") && node14.getCurrentChip().getId().startsWith("p1") && node15.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node15)) {
                // 3 15 24
                if(node3.getCurrentChip().getId().startsWith("p1") && node15.getCurrentChip().getId().startsWith("p1") && node24.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node17)) {
                // 16 17 18
                if(node16.getCurrentChip().getId().startsWith("p1") && node17.getCurrentChip().getId().startsWith("p1") && node18.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node20)) {
                // 17 20 23
                if(node17.getCurrentChip().getId().startsWith("p1") && node20.getCurrentChip().getId().startsWith("p1") && node23.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }
                // 19 20 21
                if(node19.getCurrentChip().getId().startsWith("p1") && node20.getCurrentChip().getId().startsWith("p1") && node21.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else if (thisNode.equals(node23)) {
                // 22 23 24
                if(node22.getCurrentChip().getId().startsWith("p1") && node23.getCurrentChip().getId().startsWith("p1") && node24.getCurrentChip().getId().startsWith("p1")){
                    System.out.println("P1 Mill");
                }

            } else {
                System.out.println(currentPlayer + " Currently No Mill");
                System.out.println(node1 + " " + node2 + " " + node3);
            }
        }

        //Cases for player2
        if (currentPlayer.getPlayerType() == PlayerType.PLAYER2) {
            if (thisNode.equals(node2)) {
                // 1 2 3
                if (node1.getCurrentChip().getId().startsWith("p2") && node2.getCurrentChip().getId().startsWith("p2") && node3.getCurrentChip().getId().startsWith("p2")) {
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node5)) {
                // 4 5 6
                if(node4.getCurrentChip().getId().startsWith("p2") && node5.getCurrentChip().getId().startsWith("p2") && node6.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }
                // 2 5 8
                if(node2.getCurrentChip().getId().startsWith("p2") && node5.getCurrentChip().getId().startsWith("p2") && node8.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node8)) {
                // 7 8 9
                if(node7.getCurrentChip().getId().startsWith("p2") && node8.getCurrentChip().getId().startsWith("p2") && node9.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node10)) {
                // 1 10 22
                if(node1.getCurrentChip().getId().startsWith("p2") && node10.getCurrentChip().getId().startsWith("p2") && node22.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node11)) {
                // 4 11 19
                if(node4.getCurrentChip().getId().startsWith("p2") && node11.getCurrentChip().getId().startsWith("p2") && node19.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }
                // 10 11 12
                if(node10.getCurrentChip().getId().startsWith("p2") && node11.getCurrentChip().getId().startsWith("p2") && node12.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node12)) {
                // 7 12 16
                if(node7.getCurrentChip().getId().startsWith("p2") && node12.getCurrentChip().getId().startsWith("p2") && node16.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node13)) {
                // 9 13 18
                if(node9.getCurrentChip().getId().startsWith("p2") && node13.getCurrentChip().getId().startsWith("p2") && node18.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node14)) {
                // 6 14 21
                if(node6.getCurrentChip().getId().startsWith("p2") && node14.getCurrentChip().getId().startsWith("p2") && node21.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }
                // 13 14 15
                if(node13.getCurrentChip().getId().startsWith("p2") && node14.getCurrentChip().getId().startsWith("p2") && node15.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node15)) {
                // 3 15 24
                if(node3.getCurrentChip().getId().startsWith("p2") && node15.getCurrentChip().getId().startsWith("p2") && node24.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node17)) {
                // 16 17 18
                if(node16.getCurrentChip().getId().startsWith("p2") && node17.getCurrentChip().getId().startsWith("p2") && node18.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node20)) {
                // 17 20 23
                if(node17.getCurrentChip().getId().startsWith("p2") && node20.getCurrentChip().getId().startsWith("p2") && node23.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }
                // 19 20 21
                if(node19.getCurrentChip().getId().startsWith("p2") && node20.getCurrentChip().getId().startsWith("p2") && node21.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }

            } else if (thisNode.equals(node23)) {
                // 22 23 24
                if(node22.getCurrentChip().getId().startsWith("p2") && node23.getCurrentChip().getId().startsWith("p2") && node24.getCurrentChip().getId().startsWith("p2")){
                    System.out.println("p2 Mill");
                }
            } else {
                System.out.println(currentPlayer + " Currently No Mill");
            }
        }

    };

}
