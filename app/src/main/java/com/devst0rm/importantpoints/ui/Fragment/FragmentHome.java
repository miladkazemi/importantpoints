package com.devst0rm.importantpoints.ui.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devst0rm.importantpoints.R;
import com.devst0rm.importantpoints.model.Categories_M;
import com.devst0rm.importantpoints.model.Points_M;
import com.devst0rm.importantpoints.remote.APIService.point.PointRepository;
import com.devst0rm.importantpoints.ui.Adapter.PointAdapter;
import com.devst0rm.importantpoints.ui.Adapter.TabAdapter;
import com.devst0rm.importantpoints.utils.GoToFragments;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    // logics
    private PointRepository pointRepository;
    private GoToFragments goToFragments;
    // inner variable
    private final ArrayList<Categories_M> categoriesList;
    private final ArrayList<Points_M> points = new ArrayList<>();
    // views
    private RecyclerView rv_category, rv_point;




    public FragmentHome(ArrayList<Categories_M> categoriesList) {
        super(R.layout.fragment_home);
        this.categoriesList = categoriesList;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        instance();
        events();
        initRVCategory();
        initRVPoint();
    }

    private void initView(View view) {
        rv_category = view.findViewById(R.id.rv_category);
        rv_point = view.findViewById(R.id.rv_point);
    }

    private void instance() {
        pointRepository = new PointRepository(requireContext());
        goToFragments = new GoToFragments(requireContext());
    }

    private void events() {

    }

    private void initRVCategory() {
        ArrayList<String> categoryName = new ArrayList<>();
        // put names from categoryModel:
        for (Categories_M model: categoriesList) {
            categoryName.add(model.getName());
        }

        TabAdapter adapter = new TabAdapter(categoryName, requireActivity(), this::getPoints);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false);
        rv_category.setLayoutManager(layoutManager);
        rv_category.setAdapter(adapter);

    }

    private void initRVPoint() {
        PointAdapter adapter = new PointAdapter(points, requireActivity(), model -> {
            goToFragments.goToFragmentPointInfo(model);
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rv_point.setLayoutManager(layoutManager);
        rv_point.setAdapter(adapter);

        pointRepository.getLiveData_point().observe(requireActivity(), adapter::changeList);
    }

    private void getPoints(int categoryListPosition) {
        pointRepository.getPoints(categoriesList.get(categoryListPosition).getType());
    }

}