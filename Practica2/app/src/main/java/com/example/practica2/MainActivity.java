package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileDescriptor;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* btn1 = findViewById(R.id.note1);
        btn2 = findViewById(R.id.note2);
        btn3 = findViewById(R.id.note3);
        btn4 = findViewById(R.id.note4);
        btn5 = findViewById(R.id.note5);
        btn6 = findViewById(R.id.note6);
        btn7 = findViewById(R.id.note7);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(7);
            }
        });*/
    }

    public void playSound(String boton) {
        try{
            Resources res = getApplicationContext().getResources();
            int soundId = res.getIdentifier(boton,"raw", getApplicationContext().getPackageName());
            AssetFileDescriptor assetFileDescriptor = getResources().openRawResourceFd(soundId);
            FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();
            MediaPlayer player = new MediaPlayer();
            player.setDataSource(fileDescriptor, assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());
            player.setLooping(false);
            player.prepare();
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    // TODO Auto-generated method stub
                    mediaPlayer.release();
                }
            });
        } catch (IOException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();

        }
    }

    @Override
    public void onClick(View v) {
        playSound(v.getTag().toString());
    }
}
