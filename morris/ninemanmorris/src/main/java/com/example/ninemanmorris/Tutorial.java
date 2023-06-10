package com.example.ninemanmorris;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Tutorial {

    private boolean tutorialOn = false;
    private boolean hintOn = false;

    private Text tutorialText;

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

//    public void setText(String s){
//        this.tutorialText.setText(s);
//    }
//
//    public Text getTutorialText() {
//        return tutorialText;
//    }
//
    public void setTutorialText(String textContent) {
        tutorialText.setText(textContent);
    }

    public void injectText(Text text){
        this.tutorialText = text;
    }
}
