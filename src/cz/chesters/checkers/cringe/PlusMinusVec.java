package cz.chesters.checkers.cringe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusMinusVec {

    JFrame frame = new JFrame("Plusminus");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JLabel cisloLabel = new JLabel();
    int cislo = 0;
    JButton wack = new JButton();
    boolean isWackMoved = false;
    ImageIcon img = new ImageIcon("resources/smol.png");

    public void plusMinusBtn() {
        System.setProperty("awt.useSystemAAFontSettings", "off");
        frame.setSize(360, 190);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        plus.setBounds(5, 5, 150, 75);
        plus.addActionListener(this::action);
        minus.setBounds(160, 5, 150, 75);
        minus.addActionListener(this::action);
        cisloLabel.setBounds(5, 85, 310, 80);
        frame.add(plus);
        frame.add(minus);
        cisloLabel.setText(String.valueOf(cislo));
        cisloLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 75));
        frame.add(cisloLabel);
        wack.setBounds(320, 5, 20, 20);
        wack.setIcon(img);
        wack.addActionListener(this::action);
        frame.add(wack);
    }

    void action(ActionEvent e) {

        System.out.println("did a klik");
        if (e.getSource() == plus) {
            cislo++;
        }
        if (e.getSource() == minus) {
            cislo--;
        }
        if (e.getSource() == wack) {

            System.out.println("did a do");
            if (isWackMoved) {
                wack.setBounds(320, 5, 20, 20);
                System.out.println("did 1");
            } else {
                wack.setBounds(320, (int) (Math.random() * 120 + 5), 20, 20);
                System.out.println("did 0");
            }


            System.out.println("did img");
            img = new ImageIcon("resources/" +
                    switch ((int) (Math.random() * 4)) {
                        case 0 -> "Karel1E.jpg";
                        case 1 -> "Karel2E.jpg";
                        case 2 -> "Karel3E.jpg";
                        case 3 -> "Karel4E.png";
                        default -> "smol.png";
                    });
            wack.setIcon(img);
        }
        cisloLabel.setText(String.valueOf(cislo));
    }
}
