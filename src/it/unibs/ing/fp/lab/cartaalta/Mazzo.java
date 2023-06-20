package it.unibs.ing.fp.lab.cartaalta;

import it.unibs.fp.mylib.EstrazioniCasuali;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * This class represents a Mazzo, which is a collection of Carta objects. It provides methods to create and extract cards from the deck.
 */
public class Mazzo {
    private ArrayList<Carta> listCarte = new ArrayList<Carta>();

    /**
     * Constructs a Mazzo object with a specified TipoMazzo, initializing it with a list of Carte obtained from the given TipoMazzo.
     * @param tipo The type of the Mazzo, a predetermined set of Carta objects (Semi and Valori).
     */
    public Mazzo(TipoMazzo tipo) {
        listCarte = costruisciMazzo(tipo.getSemi(), tipo.getValori());
    }

    /**
     * Constructs an ArrayList of Carta objects to represent the deck of cards.
     * It iterates over the semis and valori arrays to create each unique Carta object.
     *
     * @param semi   Array of String objects representing the various suits.
     * @param valori Array of IValoreCarta objects representing the various card values.
     * @return ArrayList of Carta objects representing the resulting deck of cards.
     */
    
    private ArrayList<Carta> costruisciMazzo(String[] semi, IValoreCarta[] valori) {
        ArrayList<Carta> result = new ArrayList<Carta>();
        for (String seme: semi) {
            for (IValoreCarta valore: valori) {
                Carta c = new Carta(seme, valore);
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Extracts a random card from the current deck of cards represented by listCarte.
     * It uses the EstrazioniCasuali.estraiIntero() method to generate a random index and returns the card at that index.
     *
     * @return Carta object representing the extracted card from the listCarte.
     */
    
    public Carta estrai(){
        int estratto = EstrazioniCasuali.estraiIntero(0, listCarte.size()-1);
        return listCarte.get(estratto);
    }
}
