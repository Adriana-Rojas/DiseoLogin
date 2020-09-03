package com.ytheekshana.deviceinfo;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.preference.PreferenceManager;

import com.google.android.material.appbar.AppBarLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class Eficiencia extends AppCompatActivity {
    NotificationCompat.Builder mBuilder;
    public static int themeColor, themeColor2, themeColorDark, requestReviewCount;
    public static boolean isDarkmode;
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor editor;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Eficiencia");
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        int themeId = sharedPrefs.getInt("ThemeNoBar", R.style.AppTheme_NoActionBar);
        requestReviewCount = sharedPrefs.getInt("requestReviewCount", 0);
        themeColor = sharedPrefs.getInt("accent_color_dialog", Color.parseColor("#2196f3"));
        themeColorDark = GetDetails.getDarkColor(this, themeColor);
        themeColor2 = GetDetails.getDarkColor2(this, themeColor);
        setTheme(themeId);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_eficiencia);
        AppBarLayout appbar = findViewById(R.id.appbar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final SmartTabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setSelectedIndicatorColors(themeColorDark);
        tabLayout.setViewPager(mViewPager);

        if (sharedPrefs.getInt("ThemeNoBar", 0) != R.style.AppThemeDark_NoActionBar) {
            appbar.setBackgroundColor(themeColor);
            toolbar.setBackgroundColor(themeColor);
            tabLayout.setBackgroundColor(themeColor);
            getWindow().setStatusBarColor(themeColorDark);
            isDarkmode = false;
        } else {
            isDarkmode = true;
        }
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
        ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(getString(R.string.app_name), icon, themeColor);
        setTaskDescription(taskDescription);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPrefs.edit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new tabDashboard();
                case 1:
                    return new tabDevice();
                case 2:
                    return new tabSystem();
                case 3:
                    return new tabCPU();
                case 4:
                    return new tabBattery();
                case 5:
                    return new tabDisplay();
                case 6:
                    return new tabMemory();
               case 7:
                   return new tabApps();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Inicio";
                case 1:
                    return "Dispositivo";
                case 2:
                    return "Sistema";
                case 3:
                    return "CPU";
                case 4:
                    return "Bateria";
                case 5:
                    return "Pantalla";
                case 6:
                    return "Memoria";
                 case 7:
                   return "Aplicaciones";

            }
            return null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment fragment : fragments) {
            fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
