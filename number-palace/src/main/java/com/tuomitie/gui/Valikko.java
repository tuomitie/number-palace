package com.tuomitie.gui;

import com.tuomitie.logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Valikko implements Runnable {

    private Peli peli;

    private JFrame frame;
    private List<JButton> napit;
    private JComboBox vaikeusLista;

    /**
     * The main menu GUI used to start the game.
     *
     * @param peli The game instance passed from the Peli class.
     */
    public Valikko(Peli peli) {
        this.peli = peli;
        napit = new ArrayList<>();
    }

    @Override
    public void run() {
        frame = new JFrame("number-palace");

        frame.setPreferredSize(new Dimension(400, 330));
        frame.setLocation(380, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        Savypaneeli rakenne = new Savypaneeli(Color.CYAN, Color.MAGENTA);
        container.add(rakenne);

        JLabel logoTila = new JLabel();                              // Empty element to trick the layout
        logoTila.setPreferredSize(new Dimension(232, 80));
        rakenne.add(logoTila, BorderLayout.NORTH);

        JPanel paneeli = new JPanel();
        paneeli.setLayout(new GridLayout(1, 2, 0, 0));
        paneeli.setOpaque(false);

        JPanel scoret = new JPanel((new GridLayout(8, 0, 0, 0)));   // High Scores pane
        JLabel filleri = new JLabel();                              // Empty element to trick the layout
        scoret.add(filleri);
        JLabel otsikko = new JLabel("HAI SCOREZ", SwingConstants.CENTER);   // High Scores header
        otsikko.setFont(new Font("Sans-Serif", Font.BOLD, 21));
        otsikko.setForeground(Color.orange);
        scoret.add(otsikko);
        for (int i = 1; i <= 5; i++) {      // Five top scores
            JLabel rivi = new JLabel("" + (350 - i * 50) + " - TPT", SwingConstants.CENTER);
            rivi.setFont(new Font("Sans-Serif", Font.BOLD, 16));
            rivi.setPreferredSize(new Dimension(60, 10));
            scoret.add(rivi);
        }
        JLabel alafilleri = new JLabel();   // Another embarrassing filler label
        scoret.add(alafilleri);
        scoret.setOpaque(false);

        JPanel kontrollipaneeli = new JPanel((new GridLayout(6, 0, 0, 10)));   // Control button panel
        kontrollipaneeli.setBorder(new EmptyBorder(10, 30, 10, 20));
        luoKontrollit(kontrollipaneeli);
        kontrollipaneeli.setOpaque(false);

        paneeli.add(scoret);
        paneeli.add(kontrollipaneeli);

        rakenne.add(paneeli, BorderLayout.CENTER);
    }

    public void luoKontrollit(JPanel kontrollipaneeli) {

        JLabel filleri = new JLabel();
        kontrollipaneeli.add(filleri);

        JLabel vaikeusLabel = new JLabel("Valitse vaikeustaso:");
        kontrollipaneeli.add(vaikeusLabel);
        String[] vaikeustasot = {"   easy", "   semi", "   hard", "   random"};
        vaikeusLista = new JComboBox(vaikeustasot);
        vaikeusLista.setPreferredSize(new Dimension(60, 10));
        vaikeusLista.setSelectedIndex(1);
        kontrollipaneeli.add(vaikeusLista);

        JButton aloita = new JButton("New game");     // A button to check if the board matches the solution
        aloita.setContentAreaFilled(true);
        aloita.setBackground(Color.white);
        aloita.setFocusPainted(false);
        aloita.addActionListener(new ToimintojenKuuntelija("start", this, peli));
        kontrollipaneeli.add(aloita);

    }

    public JFrame getFrame() {
        return frame;
    }

    public Peli getPeli() {
        return peli;
    }

    public JComboBox getVaikeusLista() {
        return vaikeusLista;
    }
}
