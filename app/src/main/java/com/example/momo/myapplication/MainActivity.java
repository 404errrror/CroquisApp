package com.example.momo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jrummyapps.android.widget.AnimatedSvgView;


public class MainActivity extends AppCompatActivity {
    AnimatedSvgView svgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        svgView = (AnimatedSvgView) findViewById(R.id.animated_sgv_view);
        setSvg(SVG.GOOGLE);
        svgView.postDelayed(new Runnable() {
            @Override
            public void run() {
                svgView.start();
            }
        }, 500);

        svgView.setOnStateChangeListener(new AnimatedSvgView.OnStateChangeListener() {
            @Override public void onStateChange(@AnimatedSvgView.State int state)
            {
                if(state == AnimatedSvgView.STATE_FINISHED)
                    setContentView(R.layout.select_layout);
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
