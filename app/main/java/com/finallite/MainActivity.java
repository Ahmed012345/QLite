package com.finallite;

import static com.finallite.app.main.finestwebview.FinestWebViewActivity.KEY_COLOR;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.RenderMode;
import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.cleveroad.sy.cyclemenuwidget.CycleMenuWidget;
import com.cleveroad.sy.cyclemenuwidget.OnMenuItemClickListener;
import com.cleveroad.sy.cyclemenuwidget.OnStateChangedListener;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.crashlytics.FirebaseCrashlytics;
//import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
//import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.marcoscg.materialtoast.MaterialToast;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.OnBoomListenerAdapter;
import com.nightonke.boommenu.Util;
//import com.finallite.app.main.AppUpdateDialog;
import com.finallite.app.main.LightTextView;
import com.finallite.app.main.LocaleHelper;
import com.finallite.app.main.MainRecActivity;
import com.finallite.app.main.Shareable;
import com.finallite.app.main.easysharedpreferences.EasySharedPreference;
import com.finallite.app.main.finestwebview.FinestWebView;
import com.finallite.app.settings.SettingsContract;
import com.finallite.app.settings.SettingsMapper;
import com.realpacific.clickshrinkeffect.ClickShrinkEffect;
import com.thanosfisherman.wifiutils.WifiUtils;
import com.zaker.android.sapeh.app.main.activitymain.NetworkChecker;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MainActivity extends LocalizationActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
  //  private FirebaseCrashlytics crashlytics;
    boolean doubleBackToExitPressedOnce = false;
    Context context = this;
    String message = "رابط التطبيق App Link";
    String url = "https://play.google.com/store/apps/details?id=com.finallite";
    String egyptLanguageCode = "ar";
    String chinaLanguageCode = "zh";
    String czechLanguageCode = "cs";
    String holandLanguageCode = "nl";
    String londonLanguagwCode = "en";
    String franceLanguageCode = "fr";
    String germanyLanguageCode = "de";
    String indoniseLanguageCode = "in";
    String malyseLanguageCode = "ms";
    String italyLanguageCode = "it";
    String japanLanguageCode = "ja";
    String koreaLanguageCode = "ko";
    String iranLanguageCode = "fa";
    String polandLanguageCode = "pl";
    String protogalLanguageCode = "pt";
    String romaniaLanguageCode = "ro";
    String russiaLanguageCode = "ru";
    String spianLanguageCode = "es";
    String thalandLanguageCode = "th";
    String turkyLanguageCode = "tr";
    String indiaLanguageCode = "hi";
    String bngalideshLanguageCode = "bn";
    String pakistanLanguageCode = "ur";
    String swideshLanguageCode = "sv";
    String albaniLanguageCode = "sq";
    String azrabiganLanguageCode = "az";
    String bosnaLanguageCode = "bs";
    String bulgaryLanguageCode = "bg";
    String nigeraLanguageCode = "ha";
    String norwegLanguageCode = "no";
    String somailyLanguageCode = "so";
    String kenyaLanguageCode = "sw";
  //  private static final String FB_RC_KEY_TITLE="update_title";
  //  private static final String FB_RC_KEY_DESCRIPTION="update_description";
 ///   private static final String FB_RC_KEY_FORCE_UPDATE_VERSION="force_update_version";
  //  private static final String FB_RC_KEY_LATEST_VERSION="latest_version";
  //  AppUpdateDialog appUpdateDialog;
    //FirebaseRemoteConfig mFirebaseRemoteConfig;
    ImageButton btn_rec, book;
    LottieAnimationView animation_view;
    BoomMenuButton bmb1;
    CycleMenuWidget cycleMenuWidget, cycleMenuWidget2;
    private SettingsContract.UserActionsListener presenter;
    private ColorMap colorMap;
    private ColorMap.OnThemeColorChangeListener onThemeColorChangeListener;
    public final static String KEY_IMAGE = "IMAGE";
    public final static String KEY_WEB = "WEB";
    LightTextView q;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        colorMap = ARApplication.getInjector().provideColorMap(getApplicationContext());
        setTheme(colorMap.getAppThemeResource());
        super.onCreate(savedInstanceState);
        presenter = ARApplication.getInjector().provideSettingsPresenter(getApplicationContext());
        //logUser();
        setContentView(R.layout.activity_main);
        //checkAppUpdate();
      //  FontManger.getInstance(getApplicationContext().getAssets());


        animation_view = findViewById(R.id.animation_view);
        book = findViewById(R.id.book);
        btn_rec = findViewById(R.id.btn_rec);
        bmb1 = findViewById(R.id.bmb1);
        cycleMenuWidget = findViewById(R.id.itemCycleMenuWidget1);
        cycleMenuWidget2 = findViewById(R.id.itemCycleMenuWidget2);
        q = findViewById(R.id.q);
        new ClickShrinkEffect(q);

        int image = EasySharedPreference.Companion.getInt(KEY_IMAGE, R.drawable.egypt);
        cycleMenuWidget.setCornerImageResource(image);
        cycleMenuWidget.setMenuRes(R.menu.menu_main);
        cycleMenuWidget.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(View view, int itemPosition) {
                switch (itemPosition) {
                    case 0:

                        setLanguage("ar", "EG");
                        LocaleHelper.setLocale(MainActivity.this,egyptLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/ar/browse/arabic_mokhtasar");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "العربية", R.drawable.egypt, Toast.LENGTH_LONG).show();

                        break;
                    case 1:

                        setLanguage("zh", "CN");
                        LocaleHelper.setLocale(MainActivity.this,chinaLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/zh/browse/chinese_makin");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "中文", R.drawable.china, Toast.LENGTH_LONG).show();

                        break;
                    case 2:

                        setLanguage("cs", "CZ");
                        LocaleHelper.setLocale(MainActivity.this,czechLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_19.html");
                        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2) {
                            reEntry();
                        }else {recreate();}
                        MaterialToast.makeText(context, "česky", R.drawable.czech, Toast.LENGTH_LONG).show();

                        break;
                    case 3:

                        setLanguage("nl", "NL");
                        LocaleHelper.setLocale(MainActivity.this,holandLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_5.html");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "nederlands", R.drawable.holand, Toast.LENGTH_LONG).show();

                        break;
                    case 4:

                        setLanguage("en", "GB");
                        LocaleHelper.setLocale(MainActivity.this,londonLanguagwCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/en/browse/english_saheeh");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "english", R.drawable.london, Toast.LENGTH_LONG).show();

                        break;
                    case 5:

                        setLanguage("fr", "FR");
                        LocaleHelper.setLocale(MainActivity.this,franceLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/fr/browse/french_montada");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "français", R.drawable.france, Toast.LENGTH_LONG).show();
                        break;
                    case 6:

                        setLanguage("de", "DE");
                        LocaleHelper.setLocale(MainActivity.this,germanyLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/de/browse/german_bubenheim");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "deutsche", R.drawable.germany, Toast.LENGTH_LONG).show();
                        break;
                    case 7:

                        setLanguage("in", "ID");
                        LocaleHelper.setLocale(MainActivity.this,indoniseLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/id/browse/indonesian_sabiq");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "bahasa Indonesia", R.drawable.indonesia, Toast.LENGTH_LONG).show();
                        break;
                    case 8:

                        setLanguage("it", "IT");
                        LocaleHelper.setLocale(MainActivity.this,italyLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/en/browse/italian_rwwad");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "italianosia", R.drawable.italy, Toast.LENGTH_LONG).show();
                        break;
                    case 9:

                        setLanguage("ja", "JA");
                        LocaleHelper.setLocale(MainActivity.this,japanLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/en/browse/japanese_saeedsato");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "日本語", R.drawable.japan, Toast.LENGTH_LONG).show();
                        break;
                    case 10:

                        setLanguage("ko", "KR");
                        LocaleHelper.setLocale(MainActivity.this,koreaLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/en/browse/korean_hamid");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "한국어", R.drawable.korea, Toast.LENGTH_LONG).show();
                        break;
                    case 11:

                        setLanguage("fa", "IR");
                        LocaleHelper.setLocale(MainActivity.this,iranLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/fa/browse/persian_ih");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "فارسی", R.drawable.iran, Toast.LENGTH_LONG).show();
                        break;
                    case 12:

                        setLanguage("pl", "PL");
                        LocaleHelper.setLocale(MainActivity.this,polandLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_32.html");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "polskie", R.drawable.poland, Toast.LENGTH_LONG).show();
                        break;
                    case 13:

                        setLanguage("pt", "PT");
                        LocaleHelper.setLocale(MainActivity.this,protogalLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/pt/browse/portuguese_nasr");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "português", R.drawable.portugal, Toast.LENGTH_LONG).show();
                        break;
                    case 14:

                        setLanguage("ro", "RO");
                        LocaleHelper.setLocale(MainActivity.this,romaniaLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_22.html");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "română", R.drawable.romania, Toast.LENGTH_LONG).show();
                        break;
                    case 15:

                        setLanguage("ru", "RU");
                        LocaleHelper.setLocale(MainActivity.this,russiaLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_23.html");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "русский", R.drawable.russia, Toast.LENGTH_LONG).show();
                        break;
                    case 16:

                        setLanguage("es", "ES");
                        LocaleHelper.setLocale(MainActivity.this,spianLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/es/browse/spanish_garcia");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "Español", R.drawable.spain, Toast.LENGTH_LONG).show();
                        break;
                    case 17:

                        setLanguage("th", "TH");
                        LocaleHelper.setLocale(MainActivity.this,thalandLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_37.html");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "ไทย", R.drawable.thailand, Toast.LENGTH_LONG).show();
                        break;
                    case 18:

                        setLanguage("tr","TR");
                        LocaleHelper.setLocale(MainActivity.this,turkyLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/en/browse/turkish_rwwad");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "Türk", R.drawable.turkey, Toast.LENGTH_LONG).show();
                        break;
                    case 19:

                        setLanguage("ms","MY");
                        LocaleHelper.setLocale(MainActivity.this,malyseLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_7.html");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "Malay", R.drawable.malaysia, Toast.LENGTH_LONG).show();
                        break;
                    case 20:

                        setLanguage("hi","IN");
                        LocaleHelper.setLocale(MainActivity.this,indiaLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/hi/browse/hindi_omari");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "হিন্দী", R.drawable.india, Toast.LENGTH_LONG).show();
                        break;
                    case 21:

                        setLanguage("ur","PK");
                        LocaleHelper.setLocale(MainActivity.this,pakistanLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/ur/browse/urdu_junagarhi");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "اورد", R.drawable.pakistan, Toast.LENGTH_LONG).show();
                        break;
                    case 22:

                        setLanguage("bn","BD");
                        LocaleHelper.setLocale(MainActivity.this,bngalideshLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/bn/browse/bengali_zakaria");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "বাংলা", R.drawable.bangladesh, Toast.LENGTH_LONG).show();
                        break;
                    case 23:

                        setLanguage("sv","SE");
                        LocaleHelper.setLocale(MainActivity.this,swideshLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_24.html");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "svenska", R.drawable.sweden, Toast.LENGTH_LONG).show();
                        break;
                    case 24:

                        setLanguage("sq","AL");
                        LocaleHelper.setLocale(MainActivity.this,albaniLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/sq/browse/albanian_nahi");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "shqipe", R.drawable.albania, Toast.LENGTH_LONG).show();
                        break;
                    case 25:

                        setLanguage("az","AZ");
                        LocaleHelper.setLocale(MainActivity.this,azrabiganLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/en/browse/azeri_musayev");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "Azərbaycan dili", R.drawable.azerbaijan, Toast.LENGTH_LONG).show();
                        break;
                    case 26:

                        setLanguage("bs","BA");
                        LocaleHelper.setLocale(MainActivity.this,bosnaLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/bs/browse/bosnian_rwwad");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "Bosanski jezik", R.drawable.bosnia_and_herzegovina, Toast.LENGTH_LONG).show();
                        break;
                    case 27:

                        setLanguage("bg","BG");
                        LocaleHelper.setLocale(MainActivity.this,bulgaryLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_28.html");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "български", R.drawable.bulgaria, Toast.LENGTH_LONG).show();
                        break;
                    case 28:

                        setLanguage("ha","NG");
                        LocaleHelper.setLocale(MainActivity.this,nigeraLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/en/browse/hausa_gummi");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "Hausa", R.drawable.nigeria, Toast.LENGTH_LONG).show();
                        break;
                    case 29:

                        setLanguage("no","NO");
                        LocaleHelper.setLocale(MainActivity.this,norwegLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://www.omaniyat.net/quran/language_31.html");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "Norsk språk", R.drawable.norway, Toast.LENGTH_LONG).show();
                        break;
                    case 30:

                        setLanguage("so","SO");
                        LocaleHelper.setLocale(MainActivity.this,somailyLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/en/browse/somali_abduh");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "Afka Soomaaliga", R.drawable.somalia, Toast.LENGTH_LONG).show();
                        break;
                    case 31:

                        setLanguage("sw","KE");
                        LocaleHelper.setLocale(MainActivity.this,kenyaLanguageCode);
                        EasySharedPreference.Companion.putString(KEY_WEB, "https://quranenc.com/en/browse/swahili_abubakr");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            recreate();
                        }else {reEntry();}
                        MaterialToast.makeText(context, "Lugha ya swahili", R.drawable.kenya, Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onMenuItemLongClick(View view, int itemPosition) {

            }
        });

        cycleMenuWidget.setStateChangeListener(new OnStateChangedListener() {
            @Override
            public void onStateChanged(CycleMenuWidget.STATE state) {

            }

            @Override
            public void onOpenComplete() {
                MaterialToast.makeText(context, getResources().getString(R.string.turnlang), R.drawable.langauge,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCloseComplete() {
            }
        });


        cycleMenuWidget2.setCornerImageResource(image);
        cycleMenuWidget2.setMenuRes(R.menu.menu_theme);
        cycleMenuWidget2.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(View view, int itemPosition) {
                String colorKey = SettingsMapper.positionToColorKey(itemPosition);
                colorMap.updateColorMap(colorKey);
                presenter.setSettingThemeColor(colorKey);

            }

            @Override
            public void onMenuItemLongClick(View view, int itemPosition) {

            }
        });

        cycleMenuWidget2.setStateChangeListener(new OnStateChangedListener() {
            @Override
            public void onStateChanged(CycleMenuWidget.STATE state) {
                int selected = SettingsMapper.colorKeyToPosition(colorMap.getSelected());
                cycleMenuWidget2.setCurrentPosition(selected);
            }

            @Override
            public void onOpenComplete() {

            }

            @Override
            public void onCloseComplete() {
            }
        });

        onThemeColorChangeListener = colorKey -> {
            setTheme(colorMap.getAppThemeResource());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                recreate();
            }else {reEntry();}
        };
        colorMap.addOnThemeColorChangeListener(onThemeColorChangeListener);

        animation_view.setAnimation("final.json");
        animation_view.setRenderMode(RenderMode.SOFTWARE);
        animation_view.playAnimation();
        animation_view.loop(false);
        animation_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animation_view.isAnimating()){
                    animation_view.pauseAnimation();
                }else {
                    animation_view.resumeAnimation();
                }

            }
        });

        new ClickShrinkEffect(btn_rec);
        btn_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, MainRecActivity.class));
            }
        });

        new ClickShrinkEffect(book);

            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (NetworkChecker.isNetworkConnected(MainActivity.this)) {
                        int color = EasySharedPreference.Companion.getInt(KEY_COLOR, R.color.brown_100);
                        new FinestWebView(context)
                                .theme(R.style.FinestWebViewTheme)
                                .titleDefault(getResources().getString(R.string.app_name))
                                .showUrl(false)
                                .webViewBuiltInZoomControls(true)
                                .webViewDisplayZoomControls(true)
                                .statusBarColorRes(color)
                                .toolbarColorRes(color)
                                .titleColorRes(R.color.white)
                                .urlColorRes(R.color.white)
                                .iconDefaultColorRes(R.color.white)
                                .progressBarColorRes(R.color.white)
                                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                                .swipeRefreshColorRes(color)
                                .menuSelector(R.drawable.selector_light_theme)
                                .menuTextGravity(Gravity.CENTER_VERTICAL | Gravity.END)
                                .menuTextPaddingRightRes(R.dimen.defaultMenuTextPaddingLeft).dividerHeight(0).gradientDivider(false)
                                .setCustomAnimations(R.anim.slide_left_in, R.anim.hold, R.anim.hold, R.anim.slide_right_out)
                                .disableIconBack(false).disableIconClose(false).disableIconForward(false).disableIconMenu(false)
                                .show(EasySharedPreference.Companion.getString(KEY_WEB, "https://quranenc.com/en/browse/english_saheeh"));
                    } else {
                        new MaterialToast(context)
                                .setMessage(getResources().getString(R.string.fetchs))
                                .setIcon(R.drawable.nowifi)
                                .setDuration(Toast.LENGTH_LONG)
                                .setBackgroundColor(Color.parseColor("#EE4035"))
                                .show();
                    }
                }
            });


        assert bmb1 != null;
        bmb1.setShareLineLength(30);
        bmb1.setShareLineWidth(4);
        bmb1.setDotRadius(9);
        bmb1.setShareLine1Color(R.color.message_color);
        bmb1.setShareLine2Color(R.color.message_color);

        float w = Util.dp2px(80);
        float h = Util.dp2px(96);
        float h_0_5 = h / 2;
        float h_1_5 = h * 1.5f;

        float hm = bmb1.getButtonHorizontalMargin();
        float vm = bmb1.getButtonVerticalMargin();
        float vm_0_5 = vm / 2;
        float vm_1_5 = vm * 1.5f;

        bmb1.getCustomButtonPlacePositions().add(new PointF(-w - hm, -h_1_5 - vm_1_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(      0, -h_1_5 - vm_1_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(+w + hm, -h_1_5 - vm_1_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(-w - hm, -h_0_5 - vm_0_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(      0, -h_0_5 - vm_0_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(+w + hm, -h_0_5 - vm_0_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(-w - hm, +h_0_5 + vm_0_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(      0, +h_0_5 + vm_0_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(+w + hm, +h_0_5 + vm_0_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(-w - hm, +h_1_5 + vm_1_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(      0, +h_1_5 + vm_1_5));
        bmb1.getCustomButtonPlacePositions().add(new PointF(+w + hm, +h_1_5 + vm_1_5));

        TextOutsideCircleButton.Builder facebook = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.facebook)
                .normalTextRes(R.string.sharefacebook)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.FACEBOOK)
                                .url(url)
                                .build();
                        shareInstance.share();

                    }
                });
        bmb1.addBuilder(facebook);

        TextOutsideCircleButton.Builder twitter = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.twitter)
                .normalTextRes(R.string.sharetwitter)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.TWITTER)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(twitter);

        TextOutsideCircleButton.Builder google = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.gmail)
                .normalTextRes(R.string.sharegmail)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.GOOGLE)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(google);

        TextOutsideCircleButton.Builder whatsapp = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.whatsapp)
                .normalTextRes(R.string.sharewhatapp)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.WHATSAPP)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(whatsapp);

        TextOutsideCircleButton.Builder instagram = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.instagram)
                .normalTextRes(R.string.shareinstagram)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.INSTAGRAM)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(instagram);

        TextOutsideCircleButton.Builder tumblr = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.tumblr)
                .normalTextRes(R.string.sharetumblr)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.TUMBLR)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(tumblr);

        TextOutsideCircleButton.Builder linkedin = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.linkedin)
                .normalTextRes(R.string.sharelinkedin)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.LINKED_IN)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(linkedin);

        TextOutsideCircleButton.Builder mail = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.viber)
                .normalTextRes(R.string.shareviber)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.VIBER)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(mail);

        TextOutsideCircleButton.Builder snapchat = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.snapchat)
                .normalTextRes(R.string.sharesnapchat)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.SNAPCHAT)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(snapchat);

        TextOutsideCircleButton.Builder skype = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.skype)
                .normalTextRes(R.string.shareskype)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.SKYPE)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(skype);

        TextOutsideCircleButton.Builder telegram = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.telegram)
                .normalTextRes(R.string.sharetelegram)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.TELEGRAM)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(telegram);

        TextOutsideCircleButton.Builder reddit = new TextOutsideCircleButton.Builder()
                .normalImageRes(R.drawable.reddit)
                .normalTextRes(R.string.sharereddit)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        Shareable shareInstance = new Shareable.Builder(context)
                                .message(message)
                                .socialChannel(Shareable.Builder.REDDIT)
                                .url(url)
                                .build();
                        shareInstance.share();
                    }
                });
        bmb1.addBuilder(reddit);



