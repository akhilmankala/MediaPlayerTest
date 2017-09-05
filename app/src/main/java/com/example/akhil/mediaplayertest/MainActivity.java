package com.example.akhil.mediaplayertest;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar s1;
    TextView tv1, tv2;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = (SeekBar)findViewById(R.id.s1);
        tv1 = (TextView)findViewById(R.id.cur_pos);
        tv2 = (TextView)findViewById(R.id.total_dur);
    }

    void init(){
        if(mPlayer == null) {
            mPlayer = MediaPlayer.create(MainActivity.this, R.raw.staywithme);
            tv2.setText("Total dur: " + mPlayer.getDuration());
            s1.setMax(mPlayer.getDuration());
        }
    }

    public void media(View v){
        switch (v.getId()){

            case R.id.backward:
                mPlayer.seekTo(mPlayer.getCurrentPosition()-mPlayer.getDuration()/10);
                tv1.setText("Cur pos: "+mPlayer.getCurrentPosition());
                break;
            case R.id.play:
                init();
                mPlayer.start();
                break;
            case R.id.pause:
                mPlayer.pause();
                break;
            case R.id.stop:
                mPlayer.stop();
                break;
            case R.id.forward:
                mPlayer.seekTo(mPlayer.getCurrentPosition()+mPlayer.getDuration()/10);
                tv1.setText("Cur pos: "+mPlayer.getCurrentPosition());
                break;
            case R.id.list:
                break;
        }
    }
}
