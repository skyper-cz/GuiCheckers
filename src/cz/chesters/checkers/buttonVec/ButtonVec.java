package cz.chesters.checkers.buttonVec;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ButtonVec {
    JFrame frame = new JFrame("I don't fucking know");
    Button[][] buttons = new Button[3][3];
    ImageIcon[] ikony = {
            new ImageIcon("resources/Karel1E.jpg"),
            new ImageIcon("resources/Karel2E.jpg"),
            new ImageIcon("resources/Karel3E.jpg"),
            new ImageIcon("resources/Karel4E.jpg"),
            new ImageIcon("resources/smol.png"),
            new ImageIcon("resources/Untitled.png"),
    };

    Random random = new Random();

    public void doStuff() {
        frame.setSize(60, 125);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        generateButtons();
        prepareButtons();
    }

    public void generateButtons() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new Button(new JButton());
            }
        }
    }

    public void prepareButtons() {
        int x = 5;
        int y = 5;

        for (Button[] line : buttons) {
            for (Button btn : line) {
                System.out.println("placing button at " + x + ", " + y);

                btn.btn.setBounds(x, y, 20, 20);
                x = x + 25;
                btn.btn.setIcon(ikony[random.nextInt(buttons.length)]);
                btn.btn.setVisible(true);
                btn.btn.addActionListener(this::imStuff);
                frame.add(btn.btn);
            }
            y = y + 25;
            x = 5;
        }
        System.out.println("done");
    }

    public void imStuff(ActionEvent a) {
        int x = -1;
        int y = -1;
        boolean validClick = false;

        bigloop:
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (a.getSource() == buttons[i][j].btn && buttons[i][j].isClickable) {
                    buttons[i][j].btn.setIcon(new ImageIcon("resources/red.png"));
                    buttons[i][j].setClickable(false);
                    x = i;
                    y = j;
                    validClick = true;
                    break bigloop;
                }
            }
        }
        if (validClick)
            for (int i = 0; i < buttons.length; i++)
                for (int j = 0; j < buttons[i].length; j++)
                    if (!(x == i && y == j)) {
                        buttons[i][j].btn.setIcon(ikony[random.nextInt(buttons.length)]);
                        buttons[i][j].setClickable(true);
                    }
    }
}
