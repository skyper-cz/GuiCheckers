package cz.chesters.checkers;

import cz.chesters.checkers.buttonVec.ButtonVec;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (System.console() != null) {
            String userinput;
            Scanner scanner = new Scanner(System.in);

            System.out.print("Co dáme za prográmek? ");
            System.out.print(Mik.BLACK + Mik.BG_BLUE + "TESTOVACÍ" + Mik.RESET + ", ");
            System.out.print(Mik.BLACK + Mik.BG_PURPLE + "PLUS MINUS VĚC" + Mik.RESET + ", ");
            System.out.print(Mik.BLACK + Mik.BG_GREEN + "KALKULAČKA" + Mik.RESET);

            userinput = scanner.nextLine();

            if (userinput.toLowerCase(Locale.ROOT).contains("ka") || userinput.toLowerCase(Locale.ROOT).contains("ca")){
                Calculator calc = new Calculator();
                calc.doShit();
            }
            else if (userinput.toLowerCase(Locale.ROOT).contains("plus") || userinput.toLowerCase(Locale.ROOT).contains("minus") || userinput.toLowerCase(Locale.ROOT).contains("vec")||userinput.toLowerCase(Locale.ROOT).contains("věc")||userinput.toLowerCase(Locale.ROOT).contains("mínus")){
                PlusMinusVec plusMinusVec = new PlusMinusVec();
                plusMinusVec.plusMinusBtn();
            }
            else if (userinput.toLowerCase(Locale.ROOT).contains("t")){
                test();
            }
        } else {
            Calculator calc = new Calculator();
            ButtonVec btnvec = new ButtonVec();
            btnvec.doStuff();
        }

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
