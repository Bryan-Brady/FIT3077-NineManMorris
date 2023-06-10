package com.example.ninemanmorris;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;


public class Board {

    //Objects within this is instantiated immediately upon running HelloApplication.java
    private Chip currentChip = null;
    private Player1 player1 = Player1.getInstance();
    private Player2 player2 = Player2.getInstance();
    private Player currentPlayer = player1;

    private Rules rules = new Rules();
    private Move move = new Move();
    @FXML
    private Text tutorialText;
    private Tutorial tutorial = new Tutorial();


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

    @FXML
    private Text playerTurnText= new Text();
    @FXML
    private Text playerActionText = new Text();



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

//    private Chip[] chipsP1Array = {p101, p102, p103, p104, p105, p106, p107, p108, p109};
//    private Chip[] chipsP2Array = {p201, p202, p203, p204, p205, p206, p207, p208, p209};

    private ArrayList<Chip> chip1ArrayList;
    private ArrayList<Chip> chip2ArrayList;

    private ArrayList<Node> nodeArrayList;

    private Line[] lineArray = {line1, line2, line3, line4, line5, line6, line7, line8,
                                line9, line10, line11, line12, line13, line14, line15,
                                line16};
    private Chip prevChip;

    /** Function that is initialised upon opening the game; initialising the nodes and their neighbours,
     * and the lines (I.e possible mill combinations).

     Input : N/A
     Return  : N/A

     */
    @FXML
    public void initialize() {
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

        //Initialise arraylist of chips
        chip1ArrayList = new ArrayList<Chip>();
        //Use Collections class to add multiple elements into the list/arraylist
        Collections.addAll(chip1ArrayList, p101, p102, p103, p104, p105, p106, p107, p108, p109);

        chip2ArrayList = new ArrayList<Chip>();
        Collections.addAll(chip2ArrayList, p201, p202, p203, p204, p205, p206, p207, p208, p209);


        //Originally set the text to player 1 as player 1 moves first
        setPlayerTurnText("Player 1");

        nodeArrayList = new ArrayList<Node>();
        Collections.addAll(nodeArrayList, node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12, node13, node14, node15, node16, node17, node18, node19, node20, node21, node22, node23, node24);

        // Injecting depedencies
        move.injectTutorial(tutorial);
        tutorial.injectText(tutorialText);

    }
    @FXML
    void onLayoutClick(MouseEvent event) {
        // check for winner again in case game has ended and someone tries to click on the screen

        checkWinner(player1, player2, chip1ArrayList, chip2ArrayList);

    }

