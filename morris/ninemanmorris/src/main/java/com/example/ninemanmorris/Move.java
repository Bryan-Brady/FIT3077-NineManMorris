package com.example.ninemanmorris;

public class Move {
    private static Move move_instance = null;
    private static Rules rules = new Rules();

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

    /** Function to set the position of the currently clicked chip to the clicked node of the current player.

     Input :
     currentChip : The currently selected chip
     thisNode: The currently clicked node
     currentPlayer: The current player's turn

     Return  : N/A

     */
    private void setPos(Chip currentChip,Node thisNode, Player currentPlayer){

        // Setting the chips on the board position
        currentChip.setLayoutX(thisNode.getLayoutX());
        currentChip.setLayoutY(thisNode.getLayoutY());
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

    /** Function that allows the chip to be able to move anywhere when clicked.

     Input :
     currentChip : The currently selected chip
     thisNode: The currently clicked node
     currentPlayer: The current player's turn

     Return  : N/A

     */
    public void moveAnyWhere(Chip currentChip,Node thisNode, Player currentPlayer){
        if(rules.isInitialMoveCondition(currentChip, currentPlayer)){
            currentPlayer.addChipsAlive();
            // Can move anywhere
            this.setPos(currentChip, thisNode, currentPlayer);
            // Set status on the chip, stating it is on the board
            currentChip.setChipStatus(ChipStatus.ALIVE);
            // Reduce chips reserve
            currentPlayer.reduceChipsReserve();

        }

        if(rules.isRemainingThreeMoveCondition(currentChip, currentPlayer)){
            System.out.println("Three piece remain");
            this.setPos(currentChip, thisNode, currentPlayer);
        }
    }

    /** Function that, if legal, allows the killing of an opponent chip if the current player made a mill.

     Input :
     currentChip : The currently selected chip
     currentPlayer: The current player's turn

     Return  : N/A

     */
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

            // Reduces the enemies' chips
            Player enemyPlayer = currentPlayer.checkPlayerTurn(currentPlayer);
            enemyPlayer.reduceChipsAlive();
            currentPlayer.setPlayerMoved(true);

            // Setting back to not three in a row for player
            currentPlayer.setMillMade(false);
        }
    }

    public void moveAdjacent(Chip currentChip, Node thisNode, Player currentPlayer){

        if(rules.isMoveAdjacent(currentChip, thisNode, currentPlayer)){
            System.out.println("Adjacent Movement");
            this.setPos(currentChip, thisNode, currentPlayer);
        }
    }

}
