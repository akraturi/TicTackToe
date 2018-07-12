package com.example.amit.connect3game;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //yellow=0,red=1
    //Variable that keeps track of current player
    private int activePlayer=0;
    private int gameState[]={2,2,2,2,2,2,2,2,2};
    private int winingPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    private boolean gameActive=true;
    private int flag;
    Button mPlayAgainButton;
    TextView mGreetingsTextView;
    private   String winner = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mPlayAgainButton=findViewById(R.id.playagainbutton);

         mGreetingsTextView=findViewById(R.id.greetingstextview);
    }
    public void fadeIn(View view)
    {   flag=0;
        ImageView counter=(ImageView)view;

        Log.i("TAG",counter.getTag().toString()+"clicked");

        int counterTapped=Integer.parseInt(counter.getTag().toString());

        //Allow to drop in the counter only if the position is blank

        if(gameState[counterTapped]==2&&gameActive)
        {
            gameState[counterTapped] = activePlayer;

            counter.setTranslationY(-1500);
            //Counter is set alternatively depending upon the current player

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).setDuration(300);
            // checking if any of the player have been won after a certain click
            for (int winingPostion[] : winingPositions) {
                if (gameState[winingPostion[0]] == gameState[winingPostion[1]] && gameState[winingPostion[1]] == gameState[winingPostion[2]] && gameState[winingPostion[0]] != 2) {
                    gameActive = false;

                    if (activePlayer == 1) {
                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }
                    //Toast.makeText(this, winner + " has won!", Toast.LENGTH_SHORT).show();
                    mPlayAgainButton.setVisibility(View.VISIBLE);
                    mGreetingsTextView.setVisibility(View.VISIBLE);
                    mGreetingsTextView.setText(winner.toUpperCase() + " has won");
                }

            }

        }
    }

    public void playAgain(View view)
    {
        // Re construct the activity lifecycle
        recreate();
    }


}
