package it.polimi.giovanni.androidsimpleexercise.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by giovanniquattrocchi on 19/10/17.
 */

public class Deck {

    List<Card> cards = new ArrayList<>(40);
    List<Card> discarded = new ArrayList<>(40);


    public Deck(){
        generate();
        shuffle();
    }

    public void shuffle(){
        cards.addAll(discarded);
        discarded.clear();
        Collections.shuffle(cards);
    }

    private void generate(){
        add(new Card(1, "A"), 4);
        add(new Card(2, "2"), 4);
        add(new Card(3, "3"), 4);
        add(new Card(4, "4"), 4);
        add(new Card(5, "5"), 4);
        add(new Card(6, "6"), 4);
        add(new Card(7, "7"), 4);
        add(new Card(0.5f, "J"), 4);
        add(new Card(0.5f, "Q"), 4);
        add(new Card(0.5f, "K"), 4);
    }

    private void add(Card c, int n) {
        for(int i = 0; i < n; i++)
            cards.add(c.clone());
    }

    public Card deal(){
        Card card = cards.get(0);
        cards.remove(0);
        discarded.add(card);
        return card;
    }

}
