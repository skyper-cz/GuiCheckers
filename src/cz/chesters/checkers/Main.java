package cz.chesters.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.isNull;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkers");
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

        // nefunguje jar >:(
        // if (isNull(imageURL)) {
        //     assert false;
        //     ImageIcon img = new ImageIcon(imageURL);
        //     label.setIcon(img);
        // } else label.setText(":(");
    }
}
