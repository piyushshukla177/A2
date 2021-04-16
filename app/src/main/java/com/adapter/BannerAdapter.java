package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.model.SliderItem;
import com.service.a2.R;

import java.util.ArrayList;


public class BannerAdapter extends PagerAdapter {

    ArrayList<SliderItem> images_list = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;

    public BannerAdapter(Context context, ArrayList<SliderItem> images) {
        this.context = context;
        this.images_list = images;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images_list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View view1 = inflater.inflate(R.layout.inflate_banner, view, false);
        ImageView ivBanner = (ImageView) view1
                .findViewById(R.id.ivBanner);
        ivBanner.setImageResource(images_list.get(position).getImageUrl());
//        Glide.with(context).load(AppConstants.BaseUrl + images.getBody().get(position).getStrimagepath())
//                .into(ivBanner);

        view.addView(view1, 0);
        return view1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}