    /** Function that is executed if any chip is clicked on the board. Very important

     Input : event : The event of a mouse, click event.
     Return  : N/A

     */
    @FXML
    void onChipClick(MouseEvent event) {

        Chip thisChip = ((Chip)event.getSource());

        highlight(thisChip, null);


        if(prevChip == null){
            ;
        }
        unHighlight(getPrevChip(), null);
        unHighlight(getPrevChip(), null);
        this.prevChip = thisChip;

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
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

                // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
                // Set Text portion [Case 2]
                // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
                // Since this is the scenario where player must select a chip to kill, we must update the player text
                // After the kill has been made as it is then the next player's turn
                if(this.currentPlayer.getPlayerType() == PlayerType.PLAYER1 && this.currentChip.getId().startsWith("p1")){
                    setPlayerTurnText("Player 1");
                    //Small addition: if chip is not part of mill, then kill is successful and thus its
                    //next player's turn
                    if(!rules.chipIsPartOfMill(this.currentChip)){
                        setPlayerActionText("Move");
                    }
                } else {
                    setPlayerTurnText("Player 2");
                    if(!rules.chipIsPartOfMill(this.currentChip)){
                        setPlayerActionText("Move");
                    }
                }
                // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

            }else{
                this.currentChip = null;
            }
        }

        checkWinner(player1, player2, chip1ArrayList, chip2ArrayList);

    }



    /** Function that is executed if any node is clicked on the board. Very important

     Input : event : The event of a mouse, click event.
     Return  : N/A

     */
    @FXML
    void onNodeClick(MouseEvent event) {

        Node thisNode = ((Node)event.getSource());


        if (this.currentChip != null) {
            // Where move check is happening
            move.moveAnyWhere(this.currentChip, thisNode, this.currentPlayer);
            move.moveAdjacent(this.currentChip, thisNode, this.currentPlayer);
            rules.setMillStatusBoard(lineArray);
            // Check if player have three in a row
            if(!this.currentPlayer.hasMill()) {
                // Go in this if player don't have three in a row
                // Changing player turn
                if(this.currentPlayer.isPlayerMoved()) {
                    this.currentPlayer = this.currentPlayer.checkPlayerTurn(currentPlayer);

                    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
                    // Set Text portion [Case 1]
                    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
                    // Since this is the scenario where player has NO MILL, we can now set the text accordingly.
                    if(this.currentPlayer.getPlayerType() == PlayerType.PLAYER1){
                        setPlayerTurnText("Player 1");
                    } else {
                        setPlayerTurnText("Player 2");
                    }
                    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

                    //No mill so, valid action is move a piece
                    setPlayerActionText("Move");
                }
            } else {
                //MILL has been made. Set action text letting them know mill has been made so take a piece
                setPlayerActionText("Mill made, take a piece");
            }
            this.currentChip = null;
        }
        // Winner is checked again for the case where player has no more moves immediately after placing down their LAST chip
        // (because reserve is reduced after it has moved, not when its clicked)
        checkWinner(player1, player2, chip1ArrayList, chip2ArrayList);
    }
    @FXML
    void onLineClick(MouseEvent event){

    }

    public void checkWinner(Player player1, Player player2, ArrayList<Chip> chip1ArrayList, ArrayList<Chip> chip2ArrayList){
        if(rules.isGameEnd(player1, player2, chip1ArrayList, chip2ArrayList) != null){
            System.out.println("The Winner Is : " + rules.isGameEnd(player1, player2, chip1ArrayList, chip2ArrayList).getPlayerType());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WINNER");
            alert.setContentText("The Winner Is : " + rules.isGameEnd(player1, player2, chip1ArrayList, chip2ArrayList).getPlayerType());
            alert.showAndWait();
        }
    }

    public void tutorialModeOn(){
        this.tutorial.setTutorialOn(true);
        this.tutorial.setTutorialText("PLACE YOUR DAMN CHIPS HERE");
        System.out.println("TUTORIAL ON");

        // Make exit button here as well
    }
    public void hintOn(){
        if(!tutorial.isTutorialOn()) {
            // Can only turn hints on if tutorial is off
            this.tutorial.setHintOn(true);
        }
        System.out.println("HINT ON");
    }


    private void highlight(Chip thisChip, Node thisNode ){
        if(thisChip != null) {
            thisChip.setStrokeWidth(4);
            thisChip.setStroke(Color.GREEN);
        }

        if(thisNode != null){
            thisNode.setStrokeWidth(4);
            thisChip.setStroke(Color.GREEN);
        }
    }

    private void unHighlight(Chip thisChip, Node thisNode ){
        if(thisChip != null) {
            thisChip.setStrokeWidth(0.7);
            thisChip.setStroke(Color.BLACK);
        }

        if(thisNode != null){
            thisNode.setStrokeWidth(4);
            thisChip.setStroke(Color.GREEN);
        }
    }
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Chip getPrevChip() {
        return prevChip;
    }


    private void setPlayerTurnText(String playerTurnText) {
        this.playerTurnText.setText(playerTurnText);
    }

    private void setPlayerActionText(String playerActionText) {
        this.playerActionText.setText(playerActionText);
    }

    private void setPrevChip(Chip prevChip) {
        this.prevChip = prevChip;
    }

    private void highlight(Chip thisChip){
        thisChip.setStrokeWidth(4);
        thisChip.setStroke(Color.GREEN);
    }

    private void unHighlight(Chip thisChip) {
        thisChip.setStrokeWidth(0.7);
        thisChip.setStroke(Color.BLACK);
    }
}
