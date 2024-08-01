package com.finallite.app.main.custom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.finallite.ARApplication;
import com.finallite.ColorMap;
import com.finallite.app.main.materialaboutlibrary.MaterialAboutActivity;
import com.finallite.app.main.materialaboutlibrary.model.MaterialAboutList;
import com.finallite.R;

public class ExampleMaterialAboutActivity extends MaterialAboutActivity {

    public static final String THEME_EXTRA = "";
    public static final int THEME_LIGHT = 0;
    private ColorMap colorMap;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ExampleMaterialAboutActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return intent;
    }

    @NonNull
    @Override
    protected MaterialAboutList getMaterialAboutList(@NonNull final Context c) {
        return Demo.createMaterialAboutList(c, getIntent().getIntExtra(THEME_EXTRA, THEME_LIGHT));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        colorMap = ARApplication.getInjector().provideColorMap(getApplicationContext());
        setTheme(colorMap.getAppThemeResource());
      //  setTheme(R.style.AppTheme_MaterialAboutActivity_Light_DarkActionBar_CustomCardView);
        super.onCreate(savedInstanceState);
//        Call this method to let the scrollbar scroll off screen
//        setScrollToolbar(true);

    }


    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.mal_title_about);
    }

}
