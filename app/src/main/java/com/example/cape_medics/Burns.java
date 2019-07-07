package com.example.cape_medics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Burns extends Fragment {

    String[] burnType = {"Thermal(Fire, Water, Oil)","Chemical(Acid, etc)","Electrical","Lightning"};
    String[] treatment = {"IV","Burn Spray (Hydrogel)","Burn Dressing (Hydrogel)","Wed Dressing/Trauma Pad","Dry Dressing"};
    String[] inhalation = {"Facial Burns","Soot In Sputum","Breathing Difficulties"};
    String[] degree = {"1st","2nd (Partial Thickness)","3rd (Full Thickness)","4th (Involving Tendons)"};

    ListView type,dress,inhale,burn;

    TextView score;
    EditText weight, tsa;

    Button calc;

    public Burns() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_burns, container, false);

        type = view.findViewById(R.id.burnType);
        dress = view.findViewById(R.id.treatment);
        inhale = view.findViewById(R.id.inhaleBurn);
        burn = view.findViewById(R.id.degree);

        ArrayAdapter a1 = new ArrayAdapter(getContext(),R.layout.custom_checked_list,burnType);
        ArrayAdapter a2 = new ArrayAdapter(getContext(),R.layout.custom_checked_list,treatment);
        ArrayAdapter a3 = new ArrayAdapter(getContext(),R.layout.custom_checked_list,inhalation);
        ArrayAdapter a4 = new ArrayAdapter(getContext(),R.layout.custom_checked_list,degree);

        type.setAdapter(a1);
        dress.setAdapter(a2);
        inhale.setAdapter(a3);
        burn.setAdapter(a4);

        score = view.findViewById(R.id.txtInfusion);
        weight = view.findViewById(R.id.edtWeight);
        tsa  = view.findViewById(R.id.edtSurface);

        calc = view.findViewById(R.id.btnCalcapgar);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float weigh = Float.parseFloat(weight.getText().toString());
                float percent = Float.parseFloat(tsa.getText().toString());

                DecimalFormat format = new DecimalFormat("##.00");

                Float ans = new Float( 4*weigh*percent/1000);


                String put = "Infusion Answer: "+ format.format(ans)+"L";

                score.setText(put);
            }
        });



        type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CheckedTextView text  =  view.findViewById(android.R.id.text1);

                text.toggle();
            }
        });

        dress.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CheckedTextView text  =  view.findViewById(android.R.id.text1);

                text.toggle();
            }
        });

        inhale.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CheckedTextView text  =  view.findViewById(android.R.id.text1);

                text.toggle();
            }
        });

        burn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CheckedTextView text  =  view.findViewById(android.R.id.text1);

                text.toggle();
            }
        });


        return view;
    }

}
