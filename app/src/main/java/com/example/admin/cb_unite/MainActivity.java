package com.example.admin.cb_unite;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    BackgroundQuad backgroundQuad;
    CustomColorPicker customColorPicker;

    final float[] currentColorHsv = new float[3];
    int color = 0xffffff00;
    int alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundQuad = (BackgroundQuad) findViewById(R.id.bcQuad);
        alpha = Color.alpha(color);
        Color.colorToHSV(color, currentColorHsv);

        float hue = 360.f - 360.f / backgroundQuad.getMeasuredHeight() * 100;
        if (hue == 360.f) hue = 0.f;
        setHue(hue);

        // update view
//        ambilWarnaSquare.setHue(301.3125f);
        backgroundQuad.setHue(getHue());

        customColorPicker = (CustomColorPicker) findViewById(R.id.colorslider);
        customColorPicker.initColorPicker(new CustomColorPicker.OnColorChangedListener() {
            @Override
            public void colorChanged(int color) {
                backgroundQuad.setMyColor(color);
            }
        }, Color.BLUE);

    }

    private float getHue() {
        return currentColorHsv[0];
    }

    private void setHue(float hue) {
        currentColorHsv[0] = hue;
    }
}
