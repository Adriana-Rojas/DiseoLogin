package com.ytheekshana.deviceinfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.telephony.TelephonyManager;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class GetDetails {

    @ColorInt
    static int getThemeColor(@NonNull final Context context, @AttrRes final int attributeColor) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attributeColor, value, true);
        return value.data;
    }

    static String GetFromBuildProp(String PropKey) {
        Process p;
        String propvalue = "";
        try {
            p = new ProcessBuilder("/system/bin/getprop", PropKey).redirectErrorStream(true).start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                propvalue = line;
            }
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propvalue;
    }

    static String GetOSNameAdvanced() {
        String OSName;
        switch (Build.VERSION.SDK_INT) {
            case 21:
                OSName = "Lollipop";
                break;
            case 22:
                OSName = "Lollipop MR1";
                break;
            case 23:
                OSName = "Marshmallow";
                break;
            case 24:
                OSName = "Nougat";
                break;
            case 25:
                OSName = "Nougat MR1";
                break;
            case 26:
                OSName = "Oreo";
                break;
            case 27:
                OSName = "Oreo MR1";
                break;
            case 28:
                OSName = "Android Pie";
                break;
            default:
                OSName = "Desconocido";
        }
        return OSName;
    }

    static String GetOSReleaseDate() {
        String OSReleaseDate;
        switch (Build.VERSION.SDK_INT) {
            case 11:
            case 12:
            case 13:
                OSReleaseDate = "February 22, 2011";
                break;
            case 14:
            case 15:
                OSReleaseDate = "October 18, 2011";
                break;
            case 16:
            case 17:
            case 18:
                OSReleaseDate = "July 9, 2012";
                break;
            case 19:
                OSReleaseDate = "October 31, 2013";
                break;
            case 21:
            case 22:
                OSReleaseDate = "November 12, 2014";
                break;
            case 23:
                OSReleaseDate = "October 5, 2015";
                break;
            case 24:
            case 25:
                OSReleaseDate = "August 22, 2016";
                break;
            case 26:
            case 27:
                OSReleaseDate = "August 21, 2017";
                break;
            case 28:
                OSReleaseDate = "August 09, 2018";
                break;
            default:
                OSReleaseDate = "Desconocido";
        }
        return OSReleaseDate;
    }

    static String GetOSName(int sdk) {
        String OSName;
        switch (sdk) {
            case 11:
            case 12:
            case 13:
                OSName = "HoneyComb";
                break;
            case 14:
            case 15:
                OSName = "Ice Cream Sandwich";
                break;
            case 16:
            case 17:
            case 18:
                OSName = "Jelly Bean";
                break;
            case 19:
                OSName = "KitKat";
                break;
            case 21:
            case 22:
                OSName = "Lollipop";
                break;
            case 23:
                OSName = "Marshmallow";
                break;
            case 24:
            case 25:
                OSName = "Nougat";
                break;
            case 26:
            case 27:
                OSName = "Oreo";
                break;
            case 28:
                OSName = "Pie";
                break;
            default:
                OSName = "Desconocido";
        }
        return OSName;
    }

    static String getProcessor() {
        String Final = "";
        try {
            StringBuilder sb = new StringBuilder();
            if (new File("/proc/cpuinfo").exists()) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                    String aLine;
                    while ((aLine = br.readLine()) != null) {
                        String _append = aLine + "ndeviceinfo";
                        sb.append(_append);
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String cpuinfo[] = sb.toString().split(":");
                for (int a = 0; a < cpuinfo.length; a++) {
                    if (cpuinfo[a].toLowerCase().contains("processor")) {
                        int getlastindex = cpuinfo[a + 1].indexOf("ndeviceinfo");
                        Final = cpuinfo[a + 1].substring(1, getlastindex);
                        break;
                    }
                }
                if (Final.equals("0") || Final.equals("")) {
                    for (int a = 0; a < cpuinfo.length; a++) {
                        if (cpuinfo[a].contains("model name")) {
                            int getlastindex = cpuinfo[a + 1].indexOf("ndeviceinfo");
                            Final = cpuinfo[a + 1].substring(1, getlastindex);
                            break;
                        }
                    }
                }
                if (Final.equals("") || Final.equals("0")) {
                    Final = "Desconocido";
                }
            } else {
                Final = "Desconocido";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Final;
    }

    static String getProcessorHardware() {
        String Final = "";
        try {
            StringBuilder sb = new StringBuilder();
            if (new File("/proc/cpuinfo").exists()) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                    String aLine;
                    while ((aLine = br.readLine()) != null) {
                        String _append = aLine + "ndeviceinfo";
                        sb.append(_append);
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String cpuinfo[] = sb.toString().split(":");
                for (int a = 0; a < cpuinfo.length; a++) {
                    if (cpuinfo[a].toLowerCase().contains("hardware")) {
                        int getlastindex = cpuinfo[a + 1].indexOf("ndeviceinfo");
                        Final = cpuinfo[a + 1].substring(1, getlastindex);
                        break;
                    } else {
                        Final = "Desconocido";
                    }
                }
            } else {
                Final = "Desconocido";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Final;
    }

    static String getCPUGoverner() {
        String aLine = "";
        if (new File("/sys/devices/system/cpu/cpu0/cpufreq/scaling_governor").exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(new File("/sys/devices/system/cpu/cpu0/cpufreq/scaling_governor")));
                aLine = br.readLine();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return aLine;
    }

    static String getTime(long millis) {
        if (millis < 0) {
            throw new IllegalArgumentException("¡La duración debe ser mayor que cero!");
        }
        return String.format(Locale.US, "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }

    static String getDisplaySize(Activity activity) {
        double x = 0, y = 0;
        int mWidthPixels, mHeightPixels;
        try {
            WindowManager windowManager = activity.getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            Point realSize = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
            mWidthPixels = realSize.x;
            mHeightPixels = realSize.y;
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            x = Math.pow(mWidthPixels / dm.xdpi, 2);
            y = Math.pow(mHeightPixels / dm.ydpi, 2);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return String.format(Locale.US, "%.2f", Math.sqrt(x + y));
    }





    static boolean isRooted() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys") || canExecuteCommand("/system/xbin/which su") || canExecuteCommand("/system/bin/which su") || canExecuteCommand("which su");
    }

    private static boolean canExecuteCommand(String command) {
        try {
            int exitValue = Runtime.getRuntime().exec(command).waitFor();
            return exitValue == 0;
        } catch (Exception e) {
            return false;
        }
    }

    static String getWifiMacAddress() {
        try {
            String interfaceName = "wlan0";
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                if (!intf.getName().equalsIgnoreCase(interfaceName)) {
                    continue;
                }
                byte[] mac = intf.getHardwareAddress();
                if (mac == null) {
                    return "";
                }
                StringBuilder buf = new StringBuilder();
                for (byte aMac : mac) {
                    buf.append(String.format("%02X:", aMac));
                }
                if (buf.length() > 0) {
                    buf.deleteCharAt(buf.length() - 1);
                }
                return buf.toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    @SuppressLint("HardwareIds")
    static String getBluetoothMac(Context context) {
        String result = "";
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                result = android.provider.Settings.Secure.getString(context.getContentResolver(),
                        "bluetooth_address");
            } else {
                BluetoothAdapter bta = BluetoothAdapter.getDefaultAdapter();
                result = (bta != null) ? bta.getAddress() : "";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    static int getBatteryCapacity(Context context) {
        double batteryCapacity = 0;
        final String POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile";
        try {
            Object mPowerProfile = Class.forName(POWER_PROFILE_CLASS).getConstructor(Context.class).newInstance(context);
            batteryCapacity = (Double) Class.forName(POWER_PROFILE_CLASS).getMethod("getAveragePower", java.lang.String.class).invoke(mPowerProfile, "battery.capacity");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (int) batteryCapacity;
    }

    static String[] getStorageDirectories(Context context) {
        String[] storageDirectories;
        String rawSecondaryStoragesStr = System.getenv("SECONDARY_STORAGE");


        List<String> results = new ArrayList<>();
        File[] externalDirs = context.getExternalFilesDirs(null);
        for (File file : externalDirs) {
            String path = file.getPath().split("/Android")[0];
            if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && Environment.isExternalStorageRemovable(file))
                    || rawSecondaryStoragesStr != null && rawSecondaryStoragesStr.contains(path)) {
                results.add(path);
            }
        }
        storageDirectories = results.toArray(new String[0]);

        return storageDirectories;
    }

    static Double getAndroidVersion(int sdk) {
        double Version;
        switch (sdk) {
            case 10:
                Version = 2.3;
                break;
            case 11:
                Version = 3.0;
                break;
            case 12:
                Version = 3.1;
                break;
            case 13:
                Version = 3.2;
                break;
            case 14:
            case 15:
                Version = 4.0;
                break;
            case 16:
                Version = 4.1;
                break;
            case 17:
                Version = 4.2;
                break;
            case 18:
                Version = 4.3;
                break;
            case 19:
                Version = 4.4;
                break;
            case 21:
                Version = 5.0;
                break;
            case 22:
                Version = 5.1;
                break;
            case 23:
                Version = 6.0;
                break;
            case 24:
                Version = 7.0;
                break;
            case 25:
                Version = 7.1;
                break;
            case 26:
                Version = 8.0;
                break;
            case 27:
                Version = 8.1;
                break;
            case 28:
                Version = 9.0;
                break;
            default:
                Version = 0.0;
                break;
        }
        return Version;
    }

    static String GetSELinuxMode() {
        StringBuilder output = new StringBuilder();
        Process p;
        try {
            p = Runtime.getRuntime().exec("getenforce");
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Not Supported";
        }
        String response = output.toString();
        if ("Enforcing".equals(response)) {
            return "Enforcing";
        } else if ("Permissive".equals(response)) {
            return "Permissive";
        } else {
            return "Unable to determine";
        }
    }



    public static int getDarkColor(Context context, int color) {
        List<String> colorThemeColor = Arrays.asList(context.getResources().getStringArray(R.array.accent_colors));
        List<String> colorThemeColorDark = Arrays.asList(context.getResources().getStringArray(R.array.accent_colors_700));
        String getHex = String.format("#%02x%02x%02x", Color.red(color), Color.green(color), Color.blue(color));
        return Color.parseColor(colorThemeColorDark.get(colorThemeColor.indexOf(getHex)));
    }

    static int getDarkColor2(Context context, int color) {
        List<String> colorThemeColor = Arrays.asList(context.getResources().getStringArray(R.array.accent_colors));
        List<String> colorThemeColor2 = Arrays.asList(context.getResources().getStringArray(R.array.accent_colors_2));
        String getHex = String.format("#%02x%02x%02x", Color.red(color), Color.green(color), Color.blue(color));
        return Color.parseColor(colorThemeColor2.get(colorThemeColor.indexOf(getHex)));
    }

    static void copy(File src, File dst) {
        try (InputStream in = new FileInputStream(src)) {
            try (OutputStream out = new FileOutputStream(dst)) {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    static String getMP(Size size, int decimalPlaces) {
        float mp = (size.getWidth() * size.getHeight()) / 1000000f;
        if (decimalPlaces == 1) {
            return String.format(Locale.US, "%.1f", mp) + " MP";
        } else if (decimalPlaces == 2) {
            return String.format(Locale.US, "%.2f", mp) + " MP";
        } else {
            return String.format(Locale.US, "%.2f", mp) + " MP";
        }
    }

}
