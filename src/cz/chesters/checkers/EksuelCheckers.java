package cz.chesters.checkers;

import cz.chesters.checkers.buttonVec.Button;

import javax.swing.*;

public class EksuelCheckers {
    JFrame frame = new JFrame("Checkers");
    Cell[][] cellField = new Cell[8][8];
    JButton[][] buttonField = new JButton[8][8];

    public void play() {
        frame.setSize(880, 880);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);

        initializeButtons();

        initializeCells();
    }

    public void initializeButtons() {
        int x = 5;
        int y = 5;

        for (JButton[] row : buttonField) {
            x = 5;
            for (JButton btn : row) {
                frame.add(btn);
                btn.setBounds(x, y, 100, 100);
                x = x + 105;
            }
            System.out.println("x = " + x);
            y = y + 105;
        }
        System.out.println("y = " + y);
    }

    public void initializeCells() {
        int x = 0;
        int y = 0;

        // Lord, have mercy.
        for (Cell[] row : cellField) {
            x = 0;
            for (Cell cl : row) {
                if (((x % 2) + (y % 2)) % 2 == 1) {
                    if (y < 3)
                        cl = new Cell(true, true);
                    else if (y > 4)
                        cl = new Cell(true, true);
                    else cl = new Cell(true);
                } else cl = new Cell(false);
                x++;
            }
            y++;
        }
    }
}
