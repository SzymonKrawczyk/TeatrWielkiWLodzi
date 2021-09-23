package com.example.teatrwielkiwlodzi;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class galeria_fragment extends Fragment {
    private int currentImage;
    private final int startImage = 4;
    private final int endImage = 20;
    LinearLayout myLayout;
    ImageView imgOut;

    TextView textView_autor_sztuki, textView_tytul_sztuki, textView_autor_plakatu, textView_data_plakatu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_galeria_fragment, container, false);

        currentImage = 4;
        myLayout = (LinearLayout)  view.findViewById(R.id.myLayout);
        imgOut = (ImageView)  view.findViewById(R.id.imgOut);
        textView_autor_sztuki = (TextView)  view.findViewById(R.id.textView_autor_sztuki);
        textView_tytul_sztuki = (TextView)  view.findViewById(R.id.textView_tytul_sztuki);
        textView_autor_plakatu = (TextView)  view.findViewById(R.id.textView_autor_plakatu);
        textView_data_plakatu = (TextView)  view.findViewById(R.id.textView_data_plakatu);

        for (int i = startImage; i < endImage+1; ++i) {

            ImageView newImg = new ImageView(getActivity());


            newImg.setLayoutParams(new LinearLayout.LayoutParams(140, 200));
            //System.out.println(i);
            newImg.setImageResource(getResources().getIdentifier("plakat_" + i,"drawable", getActivity().getPackageName()));
            newImg.setTag(i);
            newImg.setScaleType(ImageView.ScaleType.CENTER_CROP);

            newImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView localView = (ImageView) v;

                    imgOut.setImageDrawable(localView.getDrawable());

                    currentImage = (Integer)localView.getTag();
                    setText(currentImage);
                }
            });
            myLayout.addView(newImg);
        }
        if (savedInstanceState != null) {

            imgOut.setImageBitmap((Bitmap) savedInstanceState.getParcelable("bitmapa"));
            currentImage = savedInstanceState.getInt("imageNum");
            setText(currentImage);
        }
        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        BitmapDrawable bitmap = (BitmapDrawable) imgOut.getDrawable();
        if (bitmap != null) {
            outState.putParcelable("bitmapa", bitmap.getBitmap());
            outState.putInt("imageNum", currentImage);
        }
    }

    private void setText(int currentImagePos) {
        textView_autor_sztuki.setText(getString(getResources().getIdentifier("plakat_" + currentImagePos + "_autor_sztuki", "string", getActivity().getPackageName())));
        textView_tytul_sztuki.setText(getString(getResources().getIdentifier("plakat_" + currentImagePos + "_tytul_sztuki", "string", getActivity().getPackageName())));
        textView_autor_plakatu.setText(getString(getResources().getIdentifier("plakat_" + currentImagePos + "_autor_plakatu", "string", getActivity().getPackageName())));
        textView_data_plakatu.setText(getString(getResources().getIdentifier("plakat_" + currentImagePos + "_data_plakatu", "string", getActivity().getPackageName())));
    }
}
