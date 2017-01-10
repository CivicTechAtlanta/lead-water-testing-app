package com.example.cjk.leadwaterleveldectection;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seekBarOne;
    ImageView colorBoxOne;
    SeekBar seekBarTwo;
    ImageView colorBoxTwo;
    TextView resultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarOne = (SeekBar) findViewById(R.id.seekBarOne);
        colorBoxOne = (ImageView) findViewById(R.id.colorBoxOne);
        seekBarTwo = (SeekBar) findViewById(R.id.seekBarTwo);
        colorBoxTwo  = (ImageView) findViewById(R.id.colorBoxTwo);
        resultLabel = (TextView) findViewById(R.id.resultLabel);

        seekBarOne.setOnSeekBarChangeListener(this);
        seekBarTwo.setOnSeekBarChangeListener(this);
    }

    void updateColor(int value, boolean top) {
        if(top){
            colorBoxOne.setBackgroundColor(valueToColor(value));
        }else{
            colorBoxTwo.setBackgroundColor(valueToColor(value));
        }
        if(seekBarOne.getProgress() < seekBarTwo.getProgress()) {
            resultLabel.setText("Water is safe");
        }else{
            resultLabel.setText("Do not drink");
        }
    }

    int valueToColor(int value) {
        int scaled = (int) Math.round((value / 100.0) * 255.0);
        return Color.argb(scaled, 0, 0, 255);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.updateColor(progress, seekBar.getId() == seekBarOne.getId());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
