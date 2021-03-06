package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    public static final String TAG = "NumberActivity";
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("red","weṭeṭṭi",R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green","chokokki",R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown","ṭakaakki",R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray","ṭopoppi",R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black","kululli",R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white","kelelli",R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.category_colors));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cleanupMediaPlayer();
                mediaPlayer = MediaPlayer.create(ColorActivity.this, words.get(position).getSongPath());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {

                        cleanupMediaPlayer();
                    }
                });
            }
        });
        listView.setAdapter(itemsAdapter);

    }
    @Override
    protected void onStop() {
        super.onStop();
        cleanupMediaPlayer();
    }

    boolean isPaused = false;
    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer!=null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPaused = true;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mediaPlayer!=null & isPaused)
        {
            mediaPlayer.start();
        }
        isPaused = false;

    }


    private void  cleanupMediaPlayer()
    {
        if(mediaPlayer!=null){
            if(mediaPlayer.isPlaying()) mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = null;
    }
}
