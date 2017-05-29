package it.polimi.giovanni.androidsimpleexercise.model;

/**
 * Created by giovanniquattrocchi on 29/05/17.
 */

public class Calculator {

    public int sum(int a, int b){
        return a+b;
    }

    public int sub(int a, int b){
        return a-b;
    }

    public int mul(int a, int b){
        return a*b;
    }

    public int fact(int a){
        return factImpl(a, 1);
    }

    public int pow(int a, int b){
        return powImpl(a, b, 1);
    }

    private int factImpl(int a, int acc){
        if (a == 1)
            return acc;
        return factImpl(a-1, a*acc);
    }

    private int powImpl(int a, int b, int acc){
        if (b == 0) {
            return acc;
        }
        return powImpl(a, b-1, a*acc);
    }
}
