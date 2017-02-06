package com.tuomitie.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private JButton[][] napit;

    public Kayttoliittyma() {
        napit = new JButton[9][9];
    }

    @Override
    public void run() {
        frame = new JFrame("number-palace");
        frame.setPreferredSize(new Dimension(500, 410));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new FlowLayout());

        JPanel pelialue = new JPanel(new GridLayout(3, 3));
        pelialue.setPreferredSize(new Dimension(360, 360));
        Border line = new LineBorder(Color.GRAY);
        Border margin = new EmptyBorder(10, 10, 10, 10);
        Border compound = new CompoundBorder(margin, line);
        pelialue.setBorder(compound);

        JPanel painikkeet = new JPanel(new FlowLayout());
        JButton keskeyta = new JButton("Keskeytä");
        painikkeet.add(keskeyta);

        container.add(pelialue);
        container.add(painikkeet);

        JPanel blokit[][] = new JPanel[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                JPanel blokki = new JPanel(new FlowLayout());
                Border viiva = new LineBorder(Color.BLACK);
                blokki.setBorder(viiva);
                blokki.setBackground(Color.white);
                blokit[x][y] = blokki;
                pelialue.add(blokki);
            }
        }

        for (int a = 0; a < 9; a++) {               // Rows
            for (int b = 0; b < 9; b++) {           // Cells
                JButton button = new JButton("5");
                button.setPreferredSize(new Dimension(30, 30));
                button.setContentAreaFilled(false);
                button.setBorder(new LineBorder(Color.white));
                napit[a][b] = button;
                blokit[(int) (a / 3)][(int) (b / 3)].add(button);
            }
        }

    }

    public JFrame getFrame() {
        return frame;
    }
}
