package com.example.bugfreeram.samyak.Custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

public class IconTextView extends TextView {


    public IconTextView(Context context) {
        super(context);
        customTypeFace(context);
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        customTypeFace(context);
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        customTypeFace(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        customTypeFace(context);
    }

    public void customTypeFace(Context context) {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf");
        this.setTypeface(face);
    }
}

