package edu.grinnell.pradhanp.gameoflife;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;


public class GameActivity extends Activity {

    protected GridView mGridView;
    protected GameBoard mGameBoard;
    protected Button mPlayButton;
    protected Button mResetButton;
    protected Button mStepForward;
    final int width = 100;
    final int height = 100;
    final int randomPercent = 20;
    int cellHeight;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        // set initial game board
        mGameBoard = new GameBoard(width, height);

        // set random board
        mGameBoard.randomizeBoard(randomPercent);

        mGridView = (GridView) findViewById(R.id.game_board);
        mGridView.setNumColumns(width);

        cellHeight = mGridView.getMeasuredHeight()/height;
        final BoardAdapter adapter = new BoardAdapter(this,mGameBoard.to1DArray(width),cellHeight);
        mGridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mGridView.invalidateViews();
        Log.d("GV-WIDTH", "" + mGridView.getMeasuredHeight());



        // set buttons
        mPlayButton = (Button)findViewById(R.id.play);
        mStepForward = (Button)findViewById(R.id.stepForward);
        mResetButton = (Button)findViewById(R.id.reset);

        mStepForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGameBoard.iterate();
                adapter.notifyDataSetChanged();
                mGridView.invalidateViews();
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();


        cellHeight = mGridView.getMeasuredHeight()/height;
        final BoardAdapter adapter = new BoardAdapter(this,mGameBoard.to1DArray(width),cellHeight);
                mGridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mGridView.invalidateViews();

        
    }
}
