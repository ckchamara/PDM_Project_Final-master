package com.example.himashiyan.road_vehicle_assistance;

import android.content.Context;
import android.support.v4.view.PagerAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){

        this.context=context;
    }

    //Array
    public int[] slide_images={

            R.drawable.dashboard_resize,
            R.drawable.engine_resize,
            R.drawable.battary_resize,
            R.drawable.oil_resize,
            R.drawable.tire_resize
    };

    public String[] slide_headings={


            "Dashboard",
            "Engine",
            "Battery",
            "Oil",
            "Tire"


    };

    public String[] slide_desc = {
                        "The Engine Is Abnormally Loud   If your car is louder than normal, it’s most likely not the engine. The problem is in the exhaust system, which is connected to, but distinct from, the engine. Usually, it’s the muffler or catalytic converter causing the loud noises.  Either one can degrade over time and require replacing."+
                        "himashiyan",
                        "The Engine Is Abnormally Loud   If your car is louder than normal, it’s most likely not the engine. The problem is in the exhaust system, which is connected to, but distinct from, the engine. Usually, it’s the muffler or catalytic converter causing the loud noises.  Either one can degrade over time and require replacing."+
                                "Gayanjana",
                        "The Engine Is Abnormally Loud   If your car is louder than normal, it’s most likely not the engine. The problem is in the exhaust system, which is connected to, but distinct from, the engine. Usually, it’s the muffler or catalytic converter causing the loud noises.  Either one can degrade over time and require replacing."+
                                "aliqua",
                        "The Engine Is Abnormally Loud   If your car is louder than normal, it’s most likely not the engine. The problem is in the exhaust system, which is connected to, but distinct from, the engine. Usually, it’s the muffler or catalytic converter causing the loud noises.  Either one can degrade over time and require replacing."+
                                "support",
                        "The Engine Is Abnormally Loud   If your car is louder than normal, it’s most likely not the engine. The problem is in the exhaust system, which is connected to, but distinct from, the engine. Usually, it’s the muffler or catalytic converter causing the loud noises.  Either one can degrade over time and require replacing."


    };


    @Override
    public int getCount(){
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o){
        return view == (RelativeLayout)o;
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,  false);

        ImageView SlideImageView    = (ImageView) view.findViewById(R.id.slide_img);
        TextView  Slideheading      = (TextView) view.findViewById(R.id.slide_heading);
        TextView  SlideDescription  = (TextView) view.findViewById(R.id.slide_desc);

        SlideImageView.setImageResource(slide_images[position]);
        Slideheading.setText(slide_headings[position]);
        SlideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup  contanier, int position, Object object) {

        contanier.removeView((RelativeLayout)object);
    }

}
