package it.unibs.ing.fp.lab.cartaalta;

import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * Represents a "Partita" (game) class for card games that tracks a player's credit balance, assesses the outcome of bets,
 * and manages the player's details. The Partita class is initialized using a player's name and initial credit balance,
 * and utilizes Mazzo objects to manage the deck of cards.
 *
 * It provides methods to:
 * - Extract cards from the deck
 * - Evaluate an EsitoScommessa (bet outcome) while updating the player's credit
 * - Check if the game is finished
 * - Get and set the player's name, credit balance, and deck of cards (Mazzo object)
 */
public class Partita {
    private String nomeGiocatore;
    private int credito;
    private Mazzo mazzo;

    /**
     * Creates a new Partita instance with the given player name, initial credit, and type of card deck.
     *
     * @param nomeGiocatore  The name of the player
     * @param credito        The initial credit of the player
     * @param tipo           The type of card deck to be used, must be either TipoMazzo.ITALIANO or TipoMazzo.FRANCESE
     *
     * @throws IllegalArgumentException If the initial credit value is less than or equal to 0
     */
    public Partita(String nomeGiocatore, int credito, TipoMazzo tipo) {
        controlloCredito(credito);
        this.nomeGiocatore = nomeGiocatore;
        this.credito = credito;
        this.mazzo = tipo == TipoMazzo.ITALIANO ? new MazzoItaliano() : new MazzoFrancese();
    }

    /**
     * Constructor to create a new Partita instance with the given player's name and initial credit balance.
     * Initializes the default Italian deck (MazzoItaliano) for the game.
     *
     * @param nomeGiocatore the player's name (String)
     * @param credito the initial credit balance of the player (int)
     * @throws IllegalArgumentException if the provided credit is less than or equal to 0
     */
    public Partita(String nomeGiocatore, int credito) {
        controlloCredito(credito);
        this.nomeGiocatore = nomeGiocatore;
        this.credito = credito;
        this.mazzo = new MazzoItaliano();
    }

    /**
     * Validates the given credit value and throws IllegalArgumentException if the credit value is less than or equal to 0.
     *
     * @param credito The credit value to be validated, as int
     * @throws IllegalArgumentException If the credit value is less than or equal to 0
     * */
    
    private void controlloCredito (int credito){
        if (credito <= 0) {
            throw new IllegalArgumentException("Il saldo iniziale non puo essere minore di 1");
        }
    }

    /**
     * Extracts a card from the deck in the current game.
     *
     * @return A Carta object representing the extracted card
     */
    
    public Carta estraiCarta(){
        return this.mazzo.estrai();
    }

    /**
     * This scommetti method takes a bet amount, a player's card, and a computer's card to determine the outcome of a bet in a card game.
     * It calculates the difference between the player and computer cards using the compareTo method, and then calculates the bet result using
     * the private calcolaEsito method. The player's credit balance is updated accordingly. Finally, it returns the bet outcome (EsitoScommessa).
     *
     * @param puntata         The bet amount (int)
     * @param cartaGiocatore  The player's card (Carta)
     * @param cartaComputer   The computer's card (Carta)
     * @return                The outcome of the bet (EsitoScommessa)
     */
    public EsitoScommessa scommetti(int puntata, Carta cartaGiocatore, Carta cartaComputer) {
        int differenza = cartaGiocatore.compareTo(cartaComputer);
        EsitoScommessa esito = calcolaEsito(differenza);
        aggiornaSaldoGiocatore(esito, puntata);
        return esito;
    }

    /**
     * Calculates the outcome of a bet (EsitoScommessa) based on the difference calculated from player and computer cards comparison.
     *
     * @param differenza The difference in value of the player and computer cards
     * @return EsitoScommessa - VINTA if the player has a higher card value, PATTA if the card values are equal, PERSA if
     *                         the player has a lower card value
     */
    private EsitoScommessa calcolaEsito(int differenza) {
        if (differenza > 0) {
            return EsitoScommessa.VINTA;
        } else if (differenza == 0) {
            return EsitoScommessa.PATTA;
        }
        return EsitoScommessa.PERSA;
    }
    
    /**
     * Updates the credit balance of a player based on the outcome of a bet (EsitoScommessa) and the bet amount (puntata).
     * If the outcome is VINTA, the player's credit is increased by the bet amount.
     * If the outcome is PERSA, the player's credit is decreased by the bet amount.
     * The method does nothing for other outcomes.
     *
     * @param esito   The outcome of the bet, of type EsitoScommessa
     * @param puntata The bet amount, of type int
     */
    private void aggiornaSaldoGiocatore(EsitoScommessa esito, int puntata) {
        switch(esito) {
            case VINTA:
                this.credito = this.credito + puntata;
                break;

            case PERSA:
                this.credito = this.credito - puntata;
                break;

            default:
                break;
        }
    }

    public boolean isFinita() {
        return this.credito <= 0;
    }
    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

    public void setNomeGiocatore(String nomeGiocatore) {
        this.nomeGiocatore = nomeGiocatore;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public Mazzo getMazzo() {
        return mazzo;
    }

    public void setMazzo(Mazzo mazzo) {
        this.mazzo = mazzo;
    }
}
