package com.example.wcmc;

import androidx.appcompat.app.AppCompatActivity; import androidx.constraintlayout.widget.ConstraintLayout; import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem; import android.widget.Toast;

public class MainActivity extends AppCompatActivity { ConstraintLayout current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        current = (ConstraintLayout)findViewById(R.id.lay);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuoption, menu); return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) { case R.id.item1:
            current.setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(),"RED color ",Toast.LENGTH_SHORT).show();
            return true; case R.id.item2:
            current.setBackgroundColor(Color.GREEN);
            Toast.makeText(getApplicationContext(),"GREEN color",Toast.LENGTH_SHORT).show();
            return true; case R.id.item3:
            current.setBackgroundColor(Color.BLUE);
            Toast.makeText(getApplicationContext(),"BLUE color",Toast.LENGTH_SHORT).show();
            return true; default:
            return super.onContextItemSelected(item);
        }
    }
}
