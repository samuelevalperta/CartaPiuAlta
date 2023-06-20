package it.unibs.ing.fp.lab.cartaalta;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Partita {
    private String nomeGiocatore;
    private int credito;
    private Mazzo mazzo;

    public Partita(String nomeGiocatore, int credito, TipoMazzo tipo) {
        controlloCredito(credito);
        this.nomeGiocatore = nomeGiocatore;
        this.credito = credito;
        this.mazzo = tipo == TipoMazzo.ITALIANO ? new MazzoItaliano() : new MazzoFrancese();
    }

    public Partita(String nomeGiocatore, int credito) {
        controlloCredito(credito);
        this.nomeGiocatore = nomeGiocatore;
        this.credito = credito;
        this.mazzo = new MazzoItaliano();
    }

    private void controlloCredito (int credito){
        if (credito <= 0) {
            throw new IllegalArgumentException("Il saldo iniziale non puo essere minore di 1");
        }
    }

    public Carta estraiCarta(){
        return this.mazzo.estrai();
    }

    public EsitoScommessa scommetti(int puntata, Carta cartaGiocatore, Carta cartaComputer) {
        int differenza = cartaGiocatore.compareTo(cartaComputer);
        EsitoScommessa esito = calcolaEsito(differenza);
        aggiornaSaldoGiocatore(esito, puntata);
        return esito;
    }

    private EsitoScommessa calcolaEsito(int differenza) {
        if (differenza > 0) {
            return EsitoScommessa.VINTA;
        } else if (differenza == 0) {
            return EsitoScommessa.PATTA;
        }
        return EsitoScommessa.PERSA;
    }

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