// Use OnBoomListenerAdapter to listen part of methods
        bmb1.setOnBoomListener(new OnBoomListenerAdapter() {
            @Override
            public void onBoomWillShow() {
                super.onBoomWillShow();
                // logic here

            }
        });

        // Use OnBoomListener to listen all methods
        bmb1.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {
                // If you have implement listeners for boom-buttons in builders,
                // then you shouldn't add any listener here for duplicate callbacks.
            }

            /**
             * When the background of boom-buttons is clicked.
             */
            @Override
            public void onBackgroundClick() {

            }

            /**
             * When the BMB is going to hide its boom-buttons.
             */
            @Override
            public void onBoomWillHide() {
            }

            /**
             * When the BMB finishes hide animations.
             */
            @Override
            public void onBoomDidHide() {

            }

            /**
             * When the BMB is going to show its boom-buttons.
             */
            @Override
            public void onBoomWillShow() {
                WifiUtils.withContext(getApplicationContext()).enableWifi(this::checkResult);

            }

            private void checkResult(boolean isSuccess)
            {
                if (isSuccess)
                    new MaterialToast(context)
                            .setMessage(getResources().getString(R.string.wifion))
                            .setIcon(R.drawable.wifi)
                            .setDuration(Toast.LENGTH_LONG)
                            .setBackgroundColor(Color.parseColor("#55b859"))
                            .show();
                else
                    new MaterialToast(context)
                            .setMessage(getResources().getString(R.string.wifion))
                            .setIcon(R.drawable.nowifi)
                            .setDuration(Toast.LENGTH_LONG)
                            .setBackgroundColor(Color.parseColor("#EE4035"))
                            .show();
            }

            /**
             * When the BMB finished boom animations.
             */
            @Override
            public void onBoomDidShow() {

            }
        });




    }

    private void reEntry() {
        finish();
        Intent f10 = new Intent(MainActivity.this, MainActivity.class);
        f10.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(f10);
        overridePendingTransition (R.anim.popup_flyout_show, R.anim.popup_flyout_hide);
    }

