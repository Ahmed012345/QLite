package com.finallite.app.main.custom;

import android.content.Context;
import androidx.annotation.NonNull;
import com.finallite.R;
import com.finallite.app.main.LightTextView;
import com.finallite.app.main.materialaboutlibrary.model.MaterialAboutList;

public class ExampleMaterialAboutLicenseActivity extends ExampleMaterialAboutActivity {
    LightTextView title123;
    @NonNull @Override
    protected MaterialAboutList getMaterialAboutList(@NonNull final Context c) {
        return Demo.createMaterialAboutLicenseList(c);
    }

    @Override
    protected CharSequence getActivityTitle() {
        title123 = findViewById(R.id.title123);
        title123.setText(getResources().getString(R.string.mal_title_licenses));
        return getString(R.string.mal_title_licenses);
    }



}
