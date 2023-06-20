package it.unibs.ing.fp.lab.cartaalta;

/**
 * ValoreCarteFrancesi is an enumeration that represents the values of French playing cards.
 * It implements the IValoreCarta interface, providing methods to get the name and the value of the cards.
 *
 * The enum has the following values:
 * - ASSO, with value 11
 * - DUE, with value 2
 * - TRE, with value 3
 * - QUATTRO, with value 4
 * - CINQUE, with value 5
 * - SEI, with value 6
 * - SETTE, with value 7
 * - OTTO, with value 8
 * - NOVE, with value 9
 * - DIECI, with value 10
 * - JACK, with value 11
 * - DONNA, with value 12
 * - RE, with value 13
 */
public enum ValoreCarteFrancesi implements IValoreCarta {
    ASSO(11, "ASSO"),
    DUE(2, "DUE"),
    TRE(3, "TRE"),
    QUATTRO(4, "QUATTRO"),
    CINQUE(5, "CINQUE"),
    SEI(6, "SEI"),
    SETTE(7, "SETTE"),
    OTTO(8, "OTTO"),
    NOVE(9, "NOVE"),
    DIECI(10, "DIECI"),
    JACK(11, "JACK"),
    DONNA(12, "REGINA"),
    RE(13, "RE");

    private int valore;
    private String nome;

    /**
     * The constructor for ValoreCarteFrancesi enumeration. It sets the value and the name of an enumeration entry.
     *
     * @param valore the integer value representing the value of the French playing card
     * @param nome the String value representing the name of the French playing card
     */
    ValoreCarteFrancesi(int valore, String nome) {
        this.valore = valore;
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getValore() {
        return valore;
    }
}
