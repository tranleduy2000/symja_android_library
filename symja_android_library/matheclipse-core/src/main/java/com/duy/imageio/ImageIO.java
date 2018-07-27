package com.duy.imageio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageIO {
    public static Bitmap read(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    public static void write(Bitmap bitmap, String ext, File file) throws FileNotFoundException {
        FileOutputStream output = new FileOutputStream(file);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.valueOf(ext);
        bitmap.compress(compressFormat, 100, output);
    }

    public static Bitmap read(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        Bitmap bitmap = read(inputStream);
        inputStream.close();
        return bitmap;
    }
}
