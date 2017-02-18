package com.tuomitie.logiikka;

/**
 * Kentta is the representation of a Sudoku board in its initial state.
 *
 * @author Tuomas
 */
public class Kentta implements Comparable<Kentta> {

    private final int vaikeustaso;
    private final String nakyma;
    private final String vastaus;

    /**
     * The constructor must be called with all of the three variables of a
     * Kentta.
     *
     * @param vaikeustaso The difficulty level.
     * @param nakyma The player view with hidden cells.
     * @param vastaus The correct solution to the puzzle.
     */
    public Kentta(int vaikeustaso, String nakyma, String vastaus) {
        this.vaikeustaso = vaikeustaso;
        this.nakyma = nakyma;
        this.vastaus = vastaus;
    }

    /**
     * Used to convert the Strings read from file to an array of integers.
     *
     * @param data The string with a representation of the board.
     * @return The one dimensional array of integers made from the input string.
     */
    public int[] taulukkoNumeroina(String data) {
        if (data.contains(".")) {                       // In the case of a player view get rid of the dots
            data = data.replaceAll("\\.", "0");         // and replace them with zeros
        }
        String[] merkit = data.split("");               // Split the String into pieces
        int[] numerot = new int[81];
        for (int i = 0; i < merkit.length; i++) {
            numerot[i] = Integer.valueOf(merkit[i]);    // Convert from String to int
        }
        return numerot;
    }

    public int getVaikeustaso() {
        return vaikeustaso;
    }

    public String getVastaus() {
        return vastaus;
    }

    public String getNakyma() {
        return nakyma;
    }

    @Override
    public int compareTo(Kentta verrattava) {           // For comparing games by based on difficulty
        return this.vaikeustaso - verrattava.getVaikeustaso();
    }
}
