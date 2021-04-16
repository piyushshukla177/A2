package com.service.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adapter.BannerAdapter;
import com.adapter.SliderAdapterExample;
import com.model.SliderItem;
import com.service.a2.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    Context context;
    SliderView sliderView;
    ArrayList<SliderItem> slider_list = new ArrayList();
    ViewPager vpBanner;
    CircleIndicator cIndicator;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        init(root);
        return root;
    }

    void init(View root) {
        context = getActivity();
        vpBanner = root.findViewById(R.id.vpBanner);
        cIndicator = root.findViewById(R.id.cIndicator);

//        sliderView = root.findViewById(R.id.imageSlider);
        startSlider();

    }

    private static int currentPage = 0;

    void startSlider() {
        SliderItem s = new SliderItem();
        s.setDescription("");
        s.setImageUrl(R.drawable.slider_image1);
        slider_list.add(s);

        SliderItem s1 = new SliderItem();
        s1.setDescription("");
        s1.setImageUrl(R.drawable.slider_image1);
        slider_list.add(s1);

        SliderItem s2 = new SliderItem();
        s2.setDescription("");
        s2.setImageUrl(R.drawable.slider_image1);
        slider_list.add(s2);

        SliderItem s3 = new SliderItem();
        s3.setDescription("");
        s3.setImageUrl(R.drawable.slider_image1);
        slider_list.add(s3);

        SliderItem s4 = new SliderItem();
        s4.setDescription("");
        s4.setImageUrl(R.drawable.slider_image1);
        slider_list.add(s4);

//        SliderItem s5 = new SliderItem();
//        s5.setDescription("");
//        s5.setImageUrl(R.drawable.slide_image6);
//        slider_list.add(s5);

        vpBanner.setAdapter(new BannerAdapter(getActivity(), slider_list));
        cIndicator.setViewPager(vpBanner);
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == slider_list.size()) {
                    currentPage = 0;
                }
                vpBanner.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3500, 3500);
//        sliderView.setSliderAdapter(new SliderAdapterExample(context, slider_list));
//        sliderView.run();
    }


    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
//            addBottomDots(position);
//            setData(position);
//            if (position == 0) {
//
//            } else if (position == 1) {
//
//                setData();
//            } else if (position == 2) {
//
//
//            } else if (position == 3) {
//
//
//            } else if (position == 4) {
//
//            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
}