package com.tuomitie.gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Savypaneeli extends JPanel {

    private Color alkuvari;
    private Color loppuvari;

    public Savypaneeli(Color alkuvari, Color loppuvari) {
        super();
        this.alkuvari = alkuvari;
        this.loppuvari = loppuvari;
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
        }
    }
}
