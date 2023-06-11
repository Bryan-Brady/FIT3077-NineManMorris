package com.example.ninemanmorris;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * A class that manages what message are supposed to be displayed
 * and visual cues for the current tutorial/hint message
 * */
public class Tutorial {

    private Utils utils = new Utils();
    private boolean tutorialOn = false;
    private boolean hintOn = false;
    private Rules rules = new Rules();
    private Text tutorialText;
    private ArrayList<Node> nodeArrayList;
    private boolean nodesHighlighted = false;
    private boolean chipsHighlighted = false;

    public Tutorial( ){

    }
    public boolean isTutorialOn() {
        return tutorialOn;
    }

    public void setTutorialOn(boolean tutorialOn) {
        this.tutorialOn = tutorialOn;
    }

    public boolean isHintOn() {
        return hintOn;
    }

    public void setHintOn(boolean hintOn) {
        this.hintOn = hintOn;
    }

    public void setPlayerActionText(String textContent) {
        tutorialText.setText(textContent);
    }

    public void injectText(Text text){
        this.tutorialText = text;
    }

    /**
     * This function will displays different kind of messages depending on what
     * is the move that the current player have to make
     * @param player : The current player that we want to know the move of
     */
    public void displayMessage(Player player){

        if(player.hasMill()){
            // Case where a mill have been created and player have to opponents chip
            this.setPlayerActionText("Remove an opponents chip");
            this.highlightKillableChips(player);
        } else if (rules.isInitialMoveCondition(player) || rules.isRemainingThreeMoveCondition(player)) {
            // Case where player can move anywhere and move three remaining condition
            this.setPlayerActionText("Move your chip to the highlighted spot");
            this.highlightAllEmptyNodes(this.nodeArrayList);
        } else if (rules.isMoveAdjacent(player)) {
            // When all chips have been placed and player can only move adjacently
            this.setPlayerActionText("Click your chip and move the chip to the highlighted spot");
        }
    }

    /**
     * Function to highlihght the chips that can be removed
     * @param player
     */
    public void highlightKillableChips(Player player){
        Player opponent = player.checkPlayerTurn(player);
        // Highlight opponents chip
        for(Chip chip : opponent.getChips()){
            if(chip.getChipLocation() != null) {
                if (!rules.chipIsPartOfMill(chip) && chip.getChipStatus() == ChipStatus.ALIVE)
                    utils.highlight(chip, null);
            }
        }
        this.chipsHighlighted = true;
    }

    /**
     * Hihglight all the nodes that a player can place their chip on
     * @param nodeArrayList
     */
    public void highlightAllEmptyNodes(ArrayList<Node> nodeArrayList){
        for(Node node : this.nodeArrayList){
            if(node.getChip() == null) {
                // Highlight all nodes that doesn't have a chip
                utils.highlight(null, node);
            }
        }
        this.nodesHighlighted = true;
    }

    /**
     * Highlight the adjacent nodes where a player can move their chips
     * once all reserved chips have been placed
     * @param chip
     */
    public void highlightAdjNodes(Chip chip){
        for(Node node : chip.getChipLocation().getNodeNeighbours()){

            if(node.getChip() == null){

                // Highlight all adj nodes aka the neighbours
                utils.highlight(null, node);
            }
        }
        this.nodesHighlighted = true;
    }

    /**
     * Unhihglights all the chips, it is used after a turn is over
     */
    public void unhighlightAllChips(){
        Board board = new Board();
        for(Chip chip : board.getPlayer1().getChips()){
            utils.unHighlight(chip, null);
        }
        for(Chip chip : board.getPlayer2().getChips()){
            utils.unHighlight(chip, null);
        }
    }

    /**
     * Unhighlights all nodes, it is used after a turn is over or when tutorial is turned off
     */
    public void unhighlightAllNodes(){
        for(Node node : nodeArrayList){

            node.setStroke(Color.BLACK);
            utils.unHighlight(null, node);
        }
    }

    /**
     * Unhihglighting adjacent nodes to turn off the highlight after the highlighAdjNodes function is invoked
     * @param chip
     */
    public void unhighlightAdjNodes(Chip chip){
        if(chip != null && chip.getChipLocation() != null) {
            for (Node node : chip.getChipLocation().getNodeNeighbours()) {
                if (node.getChip() == null) {
                    utils.unHighlight(null, node);
                }
            }
        }
    }


    public void setNodeArrayList(ArrayList<Node> nodeArrayList) {
        this.nodeArrayList = nodeArrayList;
    }

    public boolean isNodesHighlighted() {
        return nodesHighlighted;
    }


    public boolean isChipsHighlighted() {
        return chipsHighlighted;
    }

}
