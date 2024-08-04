package com.devst0rm.importantpoints.utils;

import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.devst0rm.importantpoints.R;

public class utils {


    public static void setImageToView_simple(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .skipMemoryCache(true)
                .placeholder(new ColorDrawable(ContextCompat.getColor(imageView.getContext(), R.color.background)))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);

    }

}
