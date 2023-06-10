package com.example.ninemanmorris;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

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

    public void displayMessage(Player player){

        if(player.hasMill()){
            System.out.println("IN MOVE MILL TUTORIAL");
            this.setPlayerActionText("Remove an opponents chip");
            this.highlightKillableChips(player);

        } else if (rules.isInitialMoveCondition(player) || rules.isRemainingThreeMoveCondition(player)) {
            // Text to make player move
            this.setPlayerActionText("Move your chip to the highlighted spot");
            this.highlightAllEmptyNodes(this.nodeArrayList);
        } else if (rules.isMoveAdjacent(player)) {
            this.setPlayerActionText("Move your chip to the highlighted spot");
        } else {
            System.out.println("NOTHING");
        }
    }
    public void highlightKillableChips(Player player){
        Player opponent = player.checkPlayerTurn(player);
        // Highlight opponents chip
        for(Chip chip : opponent.getChips()){
            if(!chip.isPartOfAMill() && chip.getChipStatus() == ChipStatus.ALIVE) utils.highlight(chip, null);
        }
        this.chipsHighlighted = true;
    }

    public void highlightAllEmptyNodes(ArrayList<Node> nodeArrayList){
        for(Node node : this.nodeArrayList){
            if(node.getChip() == null) {
                // Highlight all nodes that doesn't have a chip
                utils.highlight(null, node);
            }
        }
        this.nodesHighlighted = true;
    }
    public void highlightAdjNodes(Chip chip){
        for(Node node : chip.getChipLocation().getNodeNeighbours()){
            System.out.println(node.getId());
            if(node.getChip() == null){
                System.out.println("IN IF BRANCH");
                // Highlight all adj nodes aka the neighbours
                utils.highlight(null, node);
            }
        }
        this.nodesHighlighted = true;
    }

    public void unhighlightAllChips(){
        Board board = new Board();
        for(Chip chip : board.getPlayer1().getChips()){
            utils.unHighlight(chip, null);
        }
        for(Chip chip : board.getPlayer2().getChips()){
            utils.unHighlight(chip, null);
        }
    }
    public void unhighlightAllNodes(){
        System.out.println("UNhiglight");
        for(Node node : nodeArrayList){
            System.out.println(node.getId());
            node.setStroke(Color.BLACK);
            utils.unHighlight(null, node);
        }
    }
    public void unhighlightNodes(Chip chip){
        if(chip != null) {
            for (Node node : chip.getChipLocation().getNodeNeighbours()) {
                if (node.getChip() == null) {
                    utils.unHighlight(null, node);
                }
            }
        }
    }

    public ArrayList<Node> getNodeArrayList() {
        return nodeArrayList;
    }

    public void setNodeArrayList(ArrayList<Node> nodeArrayList) {
        this.nodeArrayList = nodeArrayList;
    }

    public boolean isNodesHighlighted() {
        return nodesHighlighted;
    }

    public void setNodesHighlighted(boolean nodesHighlighted) {
        this.nodesHighlighted = nodesHighlighted;
    }

    public boolean isChipsHighlighted() {
        return chipsHighlighted;
    }

    public void setChipsHighlighted(boolean chipsHighlighted) {
        this.chipsHighlighted = chipsHighlighted;
    }
}
