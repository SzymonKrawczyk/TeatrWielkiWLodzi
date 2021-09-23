package com.example.teatrwielkiwlodzi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class person_info extends Fragment {


    Button buttonBack;
    TextView name;
    TextView role;
    TextView description;
    ImageView image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_person_info, container, false);

        buttonBack = (Button) view.findViewById(R.id.pbutton);
        name = (TextView) view.findViewById(R.id.ptextView1);
        role = (TextView) view.findViewById(R.id.ptextView2);
        description = (TextView) view.findViewById(R.id.ptextView3);
        image = (ImageView) view.findViewById(R.id.pimageView);

        image.setImageResource(getResources().getIdentifier("osoba_" + zespoly_fragment.currentPerson,"drawable", getActivity().getPackageName()));
        name.setText(getString(getResources().getIdentifier("osoba_" + zespoly_fragment.currentPerson + "_imie", "string", getActivity().getPackageName())));
        role.setText(getString(getResources().getIdentifier("osoba_" + zespoly_fragment.currentPerson + "_rola", "string", getActivity().getPackageName())));
        description.setText(getString(getResources().getIdentifier("osoba_" + zespoly_fragment.currentPerson + "_opis", "string", getActivity().getPackageName())));



        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zespoly_fragment zespoly = new zespoly_fragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, zespoly, zespoly.getTag()).addToBackStack(null).commit();
            }
        });


        return view;
    }


}
