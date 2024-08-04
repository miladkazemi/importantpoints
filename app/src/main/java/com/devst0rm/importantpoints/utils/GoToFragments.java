package com.devst0rm.importantpoints.utils;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.devst0rm.importantpoints.R;
import com.devst0rm.importantpoints.model.Categories_M;
import com.devst0rm.importantpoints.model.Points_M;
import com.devst0rm.importantpoints.ui.Fragment.FragmentHome;
import com.devst0rm.importantpoints.ui.Fragment.FragmentPointInfo;
import com.devst0rm.importantpoints.ui.Fragment.FragmentSplashScreen;

import java.util.ArrayList;

public class GoToFragments {


    private final Context context;
    private final FragmentManager fragmentManager;
    private FragmentTransaction transaction;




    public GoToFragments(Context context) {
        this.context = context;
        fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
    }

    private void initSetting(int containerBackFragmentID, Fragment fragment, boolean backStack) {
        transaction = fragmentManager.beginTransaction(); // every time update transaction
        transaction.add(containerBackFragmentID, fragment);
        if (backStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    public void goToSplashScreen() {
        FragmentSplashScreen fragment = new FragmentSplashScreen();
        initSetting(R.id.fragment_start, fragment, false);

    }

    public void goToFragmentHome(ArrayList<Categories_M> categoriesList) {
        FragmentHome fragment = new FragmentHome(categoriesList);
        initSetting(R.id.fragment_start, fragment, false);

    }


    public void goToFragmentPointInfo(Points_M pointsM) {
        FragmentPointInfo fragment = new FragmentPointInfo(pointsM);
        initSetting(R.id.fragment_start, fragment, true);
    }


}
