package com.example.teatrwielkiwlodzi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class zespoly_fragment extends Fragment {

    public static int currentPerson = 1;
    Button button1;
    Button button2;
    Button button3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zespoly_fragment, container, false);

        button1 = (Button) view.findViewById(R.id.zbutton);
        button2 = (Button) view.findViewById(R.id.zbutton2);
        button3 = (Button) view.findViewById(R.id.zbutton3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPerson = 1;
                goToPersonDetails();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPerson = 2;
                goToPersonDetails();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPerson = 3;
                goToPersonDetails();
            }
        });

        return view;
    }

    private void goToPersonDetails() {
        person_info personinfo = new person_info();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, personinfo, personinfo.getTag()).addToBackStack(null).commit();
    }
}
