package it.polimi.giovanni.androidsimpleexercise.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import it.polimi.giovanni.androidsimpleexercise.R;
import it.polimi.giovanni.androidsimpleexercise.model.Card;
import it.polimi.giovanni.androidsimpleexercise.model.Player;
import it.polimi.giovanni.androidsimpleexercise.model.SevenAndHalf;

public class Ex11Activity extends AppCompatActivity implements SevenAndHalf.SevenAndHalfListener {

    private SevenAndHalf sh = SevenAndHalf.sharedGame();
    Player p1 = new Player("ME");
    SevenAndHalf.Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex11);

        Player p2 = new Player("CPU");

        sh.startWithPlayers(this, p1, p2);

    }

    public void deal(View view){
        sh.deal();
        Card card = p1.getCards().get(p1.getCards().size() - 1);
        float score = p1.getScore();
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(""+score);
        TextView cardView = (TextView) findViewById(R.id.card);
        cardView.setText(card.getDescription());
    }

    public void stay(View view){
        sh.stay();
    }

    public void stats(View view){
        startActivity(new Intent(this, Ex11StatsActivity.class));
    }

    @Override
    public void endMatchWithResult(SevenAndHalf.Result result, SevenAndHalf.Stats stats) {
        this.result = result;
    }

    @Override
    public void turnChanged(Player oldPlayer, Player currentPlayer) {
        if(oldPlayer == p1)
            startActivityForResult(new Intent(this, Ex11DealerActivity.class), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        final Activity self = this;

        if (requestCode == 1 && resultCode == 1){
            if (result != null){
                String message = "You Win";

                if(result.players.get(result.winnerIndex) != p1){
                    message = "You Loose";
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(message);

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(self, self.getClass());
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                builder.create().show();
                result = null;

            }
        }
        else {
            Intent intent = new Intent(self, self.getClass());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
