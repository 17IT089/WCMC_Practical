package com.example.wcmc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView result=(TextView)findViewById(R.id.result);
        final  EditText editText=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        final double[] a = new double[1];
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x= String.valueOf(editText.getText());
                if(x.equals(""))
                {
                    editText.setError("please enter value");
                }
                else {
                    a[0] = Double.parseDouble(String.valueOf(x));
                    result.setText((a[0]*9)/5+32 + " F");
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String x= String.valueOf(editText.getText());
                if(x.equals("")){
                    editText.setError("please enter value");
                }
                else {
                    a[0] = Double.parseDouble(String.valueOf(x));
                    result.setText((a[0]-32)*5/9 + " C");
                }
            }
        });
    }

}
