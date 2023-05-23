package com.example.ninemanmorris;

<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.Arrays;

public class Move {
    private static Move move_instance = null;

    private static Node prevNode = null;
=======
public class Move {
    private static Move move_instance = null;
    private static Rules rules = new Rules();
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
        currentChip.setChipLocation(thisNode);
        
        // Sets so that current Node knows which chip is on top of it
        // Also records and set the previous node the chip was in to NULL
        thisNode.setCurrentChip(currentChip);

        System.out.println("Node: " + thisNode.getId() + " has the current chip: " + thisNode.getCurrentChip());
//        prevNode.setCurrentChip(null);
//        prevNode = thisNode;
        
        System.out.println("IN SET POS");
        currentPlayer.setPlayerMoved(true);

    }
    public void moveAnyWhere(Chip currentChip,Node thisNode, Player currentPlayer){
        boolean initialMoveCondition = (currentPlayer.getChipsReserve() <= 9 && currentPlayer.getChipsReserve() != 0 && currentChip.getChipStatus() == ChipStatus.RESERVE);
        boolean remainingThreeMoveCondition = (currentPlayer.getChipsAlive() <= 3 && currentPlayer.getChipsReserve() == 0 && currentChip.getChipStatus() == ChipStatus.ALIVE);
        if(initialMoveCondition){
=======
        if(currentChip.getChipLocation() != null){
            // Remove connection from current chip location to the chip that just moved
            currentChip.getChipLocation().setChip(null);
        }
        // Make new connection between current location and chip
        currentChip.setChipLocation(thisNode);
        thisNode.setChip(currentChip);

        // Check three in a row here
        for(Line line : thisNode.getLinePart()) {
//            System.out.println(rules.isMillMade(line));
            if (rules.isMillMade(line) && !currentPlayer.hasMill()) {
                System.out.println("IN IF STATEMENT MILL MOVE");
//                System.out.println("IT IS THREE IN A ROW");
                currentPlayer.setMillMade(true);
            }
        }
        // If not here, then if you click chip and click a node, then it is going to be counted as a valid movement
        if(!currentPlayer.isPlayerMoved())currentPlayer.setPlayerMoved(true);


    }
    public void moveAnyWhere(Chip currentChip,Node thisNode, Player currentPlayer){
        if(rules.isInitialMoveCondition(currentChip, currentPlayer)){
            currentPlayer.addChipsAlive();
>>>>>>> Stashed changes
            // Can move anywhere
            this.setPos(currentChip, thisNode, currentPlayer);
            // Set status on the chip, stating it is on the board
            currentChip.setChipStatus(ChipStatus.ALIVE);
            // Reduce chips reserve
            currentPlayer.reduceChipsReserve();
<<<<<<< Updated upstream
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
=======

        }

        if(rules.isRemainingThreeMoveCondition(currentChip, currentPlayer)){
            this.setPos(currentChip, thisNode, currentPlayer);
        }
    }

    public void moveKillChip(Chip targetChip, Player currentPlayer){
        System.out.println(rules.chipIsPartOfMill(targetChip));
        if(!rules.chipIsPartOfMill(targetChip)) {
            if(targetChip.getChipLocation() != null){
                // Remove connection from current chip location to the chip that just moved
                targetChip.getChipLocation().setChip(null);
            }
            // if click valid chip
            if (targetChip.getId().startsWith("p1")) {
                targetChip.setLayoutX(61);
                targetChip.setLayoutY(500);
            } else {
                targetChip.setLayoutX(509);
                targetChip.setLayoutY(500);
            }
            // Set chip status to be dead
            targetChip.setChipStatus(ChipStatus.DEAD);
            currentPlayer.reduceChipsAlive();
            currentPlayer.setPlayerMoved(true);
            // Setting back to not three in a row for player
            currentPlayer.setMillMade(false);
        }
    }

    public void moveAdjacent(Chip currentChip, Node thisNode, Player currentPlayer){

        if(rules.isMoveAdjacent(currentChip, thisNode, currentPlayer)){
>>>>>>> Stashed changes
            this.setPos(currentChip, thisNode, currentPlayer);
        }
    }

<<<<<<< Updated upstream
    //Checks whether there is a MILL by using the stored value of getCurrentChip() executed in setNode(...) function
    // [essentially this means that node needs to know what chip is on top of it for the check to work]
    // Plus it needs all the objects that has been created in the Board class.
    public void checkMillMade(Node thisNode, Player currentPlayer) {

        System.out.println("-- CHECK MILL MADE BY " + currentPlayer.getPlayerType() + " --");

        //Cases for player1
        //THESE ARE PLAYER 1 MILLS
        //Basically only check if there is 3 pieces that forms a mill only
        if (currentPlayer.getPlayerType() == PlayerType.PLAYER1) {

            // 1 2 3
            System.out.println("Nodes [1 2 3]");
            //First, checks if pieces of node1 OR node3 is empty. If empty, do not do anything
            if (Node.getNode1().getCurrentChip() == null || Node.getNode2().getCurrentChip() == null || Node.getNode3().getCurrentChip() == null) {
                System.out.println("NO MILL");
            }
            //If asses first and second, third checks if the pieces was player 1 pieces. If so, its a mill
            else if (Node.getNode1().getCurrentChip().getId().startsWith("p1") && Node.getNode2().getCurrentChip().getId().startsWith("p1") && Node.getNode3().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [1 2 3]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }


            // 4 5 6
            System.out.println("Nodes [4 5 6]");
            if (Node.getNode4().getCurrentChip() == null || Node.getNode5().getCurrentChip() == null || Node.getNode6().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode4().getCurrentChip().getId().startsWith("p1") && Node.getNode5().getCurrentChip().getId().startsWith("p1") && Node.getNode6().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [4 5 6]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 2 5 8
            System.out.println("Nodes [2 5 8]");
            if (Node.getNode2().getCurrentChip() == null || Node.getNode5().getCurrentChip() == null || Node.getNode8().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode2().getCurrentChip().getId().startsWith("p1") && Node.getNode5().getCurrentChip().getId().startsWith("p1") && Node.getNode8().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [2 5 8]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 7 8 9
            System.out.println("Nodes [7 8 9]");
            if (Node.getNode7().getCurrentChip() == null || Node.getNode8().getCurrentChip() == null || Node.getNode9().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode7().getCurrentChip().getId().startsWith("p1") && Node.getNode8().getCurrentChip().getId().startsWith("p1") && Node.getNode9().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [7 8 9]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 1 10 22
            System.out.println("Nodes [1 10 22]");
            if (Node.getNode1().getCurrentChip() == null || Node.getNode10().getCurrentChip() == null || Node.getNode22().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode1().getCurrentChip().getId().startsWith("p1") && Node.getNode10().getCurrentChip().getId().startsWith("p1") && Node.getNode22().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [1 10 22]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 4 11 19
            System.out.println("Nodes [4 11 19]");
            if (Node.getNode4().getCurrentChip() == null || Node.getNode11().getCurrentChip() == null || Node.getNode19().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode4().getCurrentChip().getId().startsWith("p1") && Node.getNode11().getCurrentChip().getId().startsWith("p1") && Node.getNode19().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [4 11 19]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 10 11 12
            System.out.println("Nodes [10 11 12]");
            if (Node.getNode10().getCurrentChip() == null || Node.getNode11().getCurrentChip() == null || Node.getNode12().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode10().getCurrentChip().getId().startsWith("p1") && Node.getNode11().getCurrentChip().getId().startsWith("p1") && Node.getNode12().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [10 11 12]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 7 12 16
            System.out.println("Nodes [7 12 16]");
            if (Node.getNode7().getCurrentChip() == null || Node.getNode12().getCurrentChip() == null || Node.getNode16().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode7().getCurrentChip().getId().startsWith("p1") && Node.getNode12().getCurrentChip().getId().startsWith("p1") && Node.getNode16().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [7 12 16]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 9 13 18
            System.out.println("Nodes [9 13 18]");
            if (Node.getNode9().getCurrentChip() == null || Node.getNode13().getCurrentChip() == null || Node.getNode18().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode9().getCurrentChip().getId().startsWith("p1") && Node.getNode13().getCurrentChip().getId().startsWith("p1") && Node.getNode18().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [9 13 18]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 6 14 21
            System.out.println("Nodes [6 14 21]");
            if (Node.getNode6().getCurrentChip() == null || Node.getNode14().getCurrentChip() == null || Node.getNode21().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode6().getCurrentChip().getId().startsWith("p1") && Node.getNode14().getCurrentChip().getId().startsWith("p1") && Node.getNode21().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [6 14 21]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }
            // 13 14 15
            System.out.println("Nodes [13 14 15]");
            if (Node.getNode13().getCurrentChip() == null || Node.getNode14().getCurrentChip() == null || Node.getNode15().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode13().getCurrentChip().getId().startsWith("p1") && Node.getNode14().getCurrentChip().getId().startsWith("p1") && Node.getNode15().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [13 14 15]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 3 15 24
            System.out.println("Nodes [3 15 24]");
            if (Node.getNode3().getCurrentChip() == null || Node.getNode15().getCurrentChip() == null || Node.getNode24().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode3().getCurrentChip().getId().startsWith("p1") && Node.getNode15().getCurrentChip().getId().startsWith("p1") && Node.getNode24().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [3 15 24]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 16 17 18
            System.out.println("Nodes [16 17 18]");
            if (Node.getNode16().getCurrentChip() == null || Node.getNode17().getCurrentChip() == null || Node.getNode18().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode16().getCurrentChip().getId().startsWith("p1") && Node.getNode17().getCurrentChip().getId().startsWith("p1") && Node.getNode18().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [16 17 18]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 17 20 23
            System.out.println("Nodes [17 20 23]");
            if (Node.getNode17().getCurrentChip() == null || Node.getNode20().getCurrentChip() == null || Node.getNode23().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode17().getCurrentChip().getId().startsWith("p1") && Node.getNode20().getCurrentChip().getId().startsWith("p1") && Node.getNode23().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [17 20 23]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }
            // 19 20 21
            System.out.println("Nodes [19 20 21]");
            if (Node.getNode19().getCurrentChip() == null || Node.getNode20().getCurrentChip() == null || Node.getNode21().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode19().getCurrentChip().getId().startsWith("p1") && Node.getNode20().getCurrentChip().getId().startsWith("p1") && Node.getNode21().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [19 20 21]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 22 23 24
            System.out.println("Nodes [22 23 24]");
            if (Node.getNode22().getCurrentChip() == null || Node.getNode23().getCurrentChip() == null || Node.getNode24().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode22().getCurrentChip().getId().startsWith("p1") && Node.getNode23().getCurrentChip().getId().startsWith("p1") && Node.getNode24().getCurrentChip().getId().startsWith("p1")) {
                System.out.println(">> P1 Mill [22 23 24]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }
        }

        //Cases for player 2
        //Basically only check if there is 3 pieces that forms a mill only
        if (currentPlayer.getPlayerType() == PlayerType.PLAYER2) {

            // 1 2 3
            System.out.println("Nodes [1 2 3]");
            //First, checks if pieces of node1 OR node3 is empty. If empty, do not do anything
            if (Node.getNode1().getCurrentChip() == null || Node.getNode2().getCurrentChip() == null || Node.getNode3().getCurrentChip() == null) {
                System.out.println("NO MILL");
            }
            //If asses first and second, third checks if the pieces was player 1 pieces. If so, its a mill
            else if (Node.getNode1().getCurrentChip().getId().startsWith("p2") && Node.getNode2().getCurrentChip().getId().startsWith("p2") && Node.getNode3().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [1 2 3]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }


            // 4 5 6
            System.out.println("Nodes [4 5 6]");
            if (Node.getNode4().getCurrentChip() == null || Node.getNode5().getCurrentChip() == null || Node.getNode6().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode4().getCurrentChip().getId().startsWith("p2") && Node.getNode5().getCurrentChip().getId().startsWith("p2") && Node.getNode6().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [4 5 6]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 2 5 8
            System.out.println("Nodes [2 5 8]");
            if (Node.getNode2().getCurrentChip() == null || Node.getNode5().getCurrentChip() == null || Node.getNode8().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode2().getCurrentChip().getId().startsWith("p2") && Node.getNode5().getCurrentChip().getId().startsWith("p2") && Node.getNode8().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [2 5 8]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 7 8 9
            System.out.println("Nodes [7 8 9]");
            if (Node.getNode7().getCurrentChip() == null || Node.getNode8().getCurrentChip() == null || Node.getNode9().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode7().getCurrentChip().getId().startsWith("p2") && Node.getNode8().getCurrentChip().getId().startsWith("p2") && Node.getNode9().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [7 8 9]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 1 10 22
            System.out.println("Nodes [1 10 22]");
            if (Node.getNode1().getCurrentChip() == null || Node.getNode10().getCurrentChip() == null || Node.getNode22().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode1().getCurrentChip().getId().startsWith("p2") && Node.getNode10().getCurrentChip().getId().startsWith("p2") && Node.getNode22().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [1 10 22]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 4 11 19
            System.out.println("Nodes [4 11 19]");
            if (Node.getNode4().getCurrentChip() == null || Node.getNode11().getCurrentChip() == null || Node.getNode19().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode4().getCurrentChip().getId().startsWith("p2") && Node.getNode11().getCurrentChip().getId().startsWith("p2") && Node.getNode19().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [4 11 19]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 10 11 12
            System.out.println("Nodes [10 11 12]");
            if (Node.getNode10().getCurrentChip() == null || Node.getNode11().getCurrentChip() == null || Node.getNode12().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode10().getCurrentChip().getId().startsWith("p2") && Node.getNode11().getCurrentChip().getId().startsWith("p2") && Node.getNode12().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [10 11 12]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 7 12 16
            System.out.println("Nodes [7 12 16]");
            if (Node.getNode7().getCurrentChip() == null || Node.getNode12().getCurrentChip() == null || Node.getNode16().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode7().getCurrentChip().getId().startsWith("p2") && Node.getNode12().getCurrentChip().getId().startsWith("p2") && Node.getNode16().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [7 12 16]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 9 13 18
            System.out.println("Nodes [9 13 18]");
            if (Node.getNode9().getCurrentChip() == null || Node.getNode13().getCurrentChip() == null || Node.getNode18().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode9().getCurrentChip().getId().startsWith("p2") && Node.getNode13().getCurrentChip().getId().startsWith("p2") && Node.getNode18().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [9 13 18]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 6 14 21
            System.out.println("Nodes [6 14 21]");
            if (Node.getNode6().getCurrentChip() == null || Node.getNode14().getCurrentChip() == null || Node.getNode21().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode6().getCurrentChip().getId().startsWith("p2") && Node.getNode14().getCurrentChip().getId().startsWith("p2") && Node.getNode21().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [6 14 21]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }
            // 13 14 15
            System.out.println("Nodes [13 14 15]");
            if (Node.getNode13().getCurrentChip() == null || Node.getNode14().getCurrentChip() == null || Node.getNode15().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode13().getCurrentChip().getId().startsWith("p2") && Node.getNode14().getCurrentChip().getId().startsWith("p2") && Node.getNode15().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [13 14 15]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 3 15 24
            System.out.println("Nodes [3 15 24]");
            if (Node.getNode3().getCurrentChip() == null || Node.getNode15().getCurrentChip() == null || Node.getNode24().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode3().getCurrentChip().getId().startsWith("p2") && Node.getNode15().getCurrentChip().getId().startsWith("p2") && Node.getNode24().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [3 15 24]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 16 17 18
            System.out.println("Nodes [16 17 18]");
            if (Node.getNode16().getCurrentChip() == null || Node.getNode17().getCurrentChip() == null || Node.getNode18().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode16().getCurrentChip().getId().startsWith("p2") && Node.getNode17().getCurrentChip().getId().startsWith("p2") && Node.getNode18().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [16 17 18]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 17 20 23
            System.out.println("Nodes [17 20 23]");
            if (Node.getNode17().getCurrentChip() == null || Node.getNode20().getCurrentChip() == null || Node.getNode23().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode17().getCurrentChip().getId().startsWith("p2") && Node.getNode20().getCurrentChip().getId().startsWith("p2") && Node.getNode23().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [17 20 23]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }
            // 19 20 21
            System.out.println("Nodes [19 20 21]");
            if (Node.getNode19().getCurrentChip() == null || Node.getNode20().getCurrentChip() == null || Node.getNode21().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode19().getCurrentChip().getId().startsWith("p2") && Node.getNode20().getCurrentChip().getId().startsWith("p2") && Node.getNode21().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [19 20 21]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }

            // 22 23 24
            System.out.println("Nodes [22 23 24]");
            if (Node.getNode22().getCurrentChip() == null || Node.getNode23().getCurrentChip() == null || Node.getNode24().getCurrentChip() == null) {
                System.out.println("NO MILL");
            } else if (Node.getNode22().getCurrentChip().getId().startsWith("p2") && Node.getNode23().getCurrentChip().getId().startsWith("p2") && Node.getNode24().getCurrentChip().getId().startsWith("p2")) {
                System.out.println(">> P2 Mill [22 23 24]");
            } else {
                System.out.println(">>>>> Invalid Mill <<<<<");
            }
        }
        System.out.println("-------------");
    }

=======
>>>>>>> Stashed changes
}
