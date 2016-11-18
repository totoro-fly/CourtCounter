package com.totoro_fly.courtcounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends Activity {
    int teamAScore = 0;
    int teamBScore = 0;
    ArrayList arrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void teamAAdd3PointsBottom(View view) {
        arrayList.add("A3");
        teamAScore = teamAScore + 3;
        displayTeamA();
    }

    public void teamAAdd2PointsBottom(View view) {
        arrayList.add("A2");
        teamAScore = teamAScore + 2;
        displayTeamA();
    }

    public void teamARreeThrowBottom(View view) {
        arrayList.add("A1");
        teamAScore++;
        displayTeamA();
    }


    public void teamBAdd3PointsBottom(View view) {
        arrayList.add("B3");
        teamBScore = teamBScore + 3;
        displayTeamB();
    }

    public void teamBAdd2PointsBottom(View view) {
        arrayList.add("B2");
        teamBScore = teamBScore + 2;
        displayTeamB();
    }

    public void teamBFreeThrowBottom(View view) {
        arrayList.add("B1");
        teamBScore++;
        displayTeamB();
    }

    private void displayTeamA() {
        TextView textView = (TextView) findViewById(R.id.team_a_score_text_view);
        textView.setText(teamAScore + "");
    }

    private void displayTeamB() {
        TextView textView = (TextView) findViewById(R.id.team_b_score_text_view);
        textView.setText(teamBScore + "");
    }

    public void revocationBottom(View view) {
        int size = arrayList.size();
        String str = (String) arrayList.get(size - 1);
        arrayList.remove(size - 1);
        switch (str) {
            case "A1":
                teamAScore--;
                displayTeamA();
                break;
            case "A2":
                teamAScore = teamAScore - 2;
                displayTeamA();
                break;
            case "A3":
                teamAScore = teamAScore - 3;
                displayTeamA();
                break;
            case "B1":
                teamBScore--;
                displayTeamB();
                break;
            case "B2":
                teamBScore = teamBScore - 2;
                displayTeamB();
                break;
            case "B3":
                teamBScore = teamBScore - 3;
                displayTeamB();
                break;
        }

    }

    public void resetBottom(View view) {
        arrayList.clear();
        teamAScore = 0;
        teamBScore = 0;
        displayTeamA();
        displayTeamB();
    }
}
