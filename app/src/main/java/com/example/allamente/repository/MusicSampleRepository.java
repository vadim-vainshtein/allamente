package com.example.allamente.repository;

/**
 * Class used to get music files (or, at list, filenames)
 */
public class MusicSampleRepository {

    private static final String MIDI_DIR = "midi";

    private MusicSampleRepository() { }

    public static String getMidiFileName(int lessonNumber) {
        return MIDI_DIR + "/lesson" + lessonNumber + ".midi";
    }
}
