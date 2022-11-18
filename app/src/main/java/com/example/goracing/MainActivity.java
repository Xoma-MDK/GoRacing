package com.example.goracing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isPlaying = false;
    ImageView p1;
    ImageView p2;
    TextView winTV;
    Button startBtn;
    Button GoPlayer1;
    Button GoPlayer2;
    ImageView FinLine;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e)
        {}
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        p1 = (ImageView) findViewById(R.id.Player1);
        p2 = (ImageView) findViewById(R.id.Player2);
        startBtn = (Button) findViewById(R.id.Start);
        GoPlayer1 = (Button) findViewById(R.id.GO1);
        GoPlayer2 = (Button) findViewById(R.id.GO2);
        winTV = (TextView) findViewById(R.id.winTV);
        FinLine = (ImageView) findViewById(R.id.FinishLine);
        winTV.setText("");
    }



    private void WinScreen(int player){
        startBtn.setEnabled(true);
        startBtn.setVisibility(View.VISIBLE);
        GoPlayer1.setEnabled(false);
        GoPlayer2.setEnabled(false);
        GoPlayer1.setVisibility(View.INVISIBLE);
        GoPlayer2.setVisibility(View.INVISIBLE);
        if(player == 1){
            winTV.setText("PLAYER 1 WIN!!");
        }else{
            winTV.setText("PLAYER 2 WIN!!");
        }
    }

    public void StartButton(View view){
        winTV.setText("");
        startBtn.setEnabled(false);
        startBtn.setVisibility(View.INVISIBLE);
        GoPlayer1.setEnabled(true);
        GoPlayer2.setEnabled(true);
        GoPlayer1.setVisibility(View.VISIBLE);
        GoPlayer2.setVisibility(View.VISIBLE);
    }

    public void onClickPlayer1(View view){
        int left = p1.getLeft();
        int top = p1.getTop();
        int down = p1.getBottom();
        int right = p1.getRight();
        //Log.d("p1Left", String.format("%1$d", p1.getLeft()));
        p1.layout(left + 20, top + 0, right + 20, down + 0);
        if(right >= FinLine.getLeft()){
            WinScreen(1);
        }
    }

    public void onClickPlayer2(View view){
        int left = p2.getLeft();
        int top = p2.getTop();
        int down = p2.getBottom();
        int right = p2.getRight();
        p2.layout(left + 20, top + 0, right + 20, down + 0);

        if(right >= FinLine.getLeft()){
            WinScreen(2);
        }
    }
}