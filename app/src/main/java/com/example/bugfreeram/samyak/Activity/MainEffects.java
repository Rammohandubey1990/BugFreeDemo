package com.example.bugfreeram.samyak.Activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.bugfreeram.samyak.R;


public class MainEffects extends AppCompatActivity  {
    ImageView img_effective;
    Bitmap icon;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_effects);
        img_effective = (ImageView) findViewById(R.id.img_effective);

        icon  = BitmapFactory.decodeResource(MainEffects.this.getResources(),
                R.drawable.img);

        img_effective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_effective.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                img_effective.setImageBitmap(setPopArtGradientFromBitmap(context, icon));

            }
        });
    }

    public static Bitmap setPopArtGradientFromBitmap(Context context, Bitmap bmp) {
        int[] co = new int[]{Color.parseColor("#FFD900"),Color.parseColor("#FF5300"),Color.parseColor("#FF0D00"),Color.parseColor("#AD009F"),Color.parseColor("#1924B1")};
        float[] coP = new float[]{0.2f,0.4f,0.6f,0.8f,1.0f};

        Bitmap bitmap = bmp.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmap);

        LinearGradient grad = new LinearGradient(0, 0, 0, canvas.getHeight(), co, coP, Shader.TileMode.CLAMP);

        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setAlpha(110);
        p.setShader(grad);
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), p);

        return bitmap;
    }

    public Bitmap changeHue( Bitmap source, double hue ) {
        Bitmap result = Bitmap.createBitmap( source.getWidth(), source.getHeight(), source.getConfig() );

        float[] hsv = new float[3];
        for( int x = 0; x < source.getWidth(); x++ ) {
            for( int y = 0; y < source.getHeight(); y++ ) {
                int c = source.getPixel( x, y );
                Color.colorToHSV( c, hsv );
                hsv[0] = (float) ((hsv[0] + 360 * hue) % 360);
                c = (Color.HSVToColor( hsv ) & 0x00ffffff) | (c & 0xff000000);
                result.setPixel( x, y, c );
            }
        }

        return result;
    }
    public static Bitmap applyShadingFilter(Bitmap source, int shadingColor) {

        int width = source.getWidth();
        int height = source.getHeight();
        int[] pixels = new int[width * height];
        source.getPixels(pixels, 0, width, 0, 0, width, height);

        int index = 0;

        for(int y = 0; y < height; ++y) {
            for(int x = 0; x < width; ++x) {

                index = y * width + x;

                pixels[index] &= shadingColor;
            }
        }
        Bitmap bmOut = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bmOut.setPixels(pixels, 0, width, 0, 0, width, height);
        return bmOut;
    }

    public void makeCustomColor (int colorFirst, int colorSec, int colorThird){



    }

    public  Bitmap applySaturationFilter(Bitmap source, int level) {

        int width = source.getWidth();
        int height = source.getHeight();
        int[] pixels = new int[width * height];
        float[] HSV = new float[3];
        source.getPixels(pixels, 0, width, 0, 0, width, height);

        int index = 0;
        // iteration through pixels
        for(int y = 0; y < height; ++y) {
            for(int x = 0; x < width; ++x) {
                // get current index in 2D-matrix
                index = y * width + x;
                // convert to HSV
                Color.colorToHSV(pixels[index], HSV);
                // increase Saturation level
                HSV[1] *= level;
                HSV[1] = (float) Math.max(0.0, Math.min(HSV[1], 1.0));
                // take color back
                pixels[index] |= Color.HSVToColor(HSV);
            }
        }
        // output bitmap
        Bitmap bmOut = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bmOut.setPixels(pixels, 0, width, 0, 0, width, height);
        return bmOut;
    }

    public static Bitmap applyHueFilter(Bitmap source, int level) {
        // get image size
        int width = source.getWidth();
        int height = source.getHeight();
        int[] pixels = new int[width * height];
        float[] HSV = new float[3];
        // get pixel array from source
        source.getPixels(pixels, 0, width, 0, 0, width, height);

        int index = 0;
        // iteration through pixels
        for(int y = 0; y < height; ++y) {
            for(int x = 0; x < width; ++x) {
                // get current index in 2D-matrix
                index = y * width + x;
                // convert to HSV
                Color.colorToHSV(pixels[index], HSV);
                // increase Saturation level
                HSV[0] *= level;
                HSV[0] = (float) Math.max(0.0, Math.min(HSV[0], 360.0));
                // take color back
                pixels[index] |= Color.HSVToColor(HSV);
            }
        }
        // output bitmap
        Bitmap bmOut = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bmOut.setPixels(pixels, 0, width, 0, 0, width, height);
        return bmOut;
    }

    public void changeHue (Bitmap bitmap, int hue, int width, int height) {
        if (bitmap == null) { return; }
        if ((hue < 0) || (hue > 360)) { return; }

        int size = width * height;
        int[] all_pixels = new int [size];
        int top = 0;
        int left = 0;
        int offset = 0;
        int stride = width;

        bitmap.getPixels (all_pixels, offset, stride, top, left, width, height);

        int pixel = 0;
        int alpha = 0;
        float[] hsv = new float[3];

        for (int i=0; i < size; i++) {
            pixel = all_pixels [i];
            alpha = Color.alpha (pixel);
            Color.colorToHSV (pixel, hsv);

            hsv [0] = hue;
            hsv [1] = 1.0f;

            all_pixels [i] = Color.HSVToColor (alpha, hsv);
        }

        bitmap.setPixels (all_pixels, offset, stride, top, left, width, height);
    }
}
