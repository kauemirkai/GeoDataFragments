package br.usjt.ftce.deswebmob.GeoData;

import android.provider.BaseColumns;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */
public final class PaisDbContract {

    public PaisDbContract() {}

    public static abstract class PaisBanco implements BaseColumns {

        public static final String TABLE_NAME = "Pais";
        public static final String NOME = "nome";
        public static final String CODIGO3 = "codigo3";
        public static final String CAPITAL = "capital";
        public static final String REGIAO = "regiao";
        public static final String SUBREGIAO = "subRegiao";
        public static final String DEMONIMO = "demonimo";
        public static final String POPULACAO ="populacao";
        public static final String AREA = "area";
        public static final String GINI = "gini";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";

    }

}
