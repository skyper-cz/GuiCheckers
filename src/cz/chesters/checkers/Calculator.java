package cz.chesters.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator {
    JFrame frame = new JFrame("Kalklačka");

    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b0 = new JButton("0");
    JButton carka = new JButton(".");

    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton deleno = new JButton("/");
    JButton krat = new JButton("*");

    JButton rovnase = new JButton("=");
    JButton clear = new JButton("C");

    JButton sudost = new JButton("odd");
    JButton prvoc = new JButton("prm");
    JButton round1 = new JButton("≈1");
    JButton round10 = new JButton("≈10");

    JLabel cislicka = new JLabel("0");


    public void doShit() {
        drawKalkulacka();
    }

    public void drawKalkulacka() {
        frame.setSize(500, 615);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        cislicka.setBounds(5, 5, 490, 50);
        // newline na 60

        clear.setBounds(5, 65, 115, 80);
        // konec x je 120

        deleno.setBounds(125, 65, 115, 80);
        // konec x je 240

        krat.setBounds(245, 65, 115, 80);
        // konec x je 360

        minus.setBounds(365, 65, 115, 80);
        // konec x je 480
        // newline na 145

        b9.setBounds(5, 150, 115, 80);
        // konec x je 120

        b8.setBounds(125, 150, 115, 80);
        // konec x je 240

        b7.setBounds(245, 150, 115, 80);
        // konec x je 360

        plus.setBounds(365, 150, 115, 165);
        // konec x je 480
        // newline na 230

        b6.setBounds(5, 235, 115, 80);
        // konec x je 120

        b5.setBounds(125, 235, 115, 80);
        // konec x je 240

        b4.setBounds(245, 235, 115, 80);
        // konec x je 360
        // plus už okupuje zbytek řádku, takže newline
        // newline na 315

        b3.setBounds(5, 320, 115, 80);
        // konec x je 120

        b2.setBounds(125, 320, 115, 80);
        // konec x je 240

        b1.setBounds(245, 320, 115, 80);
        // konec x je 360

        rovnase.setBounds(365, 320, 115, 165);
        // konec x je 480
        // newline na 400

        b0.setBounds(5, 405, 235, 80);
        // konec x je 240

        carka.setBounds(245, 405, 115, 80);
        // konec x je 360
        // zbytek řádku už okupuje rovná se, takže newline
        // newline na 485

        sudost.setBounds(5, 490, 115, 80);
        // konec x je 120

        prvoc.setBounds(125, 490, 115, 80);
        // konec x je 240

        round1.setBounds(245, 490, 115, 80);
        // konec x je 360

        round10.setBounds(365, 490, 115, 80);

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(b0);
        frame.add(carka);
        frame.add(plus);
        frame.add(minus);
        frame.add(deleno);
        frame.add(krat);
        frame.add(rovnase);
        frame.add(clear);
        frame.add(sudost);
        frame.add(prvoc);
        frame.add(round1);
        frame.add(round10);

        b1.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        b2.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        b3.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        b4.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        b5.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        b6.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        b7.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        b8.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        b9.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        b0.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        carka.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        plus.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        minus.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        deleno.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        krat.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        rovnase.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        clear.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        sudost.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        prvoc.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        round1.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        round10.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));

        b1.addActionListener(this::hugeTittyBoobFuck);
        b2.addActionListener(this::hugeTittyBoobFuck);
        b3.addActionListener(this::hugeTittyBoobFuck);
        b4.addActionListener(this::hugeTittyBoobFuck);
        b5.addActionListener(this::hugeTittyBoobFuck);
        b6.addActionListener(this::hugeTittyBoobFuck);
        b7.addActionListener(this::hugeTittyBoobFuck);
        b8.addActionListener(this::hugeTittyBoobFuck);
        b9.addActionListener(this::hugeTittyBoobFuck);
        b0.addActionListener(this::hugeTittyBoobFuck);
        carka.addActionListener(this::hugeTittyBoobFuck);
        plus.addActionListener(this::hugeTittyBoobFuck);
        minus.addActionListener(this::hugeTittyBoobFuck);
        deleno.addActionListener(this::hugeTittyBoobFuck);
        krat.addActionListener(this::hugeTittyBoobFuck);
        rovnase.addActionListener(this::hugeTittyBoobFuck);
        clear.addActionListener(this::hugeTittyBoobFuck);
        sudost.addActionListener(this::hugeTittyBoobFuck);
        prvoc.addActionListener(this::hugeTittyBoobFuck);
        round1.addActionListener(this::hugeTittyBoobFuck);
        round10.addActionListener(this::hugeTittyBoobFuck);
    }

    void hugeTittyBoobFuck(ActionEvent e) {

    }
}
