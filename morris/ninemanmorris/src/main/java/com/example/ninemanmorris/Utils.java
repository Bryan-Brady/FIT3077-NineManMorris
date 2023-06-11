package com.example.ninemanmorris;

import javafx.scene.paint.Color;

/**
 * A Class that manages highlighting and unhighlighting or other utility
 * functions that maybe in placed in the future
 */
public class Utils {
    /**
     * Functionn to highlight chips
     * @param thisChip
     * @param thisNode
     */

    public void highlight(Chip thisChip, Node thisNode ){
        if(thisChip != null) {
            thisChip.setStrokeWidth(4);
            thisChip.setStroke(Color.GREEN);
        }

        if(thisNode != null){
            thisNode.setStrokeWidth(3);
            thisNode.setStroke(Color.DARKCYAN);
        }
    }

    /**
     * Function to unhighlight chips
     * @param thisChip
     * @param thisNode
     */
    public void unHighlight(Chip thisChip, Node thisNode ){
        if(thisChip != null) {
            thisChip.setStrokeWidth(0.7);
            thisChip.setStroke(Color.BLACK);
        }

        if(thisNode != null){
            thisNode.setStrokeWidth(0.8);
            thisNode.setStroke(Color.BLACK);
        }
    }
}
