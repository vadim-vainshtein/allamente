package com.example.allamente.repository;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class used to load music images by lesson number
 * TODO: separate data source(s) from Repository
 */
public class MusicImageRepository {

    private static final String IMAGE_DIR = "music_images";

    private MusicImageRepository() { }

    /**
     * Get Drawable by lesson number
     *
     * @param lessonNumber
     * @param context
     * @return
     * @throws IOException
     */
    public static Drawable getImage(int lessonNumber, Context context) throws IOException {
        return getImageFromDrawable(lessonNumber, context);
    }

    private static Drawable getImageFromDrawable(int lessonNumber, Context context) throws IOException {
        String fileName = getImageFileName(lessonNumber);
        InputStream inputStream = context.getAssets().open(fileName);
        return Drawable.createFromStream(inputStream, null);
    }

    private static String getImageFileName(int lessonNumber) {
        return IMAGE_DIR + "/lesson" + lessonNumber + ".png";
    }
}
