package org.bahare.ghategh;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class LauncherActivity extends AppCompatActivity {
    private boolean doubleTap=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);



        if (InternetConnection.checkConnection(this)) {
            Toast.makeText(getApplicationContext(), "اتصال به اینترنت برقرار است!", Toast.LENGTH_SHORT).show();
            //Launcher Intent Code
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.start(LauncherActivity.this);
                    finish();
                }
            }, 2000);
            //Launcher Intent Codes
        }

        else {
            Toast.makeText(getApplicationContext(), "اتصال به اینترنت برقرار نیست!", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 3000);

        }

    }
    @Override
    public void onBackPressed() {
        if (doubleTap) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "برای خروج مجدد کلیک کنید!", Toast.LENGTH_SHORT).show();
            doubleTap = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleTap = false;
                }
            }, 500);
        }

    }}
