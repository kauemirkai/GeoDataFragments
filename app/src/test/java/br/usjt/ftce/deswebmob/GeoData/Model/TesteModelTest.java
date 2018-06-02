package br.usjt.ftce.deswebmob.GeoData.Model;

import org.junit.Test;

import br.usjt.ftce.deswebmob.GeoData.model.Pais;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */

public class TesteModelTest {
    @Test
    public void testaCalculadora() {
        Pais model = new Pais();
        model.setNome("Test");
        model.setSubRegiao("Test");
        model.setRegiao("test");
        model.setCapital("test");
        assertEquals("Test", model.getNome());
        assertEquals("Test", model.getSubRegiao());
        assertEquals("test", model.getRegiao());
        assertEquals("test", model.getCapital());


    }
}
