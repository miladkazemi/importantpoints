package com.devst0rm.importantpoints.ui.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.devst0rm.importantpoints.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.ViewHolder> {


    private List<String> tabNameList;
    private Activity activity;
    private int tabSelectedPosition = 0;

    private final OnClickTabListener onClickTabListener;
    public interface OnClickTabListener {
        void onChangeTab(int position);
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final MaterialCardView card_main;
        private final AppCompatTextView tv_name;


        public ViewHolder(View view) {
            super(view);
            card_main = view.findViewById(R.id.card_main);
            tv_name = view.findViewById(R.id.tv_name);
        }


    }

    public TabAdapter(List<String> tabNameList, Activity activity, OnClickTabListener onClickTabListener) {
        this.tabNameList = tabNameList;
        this.activity = activity;
        this.onClickTabListener = onClickTabListener;
        onClickTabListener.onChangeTab(tabSelectedPosition);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tab, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        String name = tabNameList.get(position);
        viewHolder.tv_name.setText(name);
        handleTabColor(position, viewHolder);

        controlMarginLastItem(position, viewHolder);

        viewHolder.itemView.setOnClickListener(view -> {
            if (tabSelectedPosition != position) {
                tabSelectedPosition = position;
                refresh();
                onClickTabListener.onChangeTab(position);
            }
        });

    }

    private void handleTabColor(int position, ViewHolder viewHolder) {
        if (tabSelectedPosition == position) {

            viewHolder.card_main.setCardBackgroundColor(activity.getResources().getColor(R.color.tabSelected));
            viewHolder.tv_name.setTextColor(activity.getResources().getColor(R.color.innerText));
        }else {
            viewHolder.card_main.setCardBackgroundColor(activity.getResources().getColor(R.color.tabUnselected));
            viewHolder.tv_name.setTextColor(activity.getResources().getColor(R.color.text));
        }
    }

    private void controlMarginLastItem(int position, ViewHolder viewHolder) {
        if (position == getItemCount() - 1) {
            // Set margin for the specific view in the last item
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
            int marginEnd = viewHolder.itemView.getResources().getDimensionPixelSize(com.intuit.sdp.R.dimen._10sdp);
            layoutParams.setMarginEnd(marginEnd);
            viewHolder.itemView.setLayoutParams(layoutParams);
        } else {
            // Reset the margin for the specific view in other items
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
            layoutParams.setMarginEnd(0);
            viewHolder.itemView.setLayoutParams(layoutParams);
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    public void refresh() {
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return tabNameList.size();
    }

}

