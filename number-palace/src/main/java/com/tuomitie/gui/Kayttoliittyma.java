package com.tuomitie.gui;

import com.tuomitie.logiikka.Sudoku;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Kayttoliittyma implements Runnable {

    private Sudoku sudoku;

    private JFrame frame;
    private JPanel pelialue;
    private JPanel[][] blokit;
    private JButton[][] alkiot;
    private List<JButton> napit;

    private Color reunat;
    private Font numeroFontti;

    public Kayttoliittyma(Sudoku sudoku) {
        this.sudoku = sudoku;

        pelialue = new JPanel(new GridLayout(3, 3));
        blokit = new JPanel[3][3];
        alkiot = new JButton[9][9];
        napit = new ArrayList<>();

        numeroFontti = new Font("Sans-Serif", Font.BOLD, 21);
    }

    @Override
    public void run() {
        frame = new JFrame("number-palace");
        frame.setPreferredSize(new Dimension(550, 400));
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new FlowLayout());

        pelialue.setPreferredSize(new Dimension(360, 360));     // The game board
        Border line = new LineBorder(Color.GRAY);
        Border margin = new EmptyBorder(10, 0, 10, 10);
        Border compound = new CompoundBorder(margin, line);
        pelialue.setBorder(compound);

        JPanel painikkeet = new JPanel((new GridLayout(4, 1, 0, 10)));   // Control button panel
        luoKontrollit(painikkeet);

        container.add(pelialue);
        container.add(painikkeet);

        luoBlokit();                                            // Create the 3x3 sub-blocks for the board
        alustaRuudukko();                   // Create the number cells
    }

    public void luoBlokit() {               // Create the smaller 3x3 blocks (mostly for visual purposes here)
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                JPanel blokki = new JPanel(new GridLayout(3, 3, 0, 0));    // 3x3 blocks with zero margin
                Border viiva = new LineBorder(Color.BLACK);
                blokki.setBorder(viiva);
                blokki.setBackground(Color.white);
                blokit[x][y] = blokki;
                pelialue.add(blokki);
            }
        }
    }

    public void alustaRuudukko() {
        int[][] taulukko = sudoku.getTilanne();
        for (int x = 0; x < 9; x++) {               // Rows
            for (int y = 0; y < 9; y++) {           // Cells
                JButton button = new JButton(" ");  // Init with empty string
                if (taulukko[x][y] != 0) {           // If contains a "given" set that number and make disabled
                    button.setText("" + taulukko[x][y]);
                    button.setEnabled(false);
                } else {                            // If empty, make clickable
                    button.setFocusPainted(false);  // Hide content highlighting
                    button.addActionListener(new KlikkauksenKuuntelija(x, y, button, sudoku));
                }
                button.setContentAreaFilled(false); // Hide cell styling
                button.setPreferredSize(new Dimension(30, 30));
                button.setFont(numeroFontti);
                button.setBorder(new LineBorder(Color.lightGray));
                alkiot[x][y] = button;              // Add into the 9x9 button table
                blokit[x / 3][y / 3].add(button);   // Add into block [0, 1 or 2][0, 1 or 2]
            }
        }
    }

    public void naytaRatkaisu() {
        int[][] ratkaisu = sudoku.getRatkaisu();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                alkiot[x][y].setText("" + ratkaisu[x][y]);
                alkiot[x][y].setEnabled(false);
            }
        }
    }

    public void luoKontrollit(JPanel painikkeet) {
        JLabel vaikeustaso = new JLabel("Diff. " + sudoku.getKentta().getVaikeustaso());
        vaikeustaso.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        vaikeustaso.setHorizontalTextPosition(JLabel.CENTER);
        painikkeet.add(vaikeustaso);

        JButton tarkista = new JButton("Tarkista");     // A button to check if the board matches the solution
        tarkista.addActionListener(new ToimintojenKuuntelija("tarkista", this, sudoku));
        napit.add(tarkista);                            // Add the button to the list
        painikkeet.add(tarkista);                       // Add it to the panel

        JButton vastaus = new JButton("Katso vastaus"); // A button to quit and check the solution
        vastaus.addActionListener(new ToimintojenKuuntelija("vastaus", this, sudoku));
        napit.add(vastaus);
        painikkeet.add(vastaus);

        JButton keskeyta = new JButton("Keskeytä");     // A button to rage-quit
        keskeyta.addActionListener(new ToimintojenKuuntelija("keskeyta", this, sudoku));
        keskeyta.setEnabled(false);
        napit.add(keskeyta);
        painikkeet.add(keskeyta);

        for (JButton nappi : napit) {                   // Common styling for all the buttons
            nappi.setContentAreaFilled(false);
            nappi.setFocusPainted(false);
        }
    }

    public void luoPopUp(String viesti) {
        JOptionPane.showMessageDialog(frame, viesti);
    }

    public void disabloi(String painike) {
        for (JButton nappi : napit) {
            if (nappi.getText().equalsIgnoreCase(painike)) {
                nappi.setEnabled(false);
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
