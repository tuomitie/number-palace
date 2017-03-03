package com.tuomitie.gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

/**
 * A custom JPanel that has a color gradient running across it.
 *
 * @author tuomas
 */
public class Savypaneeli extends JPanel {

    private Color alkuvari;
    private Color loppuvari;
    private BufferedImage logo;

    /**
     * Constructor takes the two colors used in the gradient.
     *
     * @param alkuvari Start color.
     * @param loppuvari End color.
     */
    public Savypaneeli(Color alkuvari, Color loppuvari) {
        super();
        this.alkuvari = alkuvari;
        this.loppuvari = loppuvari;
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("number-palace-header.png");
            logo = ImageIO.read(is);
        } catch (IOException ex) {
            System.out.println("Logoa ei löytynyt");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int korkeus = getHeight();
        int leveys = getWidth();
        GradientPaint gradientPaint = new GradientPaint(0, 0, alkuvari, leveys, korkeus, loppuvari);
        if (g instanceof Graphics2D) {
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setPaint(gradientPaint);
            graphics2D.fillRect(0, 0, leveys, korkeus);
            if (korkeus > 200) {
                g.drawImage(logo, 90, 20, this); // see javadoc for more info on the parameters
            }
        }
    }
}
