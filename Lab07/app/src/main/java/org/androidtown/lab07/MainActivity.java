package org.androidtown.lab07;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.R.attr.tag;

public class MainActivity extends AppCompatActivity {

    RelativeLayout audio1, audio2;
    int nowPlay = 0;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio1 = (RelativeLayout)findViewById(R.id.audio1);
        audio2 = (RelativeLayout)findViewById(R.id.audio2);

        audio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nowPlay != 1) {
                    nowPlay = 1;
                    killMediaPlayer();

                    audio1.setBackgroundColor(Color.LTGRAY);
                    audio2.setBackgroundColor(Color.WHITE);

                    try {
                        playAudio();
                        Toast.makeText(getApplicationContext(), "음악 파일1 재생 시작됨.", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        audio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nowPlay!=2) {
                    nowPlay = 2;
                    killMediaPlayer();

                    audio1.setBackgroundColor(Color.WHITE);
                    audio2.setBackgroundColor(Color.LTGRAY);

                    try{
                        playAudio();
                        Toast.makeText(getApplicationContext(), "음악 파일2 재생 시작됨.", Toast.LENGTH_LONG).show();
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });
    }
    private void playAudio() throws Exception {
        killMediaPlayer();

        mediaPlayer = new MediaPlayer();
        if(nowPlay==1)
            mediaPlayer= MediaPlayer.create(getApplicationContext(), R.raw.music1);
        else if(nowPlay==2)
            mediaPlayer= MediaPlayer.create(getApplicationContext(), R.raw.music2);

        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        killMediaPlayer();
    }

    protected void killMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
