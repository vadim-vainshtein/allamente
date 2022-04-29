package com.example.allamente;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.allamente.repository.MusicImageRepository;

import java.io.IOException;

public class Lesson extends AppCompatActivity {

    ImageView musicImageView;
    ImageButton playButton;
    ImageButton pauseButton;

    MidiPlayer midiPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        // TODO: передать номер урока из меню. Пока - 1
        SetMusicImage(1);
        midiPlayer = new MidiPlayer(1, getApplicationContext());
        playButton = findViewById(R.id.play);
        pauseButton = findViewById(R.id.pause);

        playButton.setOnClickListener(midiPlayer);
        pauseButton.setOnClickListener(midiPlayer);
    }

    private void SetMusicImage(int lessonNumber) {

        musicImageView = findViewById(R.id.music_image);

        // Get image from file by lesson number
        Drawable musicImage = null;
        try {
            musicImage = MusicImageRepository.getImage(lessonNumber, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }

        musicImageView.setImageDrawable(musicImage);
    }
}