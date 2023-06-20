package it.unibs.ing.fp.lab.cartaalta;

/**
 * IValoreCarta interface provides methods for obtaining the name and value of a card in a card game.
 *
 * This interface must be implemented by classes that represent different types of cards in a card game. Implementing
 * this interface allows for retrieving the card's name and value as string and integer respectively.
 *
 * - getNome:     Returns the card name as a string
 * - getValore:   Returns the card value as an integer
 */
public interface IValoreCarta {
    String getNome();
    int getValore();
}
