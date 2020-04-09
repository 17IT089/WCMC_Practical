package com.example.wcmc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity; import android.os.Build;
import android.os.Bundle; import android.widget.Toast;
import android.widget.ToggleButton;
import android.hardware.camera2.CameraManager; import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException; import android.widget.CompoundButton;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) public class MainActivity extends AppCompatActivity {

    private CameraManager mCameraManager; private String mCameraId;
    private ToggleButton toggleButton;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        boolean isFlashAvailable = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH); if (!isFlashAvailable) {
        }
        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE); try {
            mCameraId = mCameraManager.getCameraIdList()[0];

        } catch (CameraAccessException e) { e.printStackTrace();
        }
        toggleButton = findViewById(R.id.toggleButton);


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M) @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { switchFlashLight(isChecked);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M) public void switchFlashLight(boolean status) {
        try {
            mCameraManager.setTorchMode(mCameraId, status); if(status){
                Toast.makeText(getApplicationContext(),"FLASH ON",Toast.LENGTH_SHORT).show();
            }
            if(!status){ Toast.makeText(getApplicationContext(),"FLASH OFF",Toast.LENGTH_SHORT).show();
            }

        } catch (CameraAccessException e) { e.printStackTrace();
        }
    }
}
