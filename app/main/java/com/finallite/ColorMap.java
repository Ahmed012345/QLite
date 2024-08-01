package com.finallite;

import static com.finallite.MainActivity.KEY_IMAGE;
import static com.finallite.app.main.finestwebview.FinestWebViewActivity.KEY_COLOR;

import com.finallite.app.main.easysharedpreferences.EasySharedPreference;
import com.finallite.data.Prefs;
import java.util.ArrayList;
import java.util.List;

public class ColorMap {

	private static ColorMap singleton;

	public static ColorMap getInstance(Prefs prefs) {
		if (singleton == null) {
			singleton = new ColorMap(prefs);
		}
		return singleton;
	}

	private int appThemeResource = 0;
	private int primaryColorRes = R.color.md_blue_700;
	private int primaryDarkRes = R.color.md_blue_gray_500;
	private int playbackPanelBackground = R.drawable.panel_amber;
	private String selectedKey;
	private final List<OnThemeColorChangeListener> onThemeColorChangeListeners;
	public final static String KEY_IMAGE2 = "IMAGE2";

	private ColorMap(Prefs prefs) {
		onThemeColorChangeListeners = new ArrayList<>();
		selectedKey = prefs.getSettingThemeColor();
		init();
	}

	private void init() {
		switch (selectedKey) {
			case AppConstants.THEME_BLACK:
				appThemeResource = R.style.AppTheme_Black;
				primaryColorRes = R.color.md_black_1000;
				primaryDarkRes = R.color.md_grey_900x;
				playbackPanelBackground = R.drawable.panel_dark;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_black);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.md_black_1000);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t2);
				break;
			case AppConstants.THEME_TEAL:
				appThemeResource = R.style.AppTheme_Teal;
				primaryColorRes = R.color.md_teal_700;
				primaryDarkRes = R.color.md_teal_700x;
				playbackPanelBackground = R.drawable.panel_green;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_teal);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.md_teal_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t3);
				break;
			case AppConstants.THEME_PURPLE:
				appThemeResource = R.style.AppTheme_Purple;
				primaryColorRes = R.color.md_deep_purple_700;
				primaryDarkRes = R.color.md_deep_purple_700x;
				playbackPanelBackground = R.drawable.panel_pink;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_pink);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.md_deep_purple_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t5);
				break;
			case AppConstants.THEME_PINK:
				appThemeResource = R.style.AppTheme_Pink;
				primaryColorRes = R.color.md_pink_800;
				primaryDarkRes = R.color.md_pink_800x;
				playbackPanelBackground = R.drawable.panel_purple;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_purple);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.md_pink_800);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t6);
				break;
			case AppConstants.THEME_ORANGE:
				appThemeResource = R.style.AppTheme_DeepOrange;
				primaryColorRes = R.color.md_deep_orange_800;
				primaryDarkRes = R.color.md_deep_orange_900;
				playbackPanelBackground = R.drawable.panel_yellow;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_yellow);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.md_deep_orange_800);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t7);
				break;
			case AppConstants.THEME_RED:
				appThemeResource = R.style.AppTheme_Red;
				primaryColorRes = R.color.md_red_700;
				primaryDarkRes = R.color.md_red_900;
				playbackPanelBackground = R.drawable.panel_purple_light;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_red);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.md_red_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t8);
				break;
			case AppConstants.THEME_BROWN:
				appThemeResource = R.style.AppTheme_Brown;
				primaryColorRes = R.color.md_brown_700;
				primaryDarkRes = R.color.md_brown_800;
				playbackPanelBackground = R.drawable.panel_deep_orange;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_brown);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.md_brown_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t9);
				break;
			case AppConstants.THEME_BLUE:
				primaryColorRes = R.color.md_blue_700;
				appThemeResource = R.style.AppTheme_Blue;
				primaryDarkRes = R.color.md_blue_700x;
				playbackPanelBackground = R.drawable.panel_amber;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_blue);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.md_blue_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t4);
				break;
			case AppConstants.THEME_GREEN:
				primaryColorRes = R.color.green_700;
				appThemeResource = R.style.AppTheme_Green;
				primaryDarkRes = R.color.green_800;
				playbackPanelBackground = R.drawable.panel_pink;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_green);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.green_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t10);
				break;
			case AppConstants.THEME_GREY:
				primaryColorRes = R.color.grey_700;
				appThemeResource = R.style.AppTheme_Grey;
				primaryDarkRes = R.color.grey_800;
				playbackPanelBackground = R.drawable.panel_pink;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_grey);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.grey_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t11);
				break;
			case AppConstants.THEME_INDIGO:
				primaryColorRes = R.color.indigo_700;
				appThemeResource = R.style.AppTheme_Indigo;
				primaryDarkRes = R.color.indigo_800;
				playbackPanelBackground = R.drawable.panel_amber;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_indigo);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.indigo_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t12);
				break;
			case AppConstants.THEME_LIGHT_BLUE:
				primaryColorRes = R.color.light_blue_700;
				appThemeResource = R.style.AppTheme_light_blue;
				primaryDarkRes = R.color.light_blue_800;
				playbackPanelBackground = R.drawable.panel_green;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_ight_blue);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.light_blue_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t13);
				break;
			case AppConstants.THEME_LIGHT_GREEN:
				primaryColorRes = R.color.light_green_700;
				appThemeResource = R.style.AppTheme_light_green;
				primaryDarkRes = R.color.light_green_800;
				playbackPanelBackground = R.drawable.panel_blue;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_light_green);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.light_green_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t14);
				break;
			case AppConstants.THEME_LIME:
				primaryColorRes = R.color.lime_700;
				appThemeResource = R.style.AppTheme_lime;
				primaryDarkRes = R.color.lime_800;
				playbackPanelBackground = R.drawable.panel_purple_light;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_lime);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.lime_800);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t15);
				break;
			case AppConstants.THEME_BLUE_GREY:
			default:
				appThemeResource = R.style.AppTheme_BlueGray;
				primaryColorRes = R.color.md_blue_gray_700;
				primaryDarkRes = R.color.md_blue_gray_500;
				playbackPanelBackground = R.drawable.panel_red;
				EasySharedPreference.Companion.putInt(KEY_IMAGE, R.drawable.ic_a_blue_grey);
				EasySharedPreference.Companion.putInt(KEY_COLOR, R.color.md_blue_gray_700);
				EasySharedPreference.Companion.putInt(KEY_IMAGE2, R.drawable.t1);
		}
	}

	public void updateColorMap(String colorKey) {
		String oldSelected = selectedKey;
		selectedKey = colorKey;
		if (!oldSelected.equals(selectedKey)) {
			init();
			onThemeColorChange(selectedKey);
		}
	}

	public String getSelected() {
		return selectedKey;
	}

	public int getAppThemeResource() {
		return appThemeResource;
	}

	public int getPrimaryColorRes() {
		return primaryColorRes;
	}

	public int getPrimaryDarkColorRes() {
		return primaryDarkRes;
	}

	public int getPlaybackPanelBackground() {
		return playbackPanelBackground;
	}


	public void addOnThemeColorChangeListener(OnThemeColorChangeListener onThemeColorChangeListener) {
		this.onThemeColorChangeListeners.add(onThemeColorChangeListener);
	}

	public void removeOnThemeColorChangeListener(OnThemeColorChangeListener onThemeColorChangeListener) {
		this.onThemeColorChangeListeners.remove(onThemeColorChangeListener);
	}

	public void onThemeColorChange(String colorKey) {
		for (int i = 0; i < onThemeColorChangeListeners.size(); i++) {
			onThemeColorChangeListeners.get(i).onThemeColorChange(colorKey);
		}
	}

	public interface OnThemeColorChangeListener {
		void onThemeColorChange(String colorKey);
	}
}
