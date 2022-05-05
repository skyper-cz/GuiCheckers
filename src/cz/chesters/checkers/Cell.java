package cz.chesters.checkers;

import javax.swing.*;

public class Cell {
    boolean isDama;
    boolean isBlack;

    public Cell(boolean isBlack) {
        this.isBlack = isBlack;
        this.isDama = false;
    }

    public Cell(boolean isBlack, boolean isDama) {
        this.isBlack = isBlack;
        this.isDama = isDama;
    }

    public void promote(){
        this.isDama = true;
    }
}
