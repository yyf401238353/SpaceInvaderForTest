package com.example.lu.spaceinvader;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lu on 2016-04-22.
 */
public class PlaceholderFragment extends Fragment {

    public  PlaceholderFragment(){

    }
    public View onCreateView(LayoutInflater infalater,ViewGroup container,Bundle saveInstanceState){
          View rootView=infalater.inflate(R.layout.fragment_main,container,false);
        rootView.findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container, new gameFragment()).commit();
            }
        });
        return rootView;
    }
}
