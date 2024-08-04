package com.devst0rm.importantpoints.ui.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.devst0rm.importantpoints.R;
import com.devst0rm.importantpoints.model.Categories_M;
import com.devst0rm.importantpoints.remote.APIService.point.PointRepository;
import com.devst0rm.importantpoints.utils.GoToFragments;

import java.util.ArrayList;

public class FragmentSplashScreen extends Fragment {




    public FragmentSplashScreen() {
        super(R.layout.fragment_splash_screen);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getInitData();
    }

    private void getInitData() {
        PointRepository pointRepository = new PointRepository(requireContext());
        pointRepository.getCategories();
        pointRepository.getLiveData_category().observe(requireActivity(), categoriesMs -> {
            new Handler().postDelayed(() -> {
                new GoToFragments(requireContext()).goToFragmentHome(categoriesMs);
            }, 1000);
        });
    }





}

