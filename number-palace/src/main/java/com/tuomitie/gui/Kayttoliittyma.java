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
        frame.setLocation(300, 220);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        Savypaneeli paneeli = new Savypaneeli(Color.CYAN, Color.MAGENTA);
        paneeli.setLayout(new FlowLayout());
        container.add(paneeli);

        pelialue.setPreferredSize(new Dimension(360, 360));     // The game board
        Border line = new LineBorder(Color.GRAY);
        Border margin = new EmptyBorder(10, 0, 10, 10);
        Border compound = new CompoundBorder(margin, line);
        pelialue.setOpaque(false);
        pelialue.setBorder(compound);

        JPanel painikkeet = new JPanel((new GridLayout(4, 0, 0, 10)));   // Control button panel
        luoKontrollit(painikkeet);
        painikkeet.setOpaque(false);

        paneeli.add(pelialue);
        paneeli.add(painikkeet);

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
        JLabel vaikeustaso = new JLabel("Difficulty " + vaikeustasoTahtina(sudoku.getKentta().getVaikeustaso()));
        vaikeustaso.setFont(new Font("Sans-Serif", Font.BOLD, 22));
        vaikeustaso.setHorizontalTextPosition(JLabel.CENTER);
        vaikeustaso.setForeground(Color.orange);
        painikkeet.add(vaikeustaso);

        JButton inspect = new JButton("Inspect");     // A button to check if the board matches the solution
        inspect.addActionListener(new ToimintojenKuuntelija("inspect", this, sudoku));
        napit.add(inspect);                            // Add the button to the list
        painikkeet.add(inspect);                       // Add it to the panel

        JButton solution = new JButton("See the Solution"); // A button to quit and check the solution
        solution.addActionListener(new ToimintojenKuuntelija("solution", this, sudoku));
        napit.add(solution);
        painikkeet.add(solution);

        JButton quit = new JButton("Quit");     // A button to rage-quit
        quit.addActionListener(new ToimintojenKuuntelija("quit", this, sudoku));
        napit.add(quit);
        painikkeet.add(quit);

        for (JButton nappi : napit) {                   // Common styling for all the buttons
            nappi.setContentAreaFilled(true);
            nappi.setBackground(Color.white);
            nappi.setFocusPainted(false);
        }
    }

    public void luoPopUp(String viesti) {
        JOptionPane.showMessageDialog(frame, viesti);
}

    public void luoDialogi(String viesti) {
        Object[] options = {"Yes, end this.", "Let me reconsider."};
        int n = JOptionPane.showOptionDialog(frame,
                viesti,
                "Ending the game",      // Dialog title
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,                   // Do not use a custom Icon
                options,                // The titles of buttons
                options[0]);            // Default button title
        if (n == JOptionPane.YES_OPTION) {
            pelialue.removeAll();       // Fixes a glitch on successive game rounds
            this.sudoku.getPeli().uusiPeli();
            frame.dispose();            // Close the game frame
        }
    }

    public void disabloi(String painike) {
        for (JButton nappi : napit) {
            if (nappi.getText().equalsIgnoreCase(painike)) {
                nappi.setEnabled(false);
            }
        }
    }
    
    public String vaikeustasoTahtina(int taso) {
        if (taso < 125) {
            return "*";
        } else if (taso > 125 && taso < 225) {
            return "**";
        } else {
            return "***";
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
