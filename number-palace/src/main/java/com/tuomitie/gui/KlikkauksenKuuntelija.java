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

    public KlikkauksenKuuntelija(int x, int y, JButton button, Sudoku sudoku) {
        this.x = x;
        this.y = y;
        this.button = button;
        this.sudoku = sudoku;
    }

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
        System.out.print("" + x + y + " ");
    }
}