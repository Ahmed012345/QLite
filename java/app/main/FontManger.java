package com.finallite.app.main;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;


import java.util.HashMap;
import java.util.Map;

public class FontManger {

    private static final String TAG = FontManger.class.getName();
    private static FontManger instance;
    private AssetManager assetManager;
    private Map<String, Typeface> fonts;
    public static Typeface english;
    public static Typeface yad;
    public static Typeface asian;
    public static Typeface russi;

    private FontManger(AssetManager assetManager){
        this.assetManager = assetManager;
        this.fonts = new HashMap<>();
        english = Typeface.createFromAsset(assetManager, "fonts/eng.ttf");
        yad = Typeface.createFromAsset(assetManager, "fonts/yad.ttf");
        asian = Typeface.createFromAsset(assetManager, "fonts/korea.ttf");
        russi = Typeface.createFromAsset(assetManager, "fonts/russi.ttf");
    }



    public static FontManger getInstance(AssetManager assetManager){
        if (instance == null){
            instance = new FontManger(assetManager);
        }
        return instance;
    }



    public Typeface getFont(String asset){
        if (fonts.containsKey(asset))
            return fonts.get(asset);
        Typeface font = null;

        try{
            font = Typeface.createFromAsset(assetManager, asset);
            fonts.put(asset, font);
        }catch (RuntimeException e){
            Log.e(TAG, "getFont: Can't create font from asset.",e);
        }
        return font;
    }


}


