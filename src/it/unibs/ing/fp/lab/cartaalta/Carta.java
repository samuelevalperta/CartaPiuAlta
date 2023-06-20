package it.unibs.ing.fp.lab.cartaalta;

public class Carta {
    private String seme;
    private IValoreCarta valore;


    /**
     * Carta class represents a playing card with a suit (seme) and a value (valore).
     * Initializes a new Carta object with the specified suit and value.
     *
     * @param seme   The suit of the card as a String
     * @param valore The value of the card as an instance of the IValoreCarta interface
     */
    public Carta(String seme, IValoreCarta valore) {
        this.seme = seme;
        this.valore = valore;
    }

    /**
     * Retrieves the suit of the card.
     *
     * @return The suit of the card as a String.
     */
    
    public String getSeme() {
        return seme;
    }

    /**
      * Retrieves the value of the card.
      *
      * @return the value of the card as an instance of the IValoreCarta interface
      */
    public IValoreCarta getValore() {
        return valore;
    }

    /**
     * Compares this Carta object to another Carta object based on their values.
     *
     * @param carta The second Carta object to compare to this one
     * @return An integer indicating the comparison result:
     *         positive if this Carta's value is greater,
     *         negative if lesser,
     *         or zero if equal
     */
    
    public int compareTo(Carta carta) {
        return valore.getValore() - carta.getValore().getValore();
    }

    @Override
    public String toString() {
        return valore.getNome() + " di " + this.seme;
    }
}
