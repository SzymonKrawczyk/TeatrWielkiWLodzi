package com.example.teatrwielkiwlodzi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;


public class kalendarium_fragment extends Fragment {

    private int currentMonth = 2;
    private final int maxMonths = 3;
    private final int totalShows = 4;


    private Button buttonPrev;
    private Button buttonNext;
    private Button[] buttonBuy;
    private TextView[] text_title;
    private TextView text_month;
    private TextView[] text_date;
    private TextView[] text_info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kalendarium_fragment, container, false);


        buttonPrev = (Button) view.findViewById(R.id.kalButtonPrev);
        buttonNext = (Button) view.findViewById(R.id.kalButtonNext);
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousMonth();
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextMonth();
            }
        });

        buttonBuy = new Button[totalShows];
            buttonBuy[0] = (Button) view.findViewById(R.id.kalbuttonBuy);
            buttonBuy[1] = (Button) view.findViewById(R.id.kalbuttonBuy2);
            buttonBuy[2] = (Button) view.findViewById(R.id.kalbuttonBuy3);
            buttonBuy[3] = (Button) view.findViewById(R.id.kalbuttonBuy4);

        for (int i = 0; i < totalShows; ++i) {
            buttonBuy[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goToWebsiteBuy();
                }
            });
        }

        text_month = (TextView) view.findViewById(R.id.kalTextViewCurrentMonth);

        text_title = new TextView[totalShows];
            text_title[0] = (TextView) view.findViewById(R.id.kalTextViewTitle);
            text_title[1] = (TextView) view.findViewById(R.id.kalTextViewTitle2);
            text_title[2] = (TextView) view.findViewById(R.id.kalTextViewTitle3);
            text_title[3] = (TextView) view.findViewById(R.id.kalTextViewTitle4);

        text_date = new TextView[totalShows];
            text_date[0] = (TextView) view.findViewById(R.id.kaltextViewDate);
            text_date[1] = (TextView) view.findViewById(R.id.kaltextViewDate2);
            text_date[2] = (TextView) view.findViewById(R.id.kaltextViewDate3);
            text_date[3] = (TextView) view.findViewById(R.id.kaltextViewDate4);

        text_info = new TextView[totalShows];
            text_info[0] = (TextView) view.findViewById(R.id.kalTextViewInfo);
            text_info[1] = (TextView) view.findViewById(R.id.kalTextViewInfo2);
            text_info[2] = (TextView) view.findViewById(R.id.kalTextViewInfo3);
            text_info[3] = (TextView) view.findViewById(R.id.kalTextViewInfo4);

        if (savedInstanceState != null) { currentMonth = savedInstanceState.getInt("currentMonth"); }

        setTextByMonth();

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
            outState.putInt("currentMonth", currentMonth);
    }

    private void previousMonth() {
        if (currentMonth == 0) {
            currentMonth = maxMonths - 1;
        } else {
            currentMonth--;
        }
        setTextByMonth();
    }

    private void nextMonth() {
        currentMonth = (currentMonth + 1) % maxMonths;
        setTextByMonth();
    }

    private void goToWebsiteBuy () {

        Uri uriUrl = Uri.parse("https://www.bilety24.pl/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    private void setTextByMonth() {
        text_month.setText(getString(getResources().getIdentifier("kalendarium_" + (currentMonth+1) + "_miesiac", "string", getActivity().getPackageName())));
        for (int i = 0; i < totalShows; ++i) {

            text_title[i].setText(getString(getResources().getIdentifier("kalendarium_" + (currentMonth+1) + "_" + (i+1) + "_title", "string", getActivity().getPackageName())));
            text_date[i].setText(getString(getResources().getIdentifier("kalendarium_" + (currentMonth+1) + "_" + (i+1) + "_date", "string", getActivity().getPackageName())));
            text_info[i].setText(getString(getResources().getIdentifier("kalendarium_" + (currentMonth+1) + "_" + (i+1) + "_description", "string", getActivity().getPackageName())));
        }
    }
}
