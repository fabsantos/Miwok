package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    /**
     * * This listener gets triggered when the {@link MediaPlayer} has completed playing
     *
     * */
     private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
     };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //Creates the ArrayList of Miwok Numbers
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("lutti", "one", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("otiiko", "two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("tolookosu", "three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("oyyisa", "four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("massokka", "five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("temmokka", "six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("wo’e", "nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("na’aacha", "ten", R.drawable.number_ten, R.raw.number_ten));


        //Create an Adapter, whose data source is a list of words, the adapter knows how to create
        //each list item
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        //Find the list view in the Activity
        ListView listView = (ListView) findViewById(R.id.list);
        //Set the adapter on that view. This adapter will create list items for each word.
        listView.setAdapter(adapter);
       //Set a click listener on the list items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Release the media player if it exists, because we are going to play a new file
                releaseMediaPlayer();
                //Get a clicked item position and the corresponding sound resource
                int soundResourceID = words.get(position).getSoundResourceID();
                //Create and start a player for the sound resource
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, soundResourceID);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        //If the user leaves the activity, the media player is released
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}





