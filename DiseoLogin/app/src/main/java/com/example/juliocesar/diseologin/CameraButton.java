package com.example.juliocesar.diseologin;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.nex3z.togglebuttongroup.button.CompoundToggleButton;

import java.util.Objects;

public class CameraButton extends CompoundToggleButton {
    String mp, resolution, flength, cameraId;
    TextView txtMp, txtResolution, txtFlength, txtCameraId;
    CardView cardViewButton, cardViewActivated;

    public CameraButton(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Objects.requireNonNull(inflater).inflate(R.layout.camerabutton, this, true);
        txtMp = findViewById(R.id.txtMP);
        txtResolution = findViewById(R.id.txtResolution);
        txtFlength = findViewById(R.id.txtFlength);
        txtCameraId = findViewById(R.id.txtCameraId);
        cardViewButton = findViewById(R.id.cardviewCamera);
        cardViewActivated = findViewById(R.id.cardViewActivated);
        cardViewButton.setCardBackgroundColor(Eficiencia.themeColor);
        cardViewActivated.setCardBackgroundColor(Eficiencia.themeColor);
    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        if (checked) {
            if (Eficiencia.isDarkmode) {
                animateButtonBar(Eficiencia.themeColor, Color.parseColor("#EEEEEE"));
            } else {
                animateButtonBar(Eficiencia.themeColor, Color.parseColor("#2F2F2F"));
            }
        } else {
            if (Eficiencia.isDarkmode) {
                animateButtonBar(Color.parseColor("#EEEEEE"), Eficiencia.themeColor);
            } else {
                animateButtonBar(Color.parseColor("#2F2F2F"), Eficiencia.themeColor);
            }
        }
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
        txtResolution.setText(resolution);
    }

    public void setMp(String mp) {
        this.mp = mp;
        txtMp.setText(mp);
    }

    public void setFlength(String flength) {
        this.flength = flength;
        txtFlength.setText(flength);
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
        txtCameraId.setText(cameraId);
    }

    private void animateButtonBar(int fromColor, int toColor) {
        final ValueAnimator animateButton = ValueAnimator.ofObject(new ArgbEvaluator(), fromColor, toColor);
        animateButton.addUpdateListener(animator -> cardViewActivated.setCardBackgroundColor((int) animator.getAnimatedValue()));
        animateButton.setDuration(300);
        animateButton.setStartDelay(0);
        animateButton.start();
    }
}
