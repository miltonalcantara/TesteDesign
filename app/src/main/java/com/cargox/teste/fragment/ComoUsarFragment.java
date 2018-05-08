package com.cargox.teste.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cargox.teste.R;

/**
 * Criado por Milton Alcântara em 05/05/2018.
 */
public class ComoUsarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_como_usar, container, false);

        return view;
    }

}
