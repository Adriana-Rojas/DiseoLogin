package com.ytheekshana.deviceinfo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.cardview.widget.CardView;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class tabDashboard extends Fragment {
    private TextView txtUsedRam, txtFreeRam, txtBatteryPerce, txtBatteryStatus, txtCPUPerce;
    private ProgressBar ProgressBarBattery, ProgressBarCPU;
    private int startExStorage, acumuladorram=0,acumuladorcpu=0,acumuladorbateria=0;
    private CPUUsage cu2;
    private String cUsage;
    private Timer timercUsage;
    private ArcProgress arcProgressRam;
    private LineChart lineChartRam;
    private float usedRam = 0;
    private Handler handlerChart, handlerRam;
    private Runnable runnableChart;
    private Timer timer;
    private  int usocpu ;
    Button btn_start,btn_stop,btn_reset;
    static Chronometer chronometro;
    static int  consumoramtotal=0, consumorammax=0, consumocputotal=0, consumocpumax=0, iniciobateria=0, finalbateria=0;
    Boolean correr=false;
    long detenerse;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tabdashboard, container, false);
        ///////

        btn_start=(Button) rootView.findViewById(R.id.btn_start);
        btn_stop=(Button) rootView.findViewById(R.id.btn_stop);
        btn_reset=(Button) rootView.findViewById(R.id.btn_reset);
        chronometro=rootView.findViewById(R.id.chronometro);/////
        correr=false;
        startChronometro();
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startChronometro();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopChronometro();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetChronometro();
            }
        });

        Button btnLanzarActivity = (Button) rootView.findViewById(R.id.siguienteeficiencia);
        btnLanzarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Select_Apk.class);//Eficienciados
                startActivity(intent);
            }
        });
        ///
        try {

            ImageView imgROM = rootView.findViewById(R.id.imageROM);
            ImageView imgInStorage = rootView.findViewById(R.id.imageInStorage);
            ImageView imgExStorage = rootView.findViewById(R.id.imageExStorage);
            ImageView imgBattery = rootView.findViewById(R.id.imageBattery);
            ImageView imgCPU = rootView.findViewById(R.id.imageCPU);
            ImageView imgApps = rootView.findViewById(R.id.imageApps);

            ColorFilter accentFilter = new LightingColorFilter(Color.BLACK, Eficiencia.themeColor);
            imgROM.setColorFilter(accentFilter);
            imgInStorage.setColorFilter(accentFilter);
            imgExStorage.setColorFilter(accentFilter);
            imgBattery.setColorFilter(accentFilter);
            imgCPU.setColorFilter(accentFilter);
            imgApps.setColorFilter(accentFilter);

            IntentFilter batteryIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Context batteryContext = Objects.requireNonNull(getActivity()).getApplicationContext();
            batteryContext.registerReceiver(batteryBroadcastReceiver, batteryIntentFilter);
            cu2 = new CPUUsage();

            CardView cardviewRam = rootView.findViewById(R.id.cardviewRam);
            cardviewRam.setCardBackgroundColor(Eficiencia.themeColor);

            final CardView cardRom = rootView.findViewById(R.id.cardviewRom);
            final CardView cardInternalStorage = rootView.findViewById(R.id.cardviewInStorage);
            final CardView cardExternalStorage = rootView.findViewById(R.id.cardviewExStorage);
            final CardView cardBattery = rootView.findViewById(R.id.cardviewBattery);
            final CardView cardCpu = rootView.findViewById(R.id.cardviewCPU);
            final CardView cardApps = rootView.findViewById(R.id.cardviewApp);

            txtUsedRam = rootView.findViewById(R.id.txtUsedRam);
            txtFreeRam = rootView.findViewById(R.id.txtFreeRam);
            TextView txtTotalRam = rootView.findViewById(R.id.txtTotalRam);
            TextView txtRomPerce = rootView.findViewById(R.id.txtROMPerc);
            TextView txtRomStatus = rootView.findViewById(R.id.txtROMStatus);
            txtBatteryPerce = rootView.findViewById(R.id.txtBatteryPerc);
            txtBatteryStatus = rootView.findViewById(R.id.txtBatteryStatus);
            TextView txtInStoragePerce = rootView.findViewById(R.id.txtInStoragePerc);
            TextView txtInStorageStatus = rootView.findViewById(R.id.txtInStorageStatus);
            TextView txtExStoragePerce = rootView.findViewById(R.id.txtExStoragePerc);
            TextView txtExStorageStatus = rootView.findViewById(R.id.txtExStorageStatus);
            txtCPUPerce = rootView.findViewById(R.id.txtCPUPerc);
            TextView txtCPUStatus = rootView.findViewById(R.id.txtCPUStatus);
            TextView txtAppCount = rootView.findViewById(R.id.txtAppCount);

            lineChartRam = rootView.findViewById(R.id.lineChartRam);
            lineChartRam.setDrawGridBackground(false);
            lineChartRam.getDescription().setEnabled(false);
            lineChartRam.setBackgroundColor(Color.TRANSPARENT);
            LineData data = new LineData();
            data.setValueTextColor(Color.WHITE);
            lineChartRam.setData(data);
            lineChartRam.getLegend().setEnabled(false);
            lineChartRam.setTouchEnabled(false);

            XAxis xl = lineChartRam.getXAxis();
            xl.setEnabled(false);

            YAxis leftAxis = lineChartRam.getAxisLeft();
            leftAxis.setEnabled(false);

            YAxis rightAxis = lineChartRam.getAxisRight();
            rightAxis.setLabelCount(3);
            rightAxis.setTextColor(Color.WHITE);
            rightAxis.setDrawGridLines(false);
            rightAxis.setTextSize(9);

            arcProgressRam = rootView.findViewById(R.id.arcProgressRam);
            arcProgressRam.setUnfinishedStrokeColor(Eficiencia.themeColorDark);

            ProgressBar progressBarRom = rootView.findViewById(R.id.progressRom);
            DrawableCompat.setTint(progressBarRom.getProgressDrawable(), Eficiencia.themeColor);

            ProgressBarBattery = rootView.findViewById(R.id.progressBattery);
            DrawableCompat.setTint(ProgressBarBattery.getProgressDrawable(), Eficiencia.themeColor);

            ProgressBar progressBarInStorage = rootView.findViewById(R.id.progressInStorage);
            DrawableCompat.setTint(progressBarInStorage.getProgressDrawable(), Eficiencia.themeColor);

            ProgressBar progressBarExStorage = rootView.findViewById(R.id.progressExStorage);
            DrawableCompat.setTint(progressBarExStorage.getProgressDrawable(), Eficiencia.themeColor);

            ProgressBarCPU = rootView.findViewById(R.id.progressCPU);
            DrawableCompat.setTint(ProgressBarCPU.getProgressDrawable(), Eficiencia.themeColor);

            int startCPU = cu2.getTotalCpuUsage();

            animateTextView(SplashActivity.numberOfInstalledApps, txtAppCount);

            int startRAM = (int) SplashActivity.usedRamPercentage;
            txtUsedRam.setText(String.valueOf((int) SplashActivity.usedRam));
            txtFreeRam.setText(String.valueOf((int) SplashActivity.availableRam));
            usedRam = (float) SplashActivity.usedRam;

            String totalRamSpan = "RAM - " + (int) SplashActivity.totalRam + " MB Total";
            SpannableString ssTotalRam = new SpannableString(totalRamSpan);
            ssTotalRam.setSpan(new RelativeSizeSpan(0.7f), totalRamSpan.length() - 8, totalRamSpan.length(), 0); // set size
            txtTotalRam.setText(ssTotalRam);

            int startROM = (int) SplashActivity.usedRomPercentage;
            String setRom = "Libre: " + String.format(Locale.US, "%.1f", SplashActivity.availableRom) + " GB,  Total: " + String.format(Locale.US, "%.1f", SplashActivity.totalRom) + " GB";
            txtRomStatus.setText(setRom);
            String storage_percentageRom = String.valueOf((int) SplashActivity.usedRomPercentage) + "%";
            txtRomPerce.setText(storage_percentageRom);

            int startInStorage = (int) SplashActivity.usedInternalPercentage;
            String setInStorage = "Libre: " + String.format(Locale.US, "%.1f", SplashActivity.availableInternalStorage) + " GB,  Total: " + String.format(Locale.US, "%.1f", SplashActivity.totalInternalStorage) + " GB";
            txtInStorageStatus.setText(setInStorage);
            String in_storage_percentage = String.valueOf((int) SplashActivity.usedInternalPercentage) + "%";
            txtInStoragePerce.setText(in_storage_percentage);

            if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED) && ContextCompat.getExternalFilesDirs(Objects.requireNonNull(getContext()), null).length >= 2) {
                cardExternalStorage.setVisibility(View.VISIBLE);
                startExStorage = (int) SplashActivity.usedExternalPercentage;
                String setExStorage = "Libre: " + String.format(Locale.US, "%.1f", SplashActivity.availableExternalStorage) + " GB,  Total: " + String.format(Locale.US, "%.1f", SplashActivity.totalExternalStorage) + " GB";
                txtExStorageStatus.setText(setExStorage);
                String ex_storage_percentage = String.valueOf((int) SplashActivity.usedExternalPercentage) + "%";
                txtExStoragePerce.setText(ex_storage_percentage);
            } else {
                cardExternalStorage.setVisibility(View.GONE);
            }

            final MemoryInfo memoryInfo = new MemoryInfo(getActivity(), getContext());
            handlerRam = new Handler();
            Runnable runnable = new Runnable() {
                public void run() {
                    memoryInfo.Ram();
                    arcProgressRam.setProgress((int) memoryInfo.getUsedRamPercentage());
                    acumuladorram++;
                   // Log.d("myTag", "acumulador ="+ acumuladorram);
                   // Log.d("myTag", "actual ="+ (int) memoryInfo.getUsedRamPercentage());
                    consumoramtotal=consumoramtotal+(int) memoryInfo.getUsedRamPercentage();
                   // Log.d("myTag", "total ="+ consumoramtotal);
                    if (acumuladorram==1){
                        consumorammax=consumorammax+(int) memoryInfo.getUsedRamPercentage();
                    }else if((int) memoryInfo.getUsedRamPercentage()>consumorammax){
                            consumorammax=(int) memoryInfo.getUsedRamPercentage();
                        }
                  //  Log.d("myTag", " max ="+ consumorammax);
                    usedRam = (float) memoryInfo.getUsedRam();
                    SplashActivity.usedRam = memoryInfo.getUsedRam();
                    txtUsedRam.setText(String.valueOf((int) memoryInfo.getUsedRam()));
                    txtFreeRam.setText(String.valueOf((int) memoryInfo.getAvailableRam()));
                    handlerRam.postDelayed(this, 1000);
                }
            };
            handlerRam.postDelayed(runnable, 1000);

            handlerChart = new Handler();
            runnableChart = new Runnable() {
                public void run() {
                    addEntry();
                    handlerChart.postDelayed(this, 1000);
                }
            };
            handlerChart.postDelayed(runnableChart, 0);

            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                    for (int corecount = 0; corecount < Runtime.getRuntime().availableProcessors(); corecount++) {
                        try {
                            double currentFreq;
                            RandomAccessFile readerCurFreq;
                            readerCurFreq = new RandomAccessFile("/sys/devices/system/cpu/cpu" + corecount + "/cpufreq/scaling_cur_freq", "r");
                            String curfreg = readerCurFreq.readLine();
                            currentFreq = Double.parseDouble(curfreg) / 1000;
                            readerCurFreq.close();

                            if(corecount == 0){
                                usocpu = (int) ((currentFreq / SplashActivity.cpuMaxFreq) * 100);
                                cUsage = (usocpu) + " %";
                            }

                        } catch (Exception ex) {
                            final String settextcorecoresEX = "\t\tNucleo " + corecount + "       " + "Idle";
                            final int finalCorecount = corecount;
                        }
                    }
                }
            }, 0, 1000);

            timercUsage = new Timer();
            timercUsage.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    txtCPUPerce.post(() -> txtCPUPerce.setText(cUsage));
                    //
                    acumuladorcpu++;
                   // Log.d("myTag", "acumulador ="+ acumuladorcpu);
                  //  Log.d("myTag", "actual ="+ usocpu);
                    consumocputotal=consumocputotal+usocpu;
                  //  Log.d("myTag", "total ="+ consumocputotal);
                    if (acumuladorcpu==1){
                        consumocpumax=consumocpumax+usocpu;
                    }else if(usocpu>consumocpumax){
                        consumocpumax=usocpu;
                    }
                   // Log.d("myTag", " max ="+ consumocpumax);
                    //
                    ProgressBarCPU.post(() -> ProgressBarCPU.setProgress(usocpu * 10));
                }
            }, 1000, 1000);

            String cpuStatus = "Nucleos: " + Runtime.getRuntime().availableProcessors() + ",  Frecuencia max: " + (int) SplashActivity.cpuMaxFreq + " MHz";
            txtCPUStatus.setText(cpuStatus);

            ObjectAnimator arcProgressAnimatorRAM = ObjectAnimator.ofInt(arcProgressRam, "progress", 0, startRAM);
            arcProgressAnimatorRAM.setDuration(800);
            arcProgressAnimatorRAM.setInterpolator(new DecelerateInterpolator());
            arcProgressAnimatorRAM.start();

            ObjectAnimator progressAnimatorROM = ObjectAnimator.ofInt(progressBarRom, "progress", 0, startROM * 10);
            progressAnimatorROM.setDuration(800);
            progressAnimatorROM.start();

            ObjectAnimator progressAnimatorInStorage = ObjectAnimator.ofInt(progressBarInStorage, "progress", 0, startInStorage * 10);
            progressAnimatorInStorage.setDuration(800);
            progressAnimatorInStorage.start();

            ObjectAnimator progressAnimatorExStorage = ObjectAnimator.ofInt(progressBarExStorage, "progress", 0, startExStorage * 10);
            progressAnimatorExStorage.setDuration(800);
            progressAnimatorExStorage.start();

            ObjectAnimator progressAnimatorCPU = ObjectAnimator.ofInt(ProgressBarCPU, "progress", 0, startCPU * 10);
            progressAnimatorCPU.setDuration(800);
            progressAnimatorCPU.start();

            final com.ytheekshana.deviceinfo.BounceInterpolator bounceInterpolator = new com.ytheekshana.deviceinfo.BounceInterpolator(0.2, 20);
            cardRom.setOnClickListener(v -> {
                Animation animRom = AnimationUtils.loadAnimation(getContext(), R.anim.bounce_dash);
                animRom.setInterpolator(bounceInterpolator);
                cardRom.startAnimation(animRom);
            });
            cardInternalStorage.setOnClickListener(v -> {
                Animation animInSto = AnimationUtils.loadAnimation(getContext(), R.anim.bounce_dash);
                animInSto.setInterpolator(bounceInterpolator);
                cardInternalStorage.startAnimation(animInSto);
            });
            cardExternalStorage.setOnClickListener(v -> {
                Animation animExSto = AnimationUtils.loadAnimation(getContext(), R.anim.bounce_dash);
                animExSto.setInterpolator(bounceInterpolator);
                cardExternalStorage.startAnimation(animExSto);
            });
            cardBattery.setOnClickListener(v -> {
                Animation animBattery = AnimationUtils.loadAnimation(getContext(), R.anim.bounce_dash);
                animBattery.setInterpolator(bounceInterpolator);
                cardBattery.startAnimation(animBattery);
            });
            cardCpu.setOnClickListener(v -> {
                Animation animCpu = AnimationUtils.loadAnimation(getContext(), R.anim.bounce_dash);
                animCpu.setInterpolator(bounceInterpolator);
                cardCpu.startAnimation(animCpu);
            });
           
            cardApps.setOnClickListener(v -> {
                Animation animApps = AnimationUtils.loadAnimation(getContext(), R.anim.bounce_dash);
                animApps.setInterpolator(bounceInterpolator);
                cardApps.startAnimation(animApps);
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rootView;
    }
    private void resetChronometro() {
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse=0;
    }

    private void stopChronometro() {
        if (correr){
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            correr=false;
        }
    }

    private void startChronometro() {
        if(!correr){
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
            chronometro.start();
            correr=true;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            timercUsage.cancel();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private BroadcastReceiver batteryBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final int batlevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int voltage = intent.getIntExtra("voltaje", 0);
            int temperature = (intent.getIntExtra("temperature", 0)) / 10;
            String setBattery = "Voltaje: " + voltage + "mV,  Temperatura: " + temperature + " \u2103";
            txtBatteryStatus.setText(setBattery);
            String battery_percentage = Integer.toString(batlevel) + "%";
            //
            acumuladorbateria++;
             Log.d("myTag", "acumulador ="+ acumuladorbateria);

            if (acumuladorbateria==2){
                iniciobateria=batlevel;
                Log.d("myTag", "inicio ="+ iniciobateria);
            }
            if(iniciobateria<batlevel){
                finalbateria=batlevel;
                Log.d("myTag", " final ="+ finalbateria);
            }

            //
            txtBatteryPerce.setText(battery_percentage);

            ObjectAnimator progressAnimatorBattery = ObjectAnimator.ofInt(ProgressBarBattery, "progress", 0, batlevel * 10);
            progressAnimatorBattery.setDuration(800);
            progressAnimatorBattery.start();

            ProgressBarBattery.setProgress(batlevel);
        }
    };

    private void animateTextView(int finalValue, final TextView textview) {

        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, finalValue);
        valueAnimator.setDuration(800);
        valueAnimator.addUpdateListener(valueAnimator1 -> textview.setText(valueAnimator1.getAnimatedValue().toString()));
        valueAnimator.start();
    }

    private void addEntry() {
        LineData data = lineChartRam.getData();
        if (data != null) {

            ILineDataSet set = data.getDataSetByIndex(0);
            if (set == null) {
                set = createSet();
                data.addDataSet(set);
            }
            data.addEntry(new Entry(set.getEntryCount(), usedRam), 0);
            data.notifyDataChanged();
            lineChartRam.notifyDataSetChanged();
            lineChartRam.setVisibleXRangeMaximum(20);
            lineChartRam.moveViewToX(data.getEntryCount());
        }
    }

    private LineDataSet createSet() {
        LineDataSet set = new LineDataSet(null, "Dynamic Data");
        set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set.setColor(Color.WHITE);
        set.setDrawCircles(false);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setLineWidth(2f);
        set.setDrawValues(false);
        return set;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (runnableChart != null) {
            handlerChart.postDelayed(runnableChart, 0);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (runnableChart != null) {
            handlerChart.removeCallbacks(runnableChart);
        }
    }
}


