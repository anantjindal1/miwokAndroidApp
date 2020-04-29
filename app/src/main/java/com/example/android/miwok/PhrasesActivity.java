package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    public static final String TAG = "PhrasesActivity";
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?","minto wuksus",0, R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","tinnә oyaase'nә",0, R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","oyaaset...",0, R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","michәksәs?",0, R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.","kuchi achit",0, R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","әәnәs'aa?",0, R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.","hәә’ әәnәm",0, R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.","әәnәm",0, R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.","yoowutis",0, R.raw.phrase_lets_go));
        words.add(new Word("Come here.","әnni'nem",0, R.raw.phrase_come_here));


        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.category_phrases));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cleanupMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.get(position).getSongPath());
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
