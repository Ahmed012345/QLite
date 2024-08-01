package com.finallite.app.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.finallite.R;

@SuppressLint("AppCompatCustomView")
public class LightButton extends Button {
    public LightButton(Context context) {
        super(context);
    }

    public LightButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LightButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        if(context.getString(R.string.lang).equals("ar")) {
            setTypeface(FontManger.yad);
        }if (context.getString(R.string.lang).equals("zh")) {
            setTypeface(FontManger.asian);
        }if (context.getString(R.string.lang).equals("cs")){
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("nl")){
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("en")){
            setTypeface(FontManger.english);
        } if(context.getString(R.string.lang).equals("fr")) {
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("de")) {
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("in")){
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("it")){
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("ja")){
            setTypeface(FontManger.asian);
        }if (context.getString(R.string.lang).equals("ko")){
            setTypeface(FontManger.asian);
        }if (context.getString(R.string.lang).equals("fa")){
            setTypeface(FontManger.yad);
        }if (context.getString(R.string.lang).equals("pl")){
            setTypeface(FontManger.english);
        } if(context.getString(R.string.lang).equals("pt")) {
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("ro")) {
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("ru")){
            setTypeface(FontManger.russi);
        }if (context.getString(R.string.lang).equals("es")){
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("th")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("ms")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("hi")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("bn")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("ur")){
            setTypeface(FontManger.yad);
        }if(context.getString(R.string.lang).equals("sv")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("sq")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("az")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("bs")){
            setTypeface(FontManger.english);
        }if (context.getString(R.string.lang).equals("bg")){
            setTypeface(FontManger.russi);
        }if(context.getString(R.string.lang).equals("ha")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("no")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("so")){
            setTypeface(FontManger.english);
        }if(context.getString(R.string.lang).equals("sw")){
            setTypeface(FontManger.english);
        }else if (context.getString(R.string.lang).equals("tr"))
            setTypeface(FontManger.english);
    }
}


