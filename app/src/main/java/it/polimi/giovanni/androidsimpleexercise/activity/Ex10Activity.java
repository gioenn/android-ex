

package it.polimi.giovanni.androidsimpleexercise.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import it.polimi.giovanni.androidsimpleexercise.R;
import it.polimi.giovanni.androidsimpleexercise.model.Calculator;

public class Ex10Activity extends AppCompatActivity {

    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex9);
    }

    private String sum(ViewGroup view) throws NumberFormatException {
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.sum(a, b);
        return a + "+" + b + "=" + res;
    }

    private String sub(ViewGroup view) throws NumberFormatException {
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.sub(a, b);
        return a + "-" + b + "=" + res;
    }

    private String mul(ViewGroup view) throws NumberFormatException {
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.mul(a, b);
        return a + "*" + b + "=" + res;
    }

    private String fact(ViewGroup view) throws NumberFormatException {
        int a = getTermFromViewAtIndex(view, 0);
        int res = calculator.fact(a);
        return a + "!" + "=" + res;
    }

    private String pow(ViewGroup view) throws NumberFormatException {
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.pow(a, b);
        return a + "^" + b + "=" + res;
    }

    public void compute(View view) {
        ViewGroup outerGroup = (ViewGroup) view.getParent().getParent();
        ArrayList<String> res = new ArrayList<>();

        try {
            res.add(sum((ViewGroup) outerGroup.getChildAt(0)));
            res.add(sub((ViewGroup) outerGroup.getChildAt(1)));
            res.add(mul((ViewGroup) outerGroup.getChildAt(2)));
            res.add(fact((ViewGroup) outerGroup.getChildAt(3)));
            res.add(pow((ViewGroup) outerGroup.getChildAt(4)));
            Intent intent = new Intent(this, Ex9ResultActivity.class);
            intent.putStringArrayListExtra("results", res);
            startActivity(intent);
        }
        catch (NumberFormatException e){
            System.out.println(e.getClass());
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.warning).setCancelable(false);

            builder.setPositiveButton(R.string.positive_confirm, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            AlertDialog alert = builder.create();
            alert.show();
        }



    }

    private int getTermFromViewAtIndex(ViewGroup view, int i) throws NumberFormatException {
        EditText editText = (EditText) view.getChildAt(i);
        int term;

        term = Integer.parseInt(editText.getText().toString());

        return term;
    }

}
