package com.tuomitie.gui;

import com.tuomitie.logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
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
    private JPanel paneeli;
    private JPanel scoret;
    private List<JLabel> scoreLabelit;
    private JButton start;

    /**
     * The main menu GUI used to start the game.
     *
     * @param peli The game instance passed from the Peli class.
     */
    public Valikko(Peli peli) {
        this.peli = peli;
        napit = new ArrayList<>();
        paneeli = new JPanel();
        scoret = new JPanel((new GridLayout(8, 0, 0, 0)));
        scoreLabelit = new ArrayList<>();
    }

    @Override
    public void run() {
        frame = new JFrame("number-palace");

        frame.setPreferredSize(new Dimension(400, 350));
        frame.setLocation(380, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        Savypaneeli rakenne = new Savypaneeli(Color.CYAN, Color.MAGENTA);
        container.add(rakenne);

        JLabel logoTila = new JLabel();                              // Empty element make space for the logo
        logoTila.setPreferredSize(new Dimension(232, 80));
        rakenne.add(logoTila, BorderLayout.NORTH);

        paneeli.setLayout(new GridLayout(1, 2, 0, 0));
        paneeli.setOpaque(false);

        JLabel filleri = new JLabel();      // Empty element to trick the layout
        scoret.add(filleri);
        JLabel otsikko = new JLabel("HAI SCOREZ", SwingConstants.CENTER);   // High Scores header
        otsikko.setFont(new Font("Sans-Serif", Font.BOLD, 21));
        otsikko.setForeground(Color.orange);
        scoret.add(otsikko);

        JLabel rivi1 = new JLabel(peli.getHighScore(0), SwingConstants.CENTER);
        scoreLabelit.add(rivi1);
        scoret.add(rivi1);
        JLabel rivi2 = new JLabel(peli.getHighScore(1), SwingConstants.CENTER);
        scoreLabelit.add(rivi2);
        scoret.add(rivi2);
        JLabel rivi3 = new JLabel(peli.getHighScore(2), SwingConstants.CENTER);
        scoreLabelit.add(rivi3);
        scoret.add(rivi3);
        JLabel rivi4 = new JLabel(peli.getHighScore(3), SwingConstants.CENTER);
        scoreLabelit.add(rivi4);
        scoret.add(rivi4);
        JLabel rivi5 = new JLabel(peli.getHighScore(4), SwingConstants.CENTER);
        scoreLabelit.add(rivi5);
        scoret.add(rivi5);

        for (JLabel l : scoreLabelit) {
            l.setFont(new Font("Sans-Serif", Font.BOLD, 16));
            l.setPreferredSize(new Dimension(60, 10));
        }

        JLabel alafilleri = new JLabel();   // Another embarrassing filler label
        scoret.add(alafilleri);
        paneeli.add(scoret);
        scoret.setOpaque(false);

        JPanel kontrollipaneeli = new JPanel((new GridLayout(6, 0, 0, 10)));   // Control button panel
        kontrollipaneeli.setBorder(new EmptyBorder(10, 30, 10, 20));
        luoKontrollit(kontrollipaneeli);
        kontrollipaneeli.setOpaque(false);

        paneeli.add(kontrollipaneeli);

        rakenne.add(paneeli, BorderLayout.CENTER);
    }

    public void paivitaScoret() {
        System.out.println(scoreLabelit.size());
        for (int i = 0; i < scoreLabelit.size(); i++) {
            scoreLabelit.get(i).setText(peli.getHighScore(i));
        }
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

        start = new JButton("New game");     // A button to check if the board matches the solution
        start.setContentAreaFilled(true);
        start.setBackground(Color.white);
        start.setFocusPainted(false);
        start.addActionListener(new ToimintojenKuuntelija("start", this, peli));
        kontrollipaneeli.add(start);
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
