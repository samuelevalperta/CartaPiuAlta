package it.unibs.ing.fp.lab.cartaalta;

import it.unibs.fp.mylib.EstrazioniCasuali;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mazzo {
    private ArrayList<Carta> listCarte = new ArrayList<Carta>();

    public Mazzo(TipoMazzo tipo) {
        listCarte = costruisciMazzo(tipo.getSemi(), tipo.getValori());
    }

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

    public Carta estrai(){
        int estratto = EstrazioniCasuali.estraiIntero(0, listCarte.size()-1);
        return listCarte.get(estratto);
    }
}
