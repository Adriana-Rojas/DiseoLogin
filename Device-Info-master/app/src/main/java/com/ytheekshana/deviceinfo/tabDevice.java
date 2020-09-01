package com.ytheekshana.deviceinfo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class tabDevice extends Fragment {
    private static final int REQUEST_PHONE_STATE = 1;
    private TextView  txtNetworkOperatordis;
    private TelephonyManager tm;

    @SuppressLint("HardwareIds")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tabdevice, container, false);
        LinearLayout llayout = rootView.findViewById(R.id.llayout);
        try {

            int textDisColor = Eficiencia.themeColor;
            int lineColor = GetDetails.getThemeColor(Objects.requireNonNull(getContext()), R.attr.colorButtonNormal);
            tm = (TelephonyManager) Objects.requireNonNull(getActivity()).getSystemService(Context.TELEPHONY_SERVICE);

            TextView txtName = new TextView(getContext());
            final TextView txtNamedis = new TextView(getContext());
            View v20 = new View(getContext());
            v20.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v20.setBackgroundColor(lineColor);
            txtName.setText("Nombre del Dispositivo");
            txtName.setTypeface(null, Typeface.BOLD);
            txtName.setTextSize(16);
            txtNamedis.setPadding(0, 0, 0, 15);
            txtNamedis.setTextColor(textDisColor);
            txtNamedis.setTextSize(16);
            txtNamedis.setText(SplashActivity.deviceName);
            txtNamedis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtName);
            llayout.addView(txtNamedis);
            llayout.addView(v20);

            TextView txtModel = new TextView(getContext());
            TextView txtModeldis = new TextView(getContext());
            View v = new View(getContext());
            v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v.setBackgroundColor(lineColor);
            txtModel.setText("Modelo");
            txtModel.setTypeface(null, Typeface.BOLD);
            txtModel.setTextSize(16);
            txtModel.setPadding(0, 15, 0, 0);
            txtModeldis.setPadding(0, 0, 0, 15);
            txtModeldis.setTextColor(textDisColor);
            txtModeldis.setTextSize(16);
            txtModeldis.setText(Build.MODEL);
            txtModeldis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtModel.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtModel);
            llayout.addView(txtModeldis);
            llayout.addView(v);

            TextView txtManufacturer = new TextView(getContext());
            TextView txtManufacturerdis = new TextView(getContext());
            View v1 = new View(getContext());
            v1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v1.setBackgroundColor(lineColor);
            txtManufacturer.setText("Fabricante");
            txtManufacturer.setTypeface(null, Typeface.BOLD);
            txtManufacturer.setTextSize(16);
            txtManufacturer.setPadding(0, 15, 0, 0);
            txtManufacturerdis.setPadding(0, 0, 0, 15);
            txtManufacturerdis.setTextColor(textDisColor);
            txtManufacturerdis.setTextSize(16);
            txtManufacturerdis.setText(Build.MANUFACTURER);
            txtManufacturerdis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtManufacturer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtManufacturer);
            llayout.addView(txtManufacturerdis);
            llayout.addView(v1);

            TextView txtDevice = new TextView(getContext());
            TextView txtDevicedis = new TextView(getContext());
            View v2 = new View(getContext());
            v2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v2.setBackgroundColor(lineColor);
            txtDevice.setText("Dispositivo");
            txtDevice.setTypeface(null, Typeface.BOLD);
            txtDevice.setTextSize(16);
            txtDevice.setPadding(0, 15, 0, 0);
            txtDevicedis.setPadding(0, 0, 0, 15);
            txtDevicedis.setTextColor(textDisColor);
            txtDevicedis.setTextSize(16);
            txtDevicedis.setText(Build.MANUFACTURER);
            txtDevicedis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtDevice.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtDevice);
            llayout.addView(txtDevicedis);
            llayout.addView(v2);

            TextView txtNetworkOperator = new TextView(getContext());
            txtNetworkOperatordis = new TextView(getContext());
            View v12 = new View(getContext());
            v12.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v12.setBackgroundColor(lineColor);
            txtNetworkOperator.setText("Operador de Red");
            txtNetworkOperator.setTypeface(null, Typeface.BOLD);
            txtNetworkOperator.setTextSize(16);
            txtNetworkOperator.setPadding(0, 15, 0, 0);
            txtNetworkOperatordis.setClickable(true);
            txtNetworkOperatordis.setPadding(0, 0, 0, 15);
            txtNetworkOperatordis.setTextColor(textDisColor);
            txtNetworkOperatordis.setTextSize(16);
            txtNetworkOperatordis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtNetworkOperator.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtNetworkOperator);
            llayout.addView(txtNetworkOperatordis);
            llayout.addView(v12);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    txtNetworkOperatordis.setText(R.string.GrantPermission);
                    txtNetworkOperatordis.setOnClickListener(view -> ActivityCompat.requestPermissions(Objects.requireNonNull(getActivity()), new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_PHONE_STATE));
                } else {
                    txtNetworkOperatordis.setText(tm.getNetworkOperatorName());
                }
            } else {
                txtNetworkOperatordis.setText(tm.getNetworkOperatorName());
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rootView;
    }

    @SuppressLint("HardwareIds")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        try {
            switch (requestCode) {
                case REQUEST_PHONE_STATE: {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                        txtNetworkOperatordis.setText(tm.getNetworkOperatorName());
                    } else {
                        Toast.makeText(getContext(), "Permiso Denegado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } catch (SecurityException ex) {
            ex.printStackTrace();
        }
    }
}
