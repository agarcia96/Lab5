package com.example.angelicagarcia16.actionbarexperiment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by angelicagarcia16 on 3/19/2018.
 */

public class LunchFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate layout for this fragment
        return inflater.inflate(R.layout.fragment_lunch, container, false);
    }

}