/*    private void checkAppUpdate() {
        final int versionCode = BuildConfig.VERSION_CODE;

        final HashMap<String, Object> defaultMap = new HashMap<>();
        defaultMap.put(FB_RC_KEY_TITLE, getResources().getString(R.string.dialog_title));
        defaultMap.put(FB_RC_KEY_DESCRIPTION, getResources().getString(R.string.dialog_message));
        defaultMap.put(FB_RC_KEY_FORCE_UPDATE_VERSION, ""+versionCode);
        defaultMap.put(FB_RC_KEY_LATEST_VERSION, ""+versionCode);

        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

        mFirebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().build());

        mFirebaseRemoteConfig.setDefaultsAsync(defaultMap);

        Task<Void> fetchTask=mFirebaseRemoteConfig.fetch(BuildConfig.DEBUG?0: TimeUnit.HOURS.toSeconds(4));

        fetchTask.addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    // After config data is successfully fetched, it must be activated before newly fetched
                    // values are returned.
                    new MaterialToast(context)
                            .setMessage(getResources().getString(R.string.fetchs))
                            .setIcon(R.drawable.wifi)
                            .setDuration(Toast.LENGTH_LONG)
                            .setBackgroundColor(Color.parseColor("#55b859"))
                            .show();
                    mFirebaseRemoteConfig.fetchAndActivate();

                    String title=getValue(FB_RC_KEY_TITLE,defaultMap);
                    String description=getValue(FB_RC_KEY_DESCRIPTION,defaultMap);
                    int forceUpdateVersion= Integer.parseInt(getValue(FB_RC_KEY_FORCE_UPDATE_VERSION,defaultMap));
                    int latestAppVersion= Integer.parseInt(getValue(FB_RC_KEY_LATEST_VERSION,defaultMap));

                    boolean isCancelable=true;

                    if(latestAppVersion>versionCode)
                    {
                        if(forceUpdateVersion>versionCode)
                            isCancelable=false;

                        appUpdateDialog = new AppUpdateDialog(MainActivity.this, title, description, isCancelable);
                        appUpdateDialog.setCancelable(false);
                        appUpdateDialog.show();

                        Window window = appUpdateDialog.getWindow();
                        assert window != null;
                        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                    }

                } else {

                    new MaterialToast(context)
                            .setMessage(getResources().getString(R.string.fetchs))
                            .setIcon(R.drawable.nowifi)
                            .setDuration(Toast.LENGTH_LONG)
                            .setBackgroundColor(Color.parseColor("#EE4035"))
                            .show();
                }
            }
        });
    } */

 /*   private void logUser() {
        crashlytics = FirebaseCrashlytics.getInstance();
        crashlytics.setCrashlyticsCollectionEnabled(true);
        crashlytics.checkForUnsentReports();
        crashlytics.sendUnsentReports();
        crashlytics.setUserId("id-99999");
        crashlytics.setCustomKey("Name", "Sapeh");
        crashlytics.setCustomKey("Email", "asmmya7@gmail.com");
    }  */

  /*  public String getValue(String parameterKey,HashMap<String, Object> defaultMap)
    {
        String value=mFirebaseRemoteConfig.getString(parameterKey);
        if(TextUtils.isEmpty(value))
            value= (String) defaultMap.get(parameterKey);

        return value;
    } */

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        new MaterialToast(context)
                .setMessage(getResources().getString(R.string.back))
                .setIcon(R.mipmap.ic_launcher)
                .setDuration(Toast.LENGTH_LONG)
                .setBackgroundColor(Color.parseColor("#EE4035"))
                .show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadSettings();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.unbindView();
        }
    }

}