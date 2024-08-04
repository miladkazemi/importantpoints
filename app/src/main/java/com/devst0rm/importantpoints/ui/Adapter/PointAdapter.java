package com.devst0rm.importantpoints.ui.Adapter;

import static com.devst0rm.importantpoints.utils.utils.setImageToView_simple;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.devst0rm.importantpoints.R;
import com.devst0rm.importantpoints.model.Points_M;

import java.util.ArrayList;
import java.util.List;

public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder> {


    private final List<Points_M> myList;
    private final Activity activity;

    private final OnItemClick onItemClick;
    public interface OnItemClick {
        void onClick(Points_M model);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView tv_name, tv_status;
        private final AppCompatImageView iv_photo;


        public ViewHolder(View view) {
            super(view);
            tv_name = view.findViewById(R.id.tv_name);
            tv_status = view.findViewById(R.id.tv_status);
            iv_photo = view.findViewById(R.id.iv_photo);
        }


    }

    public PointAdapter(List<Points_M> myList, Activity activity, OnItemClick onItemClick) {
        this.myList = myList;
        this.activity = activity;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_point, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Points_M model = myList.get(position);
        viewHolder.tv_name.setText(model.getName());
        setImageToView_simple(viewHolder.iv_photo, model.getPhoto());
        checkOpenStatus(model.isOpen(), viewHolder.tv_status);


        viewHolder.itemView.setOnClickListener(view -> {
            onItemClick.onClick(model);
        });
    }

    private void checkOpenStatus(int isOpen, AppCompatTextView tv_status) {
        if (isOpen == 1) {
            tv_status.setText(activity.getString(R.string.isOpen));
            tv_status.setTextColor(activity.getResources().getColor(R.color.open));
        }else {
            tv_status.setText(activity.getString(R.string.isClose));
            tv_status.setTextColor(activity.getResources().getColor(R.color.close));
        }
    }

    public void changeList(ArrayList<Points_M> points) {
        myList.clear();
        myList.addAll(points);
        refresh();
    }

    public void refresh() {
        notifyDataSetChanged();
    }




    public void remove(int position) {
        myList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, myList.size());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

}

