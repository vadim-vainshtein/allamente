package com.example.allamente;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.View;

import com.example.allamente.repository.MusicSampleRepository;

import java.io.IOException;

public class MidiPlayer implements View.OnClickListener {

    MediaPlayer mediaPlayer;

    public MidiPlayer(int lessonNumber, Context context) {

        mediaPlayer = new MediaPlayer();

        String filename = MusicSampleRepository.getMidiFileName(lessonNumber);

        try {
            AssetFileDescriptor midiFileDescriptor = context.getAssets().openFd(filename);
            mediaPlayer.setDataSource(
                    midiFileDescriptor.getFileDescriptor(),
                    midiFileDescriptor.getStartOffset(),
                    midiFileDescriptor.getLength());

            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if(id == R.id.play) {
            mediaPlayer.start();
        }
        else if(id == R.id.pause) {
            mediaPlayer.pause();
        }
    }
}
