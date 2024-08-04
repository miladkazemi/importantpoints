package com.devst0rm.importantpoints.ui.Fragment;

import static com.devst0rm.importantpoints.utils.utils.setImageToView_simple;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.devst0rm.importantpoints.R;
import com.devst0rm.importantpoints.model.Points_M;

public class FragmentPointInfo extends Fragment {

    private AppCompatImageView iv_back, iv_photo;
    private AppCompatTextView tv_titlePage, tv_description;
    private final Points_M pointsM;


    public FragmentPointInfo(Points_M pointsM) {
        super(R.layout.fragment_point_info);
        this.pointsM = pointsM;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setData();
        instance();
        events();

    }

    private void initView(View view) {
        iv_back = view.findViewById(R.id.iv_back);
        iv_photo = view.findViewById(R.id.iv_photo);
        tv_titlePage = view.findViewById(R.id.tv_titlePage);
//        tv_name = view.findViewById(R.id.tv_name);
        tv_description = view.findViewById(R.id.tv_description);
    }

    private void setData() {
        setImageToView_simple(iv_photo, pointsM.getPhoto());
        tv_titlePage.setText(pointsM.getName());
//        tv_name.setText(pointsM.getName());
        tv_description.setText(pointsM.getDescription());
    }

    private void instance() {

    }

    private void events() {
        iv_back.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });
    }

}