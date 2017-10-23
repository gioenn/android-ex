package it.polimi.giovanni.androidsimpleexercise.model;

/**
 * Created by giovanniquattrocchi on 19/10/17.
 */

public class Card  {

    private float value;
    private String description;

    public Card(float value, String description){
        this.value = value;
        this.description = description;
    }

    public float getValue(){
        return value;
    }

    public String getDescription(){
        return description;
    }

    @Override
    protected Card clone()  {
        return new Card(value, description);
    }

}
