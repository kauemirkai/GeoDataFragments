package br.usjt.ftce.deswebmob.GeoData.view;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.usjt.ftce.deswebmob.GeoData.R;
import br.usjt.ftce.deswebmob.GeoData.viewModel.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */

public class DetalhePaisFragment extends Fragment {

    MainViewModel viewModel = new MainViewModel();
    public DetalhePaisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_detalhe_pais, container, false);
    }

}
