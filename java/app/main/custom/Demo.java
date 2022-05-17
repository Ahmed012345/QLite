package com.finallite.app.main.custom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.finallite.app.main.materialaboutlibrary.ConvenienceBuilder;
import com.finallite.app.main.materialaboutlibrary.items.MaterialAboutActionItem;
import com.finallite.app.main.materialaboutlibrary.items.MaterialAboutItemOnClickAction;
import com.finallite.app.main.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.finallite.app.main.materialaboutlibrary.model.MaterialAboutCard;
import com.finallite.app.main.materialaboutlibrary.model.MaterialAboutList;
import com.finallite.app.main.materialaboutlibrary.util.OpenSourceLicense;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.finallite.R;

public class Demo {

    public static MaterialAboutList createMaterialAboutList(final Context c, final int theme) {
        MaterialAboutCard.Builder appCardBuilder = new MaterialAboutCard.Builder();

        // Add items to card
        appCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                .text(c.getString(R.string.app_name))
                .desc(c.getString(R.string.auther1))
                .icon(R.mipmap.ic_launcher)
                .build());

        appCardBuilder.addItem(ConvenienceBuilder.createVersionActionItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_information_outline)
                        .sizeDp(18),
                c.getString(R.string.version),
                false));

        appCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(c.getString(R.string.Licenses))
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18))
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent intent = new Intent(c, ExampleMaterialAboutLicenseActivity.class);
                        intent.putExtra(ExampleMaterialAboutActivity.THEME_EXTRA, theme);
                        c.startActivity(intent);
                    }
                })
                .build());

        MaterialAboutCard.Builder authorCardBuilder = new MaterialAboutCard.Builder();
        authorCardBuilder.title(c.getString(R.string.Author));
//        authorCardBuilder.titleColor(ContextCompat.getColor(c, R.color.colorAccent));

        authorCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(c.getString(R.string.name))
                .subText(c.getString(R.string.egypt))
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account)
                        .sizeDp(18))
                .build());

        authorCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text(c.getString(R.string.github))
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_github_circle)
                        .sizeDp(18))
                .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(c, Uri.parse("https://github.com/Ahmed012345")))
                .build());

        MaterialAboutCard.Builder convenienceCardBuilder = new MaterialAboutCard.Builder();
        convenienceCardBuilder.title(c.getString(R.string.Convenience));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createRateActionItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_star)
                        .sizeDp(18),
                c.getString(R.string.Rate_app),
                null
        ));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createEmailItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_email)
                        .sizeDp(18),
                c.getString(R.string.Send),
                true,
                "asmmya7@gmail.com",
                "Question concerning Quran lite"));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createPhoneItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_phone)
                        .sizeDp(18),
                c.getString(R.string.Call),
                true,
                "+20 100 226 4423"));

        convenienceCardBuilder.addItem(ConvenienceBuilder.createMapItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_map)
                        .sizeDp(18),
                c.getString(R.string.Visit),
                null,
                "Giza Necropolis"));

        return new MaterialAboutList(appCardBuilder.build(), authorCardBuilder.build(), convenienceCardBuilder.build());
    }

    public static MaterialAboutList createMaterialAboutLicenseList(final Context c) {

        MaterialAboutCard materialAboutLibraryLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "material-about-library", "2016", "Daniel Stone",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard androidIconicsLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "Android Iconics", "2016", "Mike Penz",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard leakCanaryLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "Audio Recorder", "2019", "Dmytro Ponomarenko",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard mitLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "AudioRecorderView", "2018", "Touge",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard gplLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "click-shrink-effect", "2019", "Prashant Barahi",
                OpenSourceLicense.MIT);

        MaterialAboutCard rblLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                        "RubberPicker", "2019", "Jem",
                OpenSourceLicense.MIT);

        MaterialAboutCard mdclLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "MaterialDesignColors", "2017", "Tsubasa Nakayama",
                OpenSourceLicense.MIT);

        MaterialAboutCard tLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "timber", "2013", "Jake Wharton",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard cmLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "CycleMenu", "2016", "Cleveroad Inc",
                OpenSourceLicense.MIT);

        MaterialAboutCard llLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "Localization", "2021", "Akexorcist",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard dsLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "MaterialToast", "2018", "Marcos Calvo García",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard noaLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "NineOldAndroids", "2012", "Jake Wharton",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard bmLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "BoomMenu", "2017", "Nightonke",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard laLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "lottie-android", "2017", "airbnb",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard wLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "WifiUtils", "2021", "Thanos Psaridis",
                OpenSourceLicense.APACHE_2);

        MaterialAboutCard abuLicenseCard = ConvenienceBuilder.createLicenseCard(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_book)
                        .sizeDp(18),
                "AndroidBaseUtils", "2016", "The Finest Artist",
                OpenSourceLicense.APACHE_2);

        return new MaterialAboutList(materialAboutLibraryLicenseCard, androidIconicsLicenseCard, leakCanaryLicenseCard, mitLicenseCard,
                gplLicenseCard, rblLicenseCard, mdclLicenseCard, tLicenseCard, cmLicenseCard, llLicenseCard, dsLicenseCard, noaLicenseCard,
                bmLicenseCard, laLicenseCard, abuLicenseCard);
    }
}