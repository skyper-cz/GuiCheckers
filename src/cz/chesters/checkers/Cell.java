package cz.chesters.checkers;

import javax.swing.*;

import static java.util.Objects.isNull;

public class Cell {
    boolean isBlack;
    Piece piece;

    public Cell(boolean isBlack) {
        this.isBlack = isBlack;
        this.piece = null;
    }

    public Cell(boolean isBlack, Piece piece) {
        this.isBlack = isBlack;
        this.piece = piece;

        if (!isBlack && !isNull(piece))
            System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Vytvořena bílá buňka s figurkou!" + Mik.RESET);
    }

    public Cell(boolean isBlack, boolean isPieceBlack) {
        this.isBlack = isBlack;
        this.piece = new Piece(isPieceBlack);

        if (!isBlack)
            System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Vytvořena bílá buňka s figurkou!" + Mik.RESET);
    }

    public Cell(boolean isBlack, boolean isPieceBlack, boolean isPieceQueen) {
        this.isBlack = isBlack;
        this.piece = new Piece(isPieceBlack, isPieceQueen);

        if (!isBlack)
            System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Vytvořena bílá buňka s figurkou!" + Mik.RESET);
    }


}
