package br.usjt.ftce.deswebmob.GeoData.viewModel;



import br.usjt.ftce.deswebmob.GeoData.model.Pais;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */
import br.usjt.ftce.deswebmob.GeoData.R;

import br.usjt.ftce.deswebmob.GeoData.viewModel.MainViewModel;

import android.databinding.*;

import java.util.Observable;

import br.usjt.ftce.deswebmob.GeoData.view.MainView;

public class MainViewModel implements ViewModel {
    private Pais model;
    MainView view;

    public final ObservableField<String> nome = new ObservableField<>();
    public final ObservableField<String> capital = new ObservableField<>();
    public final ObservableField<String> regiao = new ObservableField<>();
    public final ObservableField<String> subRegiao = new ObservableField<>();




    public MainViewModel(){model = new Pais();}

    @Override
    public void onCreate() {
        model = new Pais();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void construir(Pais pais){


        model.setNome(pais.getNome());
        model.setCodigo3(pais.getCodigo3());
        model.setCapital(pais.getCapital());
        model.setRegiao(pais.getRegiao());
        model.setSubRegiao(pais.getSubRegiao());
        model.setDemonimo(pais.getDemonimo());
        this.configurarView(pais);
    }


    public Pais configurarView(Pais pais){
        view.configurarView(pais);

        return pais;
    }
}


