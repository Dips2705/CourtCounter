package com.example.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.courtcounter.R;

public class MainActivity extends AppCompatActivity {

    int scoreA=0,scoreB=0,ftA=0,ftB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreA+=1;
        displayForTeamA(scoreA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreA+=2;
        displayForTeamA(scoreA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreA+=3;
        ftA+=1;
        displayForTeamA(scoreA);
    }
    /**
     * Increase the score for Team B by 1 points.
     */
    public void addOneForTeamB(View v) {
        scoreB+=1;
        displayForTeamB(scoreB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreB+=2;
        displayForTeamB(scoreB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreB+=3;
        ftB+=1;
        displayForTeamB(scoreB);
    }
    //Resets score to zero
    public void resetScore(View v) {
        scoreA=0;
        scoreB=0;
        ftA=0;
        ftB=0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
        dispthreeptr("");
        displayMessage("");
    }
    /**Shows the result at the end of the match*/
    public void showresult(View v) {
        if(scoreA>scoreB)
            displayMessage("TEAM A WINS");
        else if(scoreB>scoreA)
            displayMessage("TEAM B WINS");
        else
            displayMessage("IT'S A DRAW");
        dispthreeptr("Team A 3-ptr: "+ftA+"\nTeam B 3-ptr: "+ftB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    //Used for displaying message
    private void displayMessage(String message) {
        TextView resultView = (TextView) findViewById(R.id.result);
        resultView.setText(message);
    }
    private void dispthreeptr(String message) {
        TextView freeView = (TextView) findViewById(R.id.metric);
        freeView.setText(message);
    }
}