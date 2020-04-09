package com.example.wcmc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

public class MainActivity extends AppCompatActivity {

    EditText edittext1;
    Button b1;
    Chronometer c1;
    int i=0;
    int dur=10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext1=findViewById(R.id.editText);
        b1=findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                c1=(Chronometer)findViewById(R.id.chronometer);
                final String s = edittext1.getText().toString();
                c1.setOnChronometerTickListener(new OnChronometerTickListener() {

                    @Override
                    public void onChronometerTick(Chronometer arg0) {
                        if((i-1)%dur==0 && i!=1)
                        {


                            Toast.makeText(MainActivity.this, s+" : "+(i/10),Toast.LENGTH_LONG).show();
                        }
                        i++;
                        if(i==61)
                        {
                            c1.stop();
                        }
                    }
                });
                c1.setBase(SystemClock.elapsedRealtime());
                c1.start();
            }
        });
    }
}
