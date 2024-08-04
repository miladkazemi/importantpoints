package com.devst0rm.importantpoints.ui.Activity;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.devst0rm.importantpoints.R;
import com.devst0rm.importantpoints.utils.GoToFragments;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RTL
        Configuration configuration = getResources().getConfiguration();
        configuration.setLayoutDirection(new Locale("fa"));
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());


        new GoToFragments(this).goToSplashScreen();




    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
    }



    @Override
    public void onResume() {
        super.onResume();

    }

}