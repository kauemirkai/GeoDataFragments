package br.usjt.ftce.deswebmob.GeoData.presenter;



import br.usjt.ftce.deswebmob.GeoData.model.Pais;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */


import br.usjt.ftce.deswebmob.GeoData.view.MainView;

public class MainPresenter implements Presenter {
    private Pais model;
    MainView view;

    public MainPresenter(MainView view){
        this.view = view;
        model = new Pais();//para funcionar nos testes;
    }

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


