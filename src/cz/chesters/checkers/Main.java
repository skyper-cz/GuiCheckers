package cz.chesters.checkers;

import cz.chesters.checkers.buttonVec.ButtonVec;
import cz.chesters.checkers.cringe.Calculator;
import cz.chesters.checkers.cringe.PlusMinusVec;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EksuelCheckers checkers = new EksuelCheckers();
        checkers.play();

    }


    public static void test() {
        JFrame frame = new JFrame("Hokuspokus");
        frame.setSize(500, 250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.setProperty("awt.useSystemAAFontSettings", "off");

        JLabel label = new JLabel();
        ImageIcon img = new ImageIcon("resources/Untitled.png");
        label.setIcon(img);
        label.setText("penids");
        frame.add(label);
        label.setVisible(true);
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 72));
    }
}
