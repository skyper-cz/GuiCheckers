package cz.chesters.checkers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ButtonVec {
    JFrame frame = new JFrame("I don't fucking know");
    JButton[][] buttons = new JButton[3][3];
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
                buttons[i][j] = new JButton();
            }
        }
    }

    public void prepareButtons() {
        int x = 5;
        int y = 5;

        for (JButton[] line : buttons) {
            for (JButton btn : line) {
                System.out.println("placing button at " + x + ", " + y);

                btn.setBounds(x, y, 20, 20);
                x = x + 25;
                btn.setIcon(ikony[random.nextInt(buttons.length)]);
                btn.setVisible(true);
                btn.addActionListener(this::imStuff);
                frame.add(btn);
            }
            y = y + 25;
            x = 5;
        }
        System.out.println("done");
    }

    public void imStuff(ActionEvent a) {
        int x = -1;
        int y = -1;

        bigloop:
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (a.getSource() == buttons[i][j]) {
                    x = i;
                    y = j;
                    break bigloop;
                }
            }
        }

        for (int i = 0; i < buttons.length; i++)
            for (int j = 0; j < buttons[i].length; j++)
                if (!(x == i && y == j))
                    buttons[i][j].setIcon(ikony[random.nextInt(buttons.length)]);
    }
}
