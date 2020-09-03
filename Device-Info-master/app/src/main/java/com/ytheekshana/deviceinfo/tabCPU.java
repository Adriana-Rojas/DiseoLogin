package com.ytheekshana.deviceinfo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class tabCPU extends Fragment {
    private TextView txtCPUUsagedis;
    private CPUUsage cu;
    private TextView txtCore[];
    private String cUsage;
    private Timer timer;
    static int cpuuso;
    //static

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tabcpu, container, false);
        LinearLayout llayout = rootView.findViewById(R.id.llayout);
        cu = new CPUUsage();

        try {
            int textDisColor = Eficiencia.themeColor;
            int lineColor = GetDetails.getThemeColor(Objects.requireNonNull(getContext()), R.attr.colorButtonNormal);



            TextView txtCPUHardware = new TextView(getContext());
            TextView txtCPUHardwaredis = new TextView(getContext());
            View v2 = new View(getContext());
            v2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v2.setBackgroundColor(lineColor);
            txtCPUHardware.setText("Hardware del CPU");
            txtCPUHardware.setTypeface(null, Typeface.BOLD);
            txtCPUHardware.setTextSize(16);
            txtCPUHardware.setPadding(0, 15, 0, 0);
            txtCPUHardwaredis.setPadding(0, 0, 0, 15);
            txtCPUHardwaredis.setTextColor(textDisColor);
            txtCPUHardwaredis.setTextSize(16);
            txtCPUHardwaredis.setText(SplashActivity.processorHardware);
            txtCPUHardwaredis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtCPUHardware.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtCPUHardware);
            llayout.addView(txtCPUHardwaredis);
            llayout.addView(v2);


            TextView txtCPUCores = new TextView(getContext());
            final TextView txtCPUCoresdis = new TextView(getContext());
            View v4 = new View(getContext());
            v4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v4.setBackgroundColor(lineColor);
            txtCPUCores.setText("Nucleos");
            txtCPUCores.setTypeface(null, Typeface.BOLD);
            txtCPUCores.setTextSize(16);
            txtCPUCores.setPadding(0, 15, 0, 0);
            txtCPUCoresdis.setPadding(0, 0, 0, 15);
            txtCPUCoresdis.setTextColor(textDisColor);
            txtCPUCoresdis.setTextSize(16);
            txtCPUCoresdis.setText(String.valueOf(Runtime.getRuntime().availableProcessors()));
            txtCPUCoresdis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtCPUCores.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtCPUCores);
            llayout.addView(txtCPUCoresdis);
            llayout.addView(v4);

            TextView txtCPUFrequency = new TextView(getContext());
            TextView txtCPUFrequencydis = new TextView(getContext());
            View v5 = new View(getContext());
            v5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v5.setBackgroundColor(lineColor);
            txtCPUFrequency.setText("CPU Frecuencia");
            txtCPUFrequency.setTypeface(null, Typeface.BOLD);
            txtCPUFrequency.setTextSize(16);
            txtCPUFrequency.setPadding(0, 15, 0, 0);
            txtCPUFrequencydis.setPadding(0, 0, 0, 15);
            txtCPUFrequencydis.setTextColor(textDisColor);
            txtCPUFrequencydis.setTextSize(16);
            String frequ = String.format(Locale.US, "%.0f", SplashActivity.cpuMinFreq) + " MHz - " + String.format(Locale.US, "%.0f", SplashActivity.cpuMaxFreq) + " MHz";/////////////////
            txtCPUFrequencydis.setText(frequ);
            txtCPUFrequencydis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtCPUFrequency.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtCPUFrequency);
            llayout.addView(txtCPUFrequencydis);
            llayout.addView(v5);

            TextView txtRunningCPU = new TextView(getContext());
            View v6 = new View(getContext());
            v6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v6.setBackgroundColor(lineColor);
            txtRunningCPU.setText("CPUs Corriendo");
            txtRunningCPU.setTypeface(null, Typeface.BOLD);
            txtRunningCPU.setTextSize(16);
            txtRunningCPU.setPadding(0, 15, 0, 0);
            txtRunningCPU.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtRunningCPU);

            txtCore = new TextView[Runtime.getRuntime().availableProcessors()];
            for (int corecount = 0; corecount < Runtime.getRuntime().availableProcessors(); corecount++) {
                txtCore[corecount] = new TextView(getContext());
                txtCore[corecount].setPadding(0, 0, 0, 15);
                txtCore[corecount].setTextColor(textDisColor);
                txtCore[corecount].setTextSize(16);
                txtCore[corecount].setText(String.valueOf(corecount));
                txtCore[corecount].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                llayout.addView(txtCore[corecount]);
            }
            llayout.addView(v6);


            TextView txtCPUUsage = new TextView(getContext());
            txtCPUUsagedis = new TextView(getContext());
            View v7 = new View(getContext());
            v7.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v7.setBackgroundColor(lineColor);
            txtCPUUsage.setText("Uso de CPU");
            txtCPUUsage.setTypeface(null, Typeface.BOLD);
            txtCPUUsage.setTextSize(16);
            txtCPUUsage.setPadding(0, 15, 0, 0);
            txtCPUUsagedis.setPadding(0, 0, 0, 15);
            txtCPUUsagedis.setTextColor(textDisColor);
            txtCPUUsagedis.setTextSize(16);
            txtCPUUsagedis.setText("50");
            txtCPUUsagedis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtCPUUsage.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtCPUUsage);
            llayout.addView(txtCPUUsagedis);
            llayout.addView(v7);



            TextView txtGPUVendor = new TextView(getContext());
            TextView txtGPUVendordis = new TextView(getContext());
            View v9 = new View(getContext());
            v9.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            v9.setBackgroundColor(lineColor);
            txtGPUVendor.setText(R.string.GPUVendor);
            txtGPUVendor.setTypeface(null, Typeface.BOLD);
            txtGPUVendor.setTextSize(16);
            txtGPUVendor.setPadding(0, 15, 0, 0);
            txtGPUVendordis.setPadding(0, 0, 0, 15);
            txtGPUVendordis.setTextColor(textDisColor);
            txtGPUVendordis.setTextSize(16);
            txtGPUVendordis.setText(SplashActivity.gpuVendor);
            txtGPUVendordis.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            txtGPUVendor.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llayout.addView(txtGPUVendor);
            llayout.addView(txtGPUVendordis);
            llayout.addView(v9);



            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                  //  cUsage = String.valueOf(cu.getTotalCpuUsage()) + " %";

                    for (int corecount = 0; corecount < Runtime.getRuntime().availableProcessors(); corecount++) {
                        try {
                            int usocpu ;
                            double currentFreq;
                            RandomAccessFile readerCurFreq;
                            readerCurFreq = new RandomAccessFile("/sys/devices/system/cpu/cpu" + corecount + "/cpufreq/scaling_cur_freq", "r");
                            String curfreg = readerCurFreq.readLine();
                            currentFreq = Double.parseDouble(curfreg) / 1000;
                            readerCurFreq.close();
                            final String settextcorecores = "\t\tNucleo " + corecount + "       " + (int) currentFreq + " Mhz";//////////////////////
                            final int finalCorecount1 = corecount;
                            txtCore[corecount].post(() -> txtCore[finalCorecount1].setText(settextcorecores));

                            if(corecount == 0){
                                usocpu=(int)((currentFreq/SplashActivity.cpuMaxFreq)*100);
                                cUsage = (usocpu) + " %";
                                //cpuuso=Integer.parseInt(cUsage);
                            }

                        } catch (Exception ex) {
                            final String settextcorecoresEX = "\t\tNucleo " + corecount + "       " + "Idle";
                            final int finalCorecount = corecount;
                            txtCore[corecount].post(() -> txtCore[finalCorecount].setText(settextcorecoresEX));
                        }
                    }
                    txtCPUUsagedis.post(() -> txtCPUUsagedis.setText(cUsage));

                }
            }, 0, 1000);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            timer.cancel();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}