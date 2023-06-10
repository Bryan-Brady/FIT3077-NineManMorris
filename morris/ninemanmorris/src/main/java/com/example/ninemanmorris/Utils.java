package com.example.ninemanmorris;

import javafx.scene.paint.Color;

public class Utils {


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
