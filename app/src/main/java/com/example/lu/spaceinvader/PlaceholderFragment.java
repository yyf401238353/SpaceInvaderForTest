package com.example.lu.spaceinvader;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by lu on 2016-04-22.
 */
public class PlaceholderFragment extends Fragment {
    View rootView;
    private Spinner sp_level;
    private String level;
    private TextView tv;
    public  PlaceholderFragment(){

    }
    public View onCreateView(LayoutInflater infalater,ViewGroup container,Bundle saveInstanceState){
        rootView=infalater.inflate(R.layout.fragment_main,container,false);
        rootView.findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.container, new gameFragment()).commit();

            }
        });
        sp_level = (Spinner) rootView.findViewById(R.id.sp_level);
        tv = (TextView) rootView.findViewById(R.id.txt01);
        level = (String) sp_level.getSelectedItem();
        sp_level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                level = (String) sp_level.getSelectedItem();
                tv.setText(level);
                ((MainActivity)getActivity()).setLevel(level);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rootView;
    }
}
