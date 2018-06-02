package br.usjt.ftce.deswebmob.GeoData.Presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.usjt.ftce.deswebmob.GeoData.model.Pais;
import br.usjt.ftce.deswebmob.GeoData.viewModel.MainViewModel;
import br.usjt.ftce.deswebmob.GeoData.view.MainView;

import static junit.framework.Assert.assertEquals;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */

@RunWith(MockitoJUnitRunner.class)
public class TestViewModel {
    private MainViewModel viewModel;


    @Before
    public void setup() {
        viewModel = new MainViewModel();
    }

    @Test
    public void testPresenter(){
        Pais pais = new Pais();
        pais.setNome("test");
        pais.setCapital("test");
        viewModel.construir(pais);
        Pais paistest = viewModel.configurarView(pais);

        assertEquals("test",pais.getNome());
        assertEquals("test", paistest.getNome());

    }
}
