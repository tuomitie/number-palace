package com.tuomitie.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlikkauksenKuuntelija implements ActionListener {
    
    private int x;
    private int y;

    public KlikkauksenKuuntelija(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("" + x + y + " painettu.");
    }
}