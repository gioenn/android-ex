package it.polimi.giovanni.androidsimpleexercise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import it.polimi.giovanni.androidsimpleexercise.R;
import it.polimi.giovanni.androidsimpleexercise.model.Card;
import it.polimi.giovanni.androidsimpleexercise.model.SevenAndHalf;

public class Ex11DealerActivity extends AppCompatActivity {


    SevenAndHalf sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex11_dealer);

        sh = SevenAndHalf.sharedGame();
    }

    public void next(View view){

        sh.deal();
        Card card = sh.getCurrentCard();
        float score = sh.getCurrentScore();
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(""+score);
        TextView cardView = (TextView) findViewById(R.id.card);
        cardView.setText(card.getDescription());

        if(sh.currentMaxScore() <= sh.getCurrentScore()) {
            sh.stay();
            setResult(1);
            finish();
        }


    }

}
