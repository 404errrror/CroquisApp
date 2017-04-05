package com.example.momo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jrummyapps.android.widget.AnimatedSvgView;


public class SplashActivity extends AppCompatActivity {
    AnimatedSvgView svgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        svgView = (AnimatedSvgView) findViewById(R.id.animated_sgv_view);
        setSvg(SVG.GOOGLE);
        svgView.start();
        final Intent mainActivity = new Intent(this, MainActivity.class);

        svgView.setOnStateChangeListener(new AnimatedSvgView.OnStateChangeListener() {
            @Override public void onStateChange(@AnimatedSvgView.State int state)
            {
                if(state == AnimatedSvgView.STATE_FINISHED) {
                    startActivity(mainActivity);
                    finish();
                }
            }
        });



    }




    private void setSvg(SVG svg) {
        svgView.setGlyphStrings(svg.glyphs);
        svgView.setFillColors(svg.colors);
        svgView.setViewportSize(svg.width, svg.height);
        svgView.setTraceResidueColor(0x32000000);
        svgView.setTraceColors(svg.colors);
        svgView.rebuildGlyphData();
        svgView.start();
    }
}
