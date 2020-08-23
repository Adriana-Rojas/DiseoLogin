package com.example.juliocesar.diseologin;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;

import java.util.Objects;

@SuppressLint("StaticFieldLeak")
public class SettingsActivity extends AppCompatActivity  {

    private int themeColor;
    private int themeColorDark;
    private static com.kizitonwose.colorpreferencecompat.ColorPreferenceCompat theme_color;
    int themeBarValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
            int themeId = sharedPrefs.getInt("ThemeBar", R.style.AppTheme);
            themeColor = sharedPrefs.getInt("accent_color_dialog", Color.parseColor("#2196f3"));
            themeColorDark = GetDetails.getDarkColor(this, themeColor);
            setTheme(themeId);

            if (sharedPrefs.getInt("ThemeBar", 0) != R.style.AppThemeDark) {
                Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(themeColor));
                getWindow().setStatusBarColor(themeColorDark);
            }
            Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(getString(R.string.app_name), icon, themeColor);
            setTaskDescription(taskDescription);

            super.onCreate(savedInstanceState);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        SwitchPreference dark_theme_Pref;
        SharedPreferences sharedPrefs;
        SharedPreferences.Editor shareEdit;
        Preference app_version_pref, pref_rate_us, pref_extract_location;

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            try {
                sharedPrefs = PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull(getActivity()));
                shareEdit = sharedPrefs.edit();


                dark_theme_Pref = findPreference("dark_theme_switch");
                app_version_pref = findPreference("app_version_pref");


                if (sharedPrefs.getInt("ThemeBar", 0) == R.style.AppThemeDark) {
                    dark_theme_Pref.setChecked(true);
                    dark_theme_Pref.setSummary("Disable Dark Theme");
                } else {
                    dark_theme_Pref.setChecked(false);
                    dark_theme_Pref.setSummary("Enable Dark Theme");
                }
                app_version_pref.setSummary(BuildConfig.VERSION_NAME);
                pref_rate_us = findPreference("pref_rate_us");


                pref_extract_location = findPreference("pref_extract_location");
                String getExtractpath = sharedPrefs.getString("extract_location", "/storage/emulated/0/DeviceInfo");
                pref_extract_location.setSummary(getExtractpath);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Eficiencia1.class);
        this.finish();
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


}