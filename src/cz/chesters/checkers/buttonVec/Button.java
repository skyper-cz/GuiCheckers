package cz.chesters.checkers.buttonVec;

import javax.swing.*;

public class Button {
    JButton btn;
    boolean isClickable;

    Button(JButton jBt) {
        this.btn = jBt;
        this.isClickable = true;
    }

    Button(JButton jBt, boolean clik) {
        this.btn = jBt;
        this.isClickable = clik;
    }

    public void setClickable(boolean b){
        this.isClickable = b;
    }
}
