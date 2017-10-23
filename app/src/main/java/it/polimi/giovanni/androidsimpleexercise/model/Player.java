package it.polimi.giovanni.androidsimpleexercise.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giovanniquattrocchi on 19/10/17.
 */

public class Player {

    private final String name;
    private float score;
    private List<Card> cards = new ArrayList<>();


    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getScore() {
        return score;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card c){
        cards.add(c);
        score += c.getValue();
    }

}
