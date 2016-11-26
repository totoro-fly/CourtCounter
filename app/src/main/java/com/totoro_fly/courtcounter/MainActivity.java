package com.totoro_fly.courtcounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    int teamAScore = 0;
    int teamBScore = 0;
    //记录每次按键，用于回退。
    ArrayList arrayList = new ArrayList();
    EditText editTextA;
    EditText editTextB;
    //清空焦点后，作为第一元素夺取焦点。
//    LinearLayout focusLinearLayout;
    //使用确认button夺取焦点
    Button enterNameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        enterNameButton = (Button) findViewById(R.id.enter_name_button);
        editTextA = (EditText) findViewById(R.id.team_a_name_edit_view);
        editTextB = (EditText) findViewById(R.id.team_b_name_edit_view);
        editTextA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b = true) {
                    if (editTextA.isFocusable() || editTextB.isFocusable())
                        enterNameButton.setVisibility(View.VISIBLE);
                }
            }
        });
        editTextB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b = true) {
                    if (editTextA.isFocusable() || editTextB.isFocusable())
                        enterNameButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void enterNameButton(View view) {
        editTextA.clearFocus();
        editTextB.clearFocus();
        enterNameButton.setFocusable(true);
        enterNameButton.setVisibility(View.GONE);
    }


    public void addThreeForTeamABottom(View view) {
        addPointForTeamA(3);
    }

    public void addTwoForTeamABottom(View view) {
        addPointForTeamA(2);
    }

    public void addOneForTeamABottom(View view) {
        addPointForTeamA(1);
    }

    private void addPointForTeamA(int point) {
        arrayList.add("A" + point);
        teamAScore = teamAScore + point;
        dipalyForTeamA();
    }

    public void addThreeForTeamBBottom(View view) {
        addPointForTeamB(3);
    }

    public void addTwoForTeamBBottom(View view) {
        addPointForTeamB(2);
    }

    public void addOneForTeamBBottom(View view) {
        addPointForTeamB(1);
    }

    private void addPointForTeamB(int point) {
        arrayList.add("B" + point);
        teamBScore = teamBScore + point;
        dipalyForTeamB();
    }

    private void dipalyForTeamA() {
        TextView textView = (TextView) findViewById(R.id.team_a_score_text_view);
        textView.setText(String.valueOf(teamAScore));
    }

    private void dipalyForTeamB() {
        TextView textView = (TextView) findViewById(R.id.team_b_score_text_view);
        textView.setText(String.valueOf(teamBScore));
    }

    /*回退按键*/
    public void revocationBottom(View view) {
        int size = arrayList.size();
        /*防止闪退赋值*/
        String str = "";
        /*防止空引用闪退*/
        if (size > 0) {
            str = (String) arrayList.get(size - 1);
            arrayList.remove(size - 1);
        }
        switch (str) {
            case "A1":
                teamAScore--;
                dipalyForTeamA();
                break;
            case "A2":
                teamAScore = teamAScore - 2;
                dipalyForTeamA();
                break;
            case "A3":
                teamAScore = teamAScore - 3;
                dipalyForTeamA();
                break;
            case "B1":
                teamBScore--;
                dipalyForTeamB();
                break;
            case "B2":
                teamBScore = teamBScore - 2;
                dipalyForTeamB();
                break;
            case "B3":
                teamBScore = teamBScore - 3;
                dipalyForTeamB();
                break;
            default:
                break;
        }

    }

    public void resetBottom(View view) {
        arrayList.clear();
        teamAScore = 0;
        teamBScore = 0;
        dipalyForTeamA();
        dipalyForTeamB();
    }

    public void eixtButton(View view) {
        System.exit(0);
    }
}
