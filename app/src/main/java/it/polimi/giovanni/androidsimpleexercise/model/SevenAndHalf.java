package it.polimi.giovanni.androidsimpleexercise.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by giovanniquattrocchi on 19/10/17.
 */

public class SevenAndHalf {

    private static SevenAndHalf sh = new SevenAndHalf();
    private final float threshold = 7.5f;
    private Deck deck = new Deck();
    private SevenAndHalfListener listener;
    private List<Player> players = new ArrayList<>();
    private Stats stats = new Stats();
    int turnIndex;

    private SevenAndHalf(){}


    public void startWithPlayers(SevenAndHalfListener listener, Player... ps){
        players.clear();
        players.addAll(Arrays.asList(ps));
        turnIndex = 0;
        this.listener = listener;
    }


    public static SevenAndHalf sharedGame(){
        return sh;
    }

    public void deal(){
        Player p = players.get(turnIndex);
        Card c = deck.deal();
        p.addCard(c);
        if (p.getScore() >= threshold){
            stay();
        }
    }

    public Card getCurrentCard(){
        List<Card> cards = players.get(turnIndex).getCards();
        return cards.get(cards.size()-1);
    }

    public float getCurrentScore(){
        return players.get(turnIndex).getScore();
    }

    public float currentMaxScore(){
        return players.get(computeWinner()).getScore();
    }

    public void stay(){
        if(turnIndex < players.size()-1){
            turnIndex++;
            listener.turnChanged(players.get(turnIndex-1), players.get(turnIndex));
        }
        else {
            int winner = computeWinner();
            Result result = new Result(new ArrayList<>(players), winner);
            stats.addResult(result);
            listener.endMatchWithResult(result, stats);
        }
    }

    private int computeWinner(){
        int i = 0;
        int winner = -1;
        float currentMaxScore = -1;
        for (Player p : players){
            if (p.getScore() >= currentMaxScore && p.getScore() <= threshold){
                winner = i;
                currentMaxScore = p.getScore();
            }
            i++;
        }

        if(winner == -1){
            winner = players.size()-1;
        }

        return winner;
    }

    public Stats stats(){
        return stats;
    }

    public interface SevenAndHalfListener {
        public void endMatchWithResult(Result result, Stats stats);
        public void turnChanged(Player oldPlayer, Player currentPlayer);

    }

    public class Result {

        public final List<Player> players;
        public final int winnerIndex;

        private Result(List<Player> players, int winnerIndex){
            this.players = new ArrayList<>(players);
            this.winnerIndex = winnerIndex;
        }

        public String toString() {
            String res = "WINNER "+players.get(winnerIndex).getName()+"\n";
            for (Player p : players){
                res+=p.getName()+": "+p.getScore()+"  ";
            }

            return res;
        }
    }

    public class Stats {

        private List<Result> results = new ArrayList<>();
        private Stats(){}

        protected void addResult(Result result){
            results.add(0, result);
        }

        public List<Result> getResult(){
            return new ArrayList<>(results);
        }


    }


}
