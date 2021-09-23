package com.example.teatrwielkiwlodzi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class glowna_fragment extends Fragment {


    LinearLayout myLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_glowna_fragment, container, false);

        myLayout = (LinearLayout)  view.findViewById(R.id.mainLayout);

        for (int i = 1; i < 6; ++i) {

            ImageView newImg = new ImageView(getActivity());


            newImg.setLayoutParams(new LinearLayout.LayoutParams(177*3, 100*3));
            newImg.setImageResource(getResources().getIdentifier("partner_" + i,"drawable", getActivity().getPackageName()));
            newImg.setTag(i);
            newImg.setScaleType(ImageView.ScaleType.CENTER_CROP);

            myLayout.addView(newImg);
        }
        return view;
    }
}