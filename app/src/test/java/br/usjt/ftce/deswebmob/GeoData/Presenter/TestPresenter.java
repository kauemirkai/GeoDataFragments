package br.usjt.ftce.deswebmob.GeoData.Presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.usjt.ftce.deswebmob.GeoData.model.Pais;
import br.usjt.ftce.deswebmob.GeoData.presenter.MainPresenter;
import br.usjt.ftce.deswebmob.GeoData.view.MainView;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */

@RunWith(MockitoJUnitRunner.class)
public class TestPresenter {
    private MainPresenter presenter;

    @Mock
    private MainView view;

    @Before
    public void setup() {
        presenter = new MainPresenter(view);
    }

    @Test
    public void testPresenter(){
        Pais pais = new Pais();
        pais.setNome("test");
        pais.setCapital("test");
        presenter.construir(pais);
        Pais paistest = presenter.configurarView(pais);

        assertEquals("test",pais.getNome());
        assertEquals("test", paistest.getNome());

    }
}
