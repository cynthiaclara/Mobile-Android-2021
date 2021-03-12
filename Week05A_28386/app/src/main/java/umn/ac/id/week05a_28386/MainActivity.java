package umn.ac.id.week05a_28386;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar skBrRed, skBrGreen, skBrBlue;
    private RadioGroup rGrpBentuk;
    private RadioButton rBtnTerpilih;
    private ImageButton btnWarna;
    private CustomView customView;
    private int red=0, green=0, blue=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skBrRed = findViewById(R.id.skBrRed);
        skBrGreen = findViewById(R.id.skBrGreen);
        skBrBlue = findViewById(R.id.skBrBlue);
        btnWarna = findViewById(R.id.iBtnWarna);
        rGrpBentuk = findViewById(R.id.rGrpBentuk);
        customView = findViewById(R.id.customView);
        customView = new CustomView(this);

        rGrpBentuk.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rBtnTerpilih_id = rGrpBentuk.getCheckedRadioButtonId();
                rBtnTerpilih = findViewById(rBtnTerpilih_id);
                String bentuk = rBtnTerpilih.getText().toString();
                customView.gantiBentuk(bentuk);
            }
        });

        skBrRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                red = skBrRed.getProgress();
                customView.gantiWarna(red, green, blue);
                btnWarna.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });

        skBrGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                green = skBrGreen.getProgress();
                customView.gantiWarna(red, green, blue);
                btnWarna.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });

        skBrBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                blue = skBrBlue.getProgress();
                customView.gantiWarna(red, green, blue);
                btnWarna.setBackgroundColor(Color.rgb(red, green, blue));
            }
        });
    }
}