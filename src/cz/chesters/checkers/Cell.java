package cz.chesters.checkers;

import javax.swing.*;

import static java.util.Objects.isNull;

public class Cell {
    boolean isBlack;
    Piece piece;
    boolean isSelected;

    public Cell(boolean isBlack) {
        this.isBlack = isBlack;
        this.piece = null;
        isSelected = false;
    }

    public Cell(boolean isBlack, Piece piece) {
        this.isBlack = isBlack;
        this.piece = piece;
        isSelected = false;

        if (!isBlack && !isNull(piece))
            System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Vytvořena bílá buňka s figurkou!" + Mik.RESET);
    }

    public Cell(boolean isBlack, boolean isPieceBlack) {
        this.isBlack = isBlack;
        this.piece = new Piece(isPieceBlack);
        isSelected = false;

        if (!isBlack)
            System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Vytvořena bílá buňka s figurkou!" + Mik.RESET);
    }

    public Cell(boolean isBlack, boolean isPieceBlack, boolean isPieceQueen) {
        this.isBlack = isBlack;
        this.piece = new Piece(isPieceBlack, isPieceQueen);
        isSelected = false;

        if (!isBlack)
            System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Vytvořena bílá buňka s figurkou!" + Mik.RESET);
    }

    public void select(){
        this.isSelected = !this.isSelected;
    }

    public void select(boolean value){
        this.isSelected = value;
    }

}
