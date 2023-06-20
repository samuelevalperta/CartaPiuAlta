package it.unibs.ing.fp.lab.cartaalta;

/**
 * Represents the values of Italian playing cards.
 * Implements the {@link IValoreCarta} interface to provide card value and name retrieval functionality.
 */
public enum ValoreCarteItaliane implements IValoreCarta{
    ASSO(11, "ASSO"),
    DUE(2, "DUE"),
    TRE(3, "TRE"),
    QUATTRO(4, "QUATTRO"),
    CINQUE(5, "CINQUE"),
    SEI(6, "SEI"),
    SETTE(7, "SETTE"),
    FANTE(8, "FANTE"),
    CAVALLO(9, "CAVALLO"),
    RE(10, "RE");
    private String nome;
    private int valore;

    /**
     * Constructor for the ValoreCarteItaliane enum.
     *
     * @param valore the integer value associated with the card
     * @param nome the display name for the card
     */
    ValoreCarteItaliane(int valore, String nome) {
        this.valore = valore;
        this.nome = nome;
    }

    @Override
    public String getNome(){
        return nome;
    }

    @Override
    public int getValore(){
        return valore;
    }
}
