package com.ytheekshana.deviceinfo;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class tabSystem extends Fragment {
    static String tiempo;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tabsystem, container, false);
        LinearLayout llayout = rootView.findViewById(R.id.llayout);
        ImageView imgAndroidLogo = rootView.findViewById(R.id.imgAndroidLogo);
        TextView txtAndroidVersionNumber = rootView.findViewById(R.id.txtAndroidVersionNumber);
        TextView txtAndroidVersionName = rootView.findViewById(R.id.txtAndroidVersionName);
        TextView txtAndroidVersionDate = rootView.findViewById(R.id.txtAndroidVersionDate);
        TextView txtRootStatus = rootView.findViewById(R.id.txtRootStatus);

        try {
            int textDisColor = Eficiencia.themeColor;
            int lineColor = GetDetails.getThemeColor(Objects.requireNonNull(getContext()), R.attr.colorButtonNormal);
            CardView cardviewRam = rootView.findViewById(R.id.cardviewSystem);
            cardviewRam.setCardBackgroundColor(Eficiencia.themeColor);

            switch (Build.VERSION.SDK_INT) {
                case 21:
                case 22:
                    imgAndroidLogo.setImageResource(R.drawable.lollipop);
                    break;
                case 23:
                    imgAndroidLogo.setImageResource(R.drawable.marshmallow);
                    break;
                case 24:
                case 25:
                    imgAndroidLogo.setImageResource(R.drawable.nougat);
                    break;
                case 26:
                case 27:
                    imgAndroidLogo.setImageResource(R.drawable.oreo);
                    break;
                case 28:
                    imgAndroidLogo.setImageResource(R.drawable.pie);
                    break;
            }
            String Aversion = "Android " + Build.VERSION.RELEASE;
            txtAndroidVersionNumber.setText(Aversion);
            txtAndroidVersionName.setText(GetDetails.GetOSName(Build.VERSION.SDK_INT).toUpperCase());
            String AReleaseDate = "Publicado : " + GetDetails.GetOSReleaseDate();
            txtAndroidVersionDate.setText(AReleaseDate);
            if (SplashActivity.rootedStatus) {
                txtRootStatus.setText("Acceso Root  Disponible");
            } else {
                txtRootStatus.setText("Acceso Root No Disponible");
            }

            TextView txtAndroidName = new TextView(getContext());
            TextView txtAndroidNamedis = new TextView(getContext());
            View v1 = new View(getContext());
            v1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v1.setBackgroundColor(lineColor);
            txtAndroidName.setText("Nombre del Sistema");
            txtAndroidName.setTypeface(null, Typeface.BOLD);
            txtAndroidName.setTextSize(16);
            txtAndroidName.setPadding(0, 15, 0, 0);
            txtAndroidNamedis.setPadding(0, 0, 0, 15);
            txtAndroidNamedis.setTextColor(textDisColor);
            txtAndroidNamedis.setTextSize(16);
            txtAndroidNamedis.setText(GetDetails.GetOSNameAdvanced());
            txtAndroidNamedis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtAndroidName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtAndroidName);
            llayout.addView(txtAndroidNamedis);
            llayout.addView(v1);


            if (Build.VERSION.SDK_INT >= 23) {
                TextView txtSecurityPatch = new TextView(getContext());
                TextView txtSecurityPatchdis = new TextView(getContext());
                View v3 = new View(getContext());
                v3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
                v3.setBackgroundColor(lineColor);
                txtSecurityPatch.setText("Nivel de parches de seguridad");
                txtSecurityPatch.setTypeface(null, Typeface.BOLD);
                txtSecurityPatch.setTextSize(16);
                txtSecurityPatch.setPadding(0, 15, 0, 0);
                txtSecurityPatchdis.setPadding(0, 0, 0, 15);
                txtSecurityPatchdis.setTextColor(textDisColor);
                txtSecurityPatchdis.setTextSize(16);
                txtSecurityPatchdis.setText(Build.VERSION.SECURITY_PATCH);
                txtSecurityPatchdis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                txtSecurityPatch.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                llayout.addView(txtSecurityPatch);
                llayout.addView(txtSecurityPatchdis);
                llayout.addView(v3);
            }



            TextView txtRootAccess = new TextView(getContext());
            TextView txtRootAccessdis = new TextView(getContext());
            View v12 = new View(getContext());
            v12.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v12.setBackgroundColor(lineColor);
            txtRootAccess.setText("Acceso Root");
            txtRootAccess.setTypeface(null, Typeface.BOLD);
            txtRootAccess.setTextSize(16);
            txtRootAccess.setPadding(0, 15, 0, 0);
            txtRootAccessdis.setPadding(0, 0, 0, 15);
            txtRootAccessdis.setTextColor(textDisColor);
            txtRootAccessdis.setTextSize(16);
            txtRootAccessdis.setText(SplashActivity.rootedStatus ? "Yes" : "No");
            txtRootAccessdis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtRootAccess.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtRootAccess);
            llayout.addView(txtRootAccessdis);
            llayout.addView(v12);


            TextView txtSystemUptime = new TextView(getContext());
            final TextView txtSystemUptimedis = new TextView(getContext());
            View v13 = new View(getContext());
            v13.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v13.setBackgroundColor(lineColor);
            txtSystemUptime.setText("Tiempo de actividad del Sistema");
            txtSystemUptime.setTypeface(null, Typeface.BOLD);
            txtSystemUptime.setTextSize(16);
            txtSystemUptime.setPadding(0, 15, 0, 0);
            txtSystemUptimedis.setPadding(0, 0, 0, 15);
            txtSystemUptimedis.setTextColor(textDisColor);
            txtSystemUptimedis.setTextSize(16);
            txtSystemUptimedis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtSystemUptime.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtSystemUptime);
            llayout.addView(txtSystemUptimedis);
            llayout.addView(v13);

            final Handler h = new Handler();
            h.postDelayed(new Runnable() {
                Long uptime;

                @Override
                public void run() {
                    uptime = SystemClock.elapsedRealtime();
                    txtSystemUptimedis.setText(GetDetails.getTime(uptime));
                    tiempo=txtSystemUptimedis.getText().toString();
                    h.postDelayed(this, 1000);
                }
            }, 1000);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rootView;
    }
}

