package com.tuomitie.gui;

import com.tuomitie.logiikka.Sudoku;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class KlikkauksenKuuntelija implements ActionListener {

    private final int x;
    private final int y;
    private final JButton button;
    private Sudoku sudoku;

    /**
     * KlikkauksenKuuntelija handles the mouse clicks on the player board.
     * 
     * @param x The row of the location of the button.
     * @param y The column of the location.
     * @param button The button in question.
     * @param sudoku The Sudoku game the button affects.
     */
    public KlikkauksenKuuntelija(int x, int y, JButton button, Sudoku sudoku) {
        this.x = x;
        this.y = y;
        this.button = button;
        this.sudoku = sudoku;
    }

    /**
     * Increments the cell in the game and the button representing it on the board.
     * Only displays the valid Sudoku numbers 1-9, and resets to (hidden) zero after reaching 9.
     */
    public void kasvata() {
        int luku = sudoku.haePelikentanSolu(x, y);
        if (luku >= 0 & luku < 9) {
            luku++;
            sudoku.asetaNumero("" + (x + 1) + (y + 1) + luku);
            button.setText(String.valueOf(luku));
        } else if (luku == 9) {
            sudoku.asetaNumero("" + (x + 1) + (y + 1) + 0);
            button.setText(" ");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        kasvata();
    }
}