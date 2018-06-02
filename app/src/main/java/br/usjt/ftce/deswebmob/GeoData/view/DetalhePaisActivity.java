package br.usjt.ftce.deswebmob.GeoData.view;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.ftce.deswebmob.GeoData.R;
import br.usjt.ftce.deswebmob.GeoData.model.Pais;
import br.usjt.ftce.deswebmob.GeoData.model.Util;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */

public class DetalhePaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);

        android.app.FragmentManager fm = getFragmentManager();

     /*   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        //primeira chamada ao método onCreate
        */
        if (savedInstanceState == null) {
            //começa a transação
            FragmentTransaction ft = fm.beginTransaction();
            DetalhePaisFragment hwf = new DetalhePaisFragment();
            //adiciona
            ft.add(R.id.detalhe_pais_fragment, hwf, "DetalhePaisFragmentTag");
            //confirma e fecha a transação
            ft.commit();
        }

        Intent intent = getIntent();
        Pais pais = (Pais) intent.getSerializableExtra(ListaPaisesActivity.PAIS_SELECIONADO);

        TextView txtNomePais = (TextView) findViewById(R.id.txtNomePais);
        txtNomePais.setText(pais.getNome());

        TextView txtCodigo3 = (TextView) findViewById(R.id.txtCodigo3);
        txtCodigo3.setText(pais.getCodigo3());

        TextView txtRegiao = (TextView) findViewById(R.id.txtRegiao);
        txtRegiao.setText(pais.getRegiao());

        TextView txtCapital = (TextView) findViewById(R.id.txtCapital);
        txtCapital.setText(pais.getCapital());

        TextView txtSubRegiao = (TextView) findViewById(R.id.txtSubRegiao);
        txtSubRegiao.setText(pais.getSubRegiao());

        TextView txtDemonimo = (TextView) findViewById(R.id.txtDemonimo);
        txtDemonimo.setText(pais.getDemonimo());

        TextView txtPopulacao = (TextView) findViewById(R.id.txtPopulacao);
        txtPopulacao.setText(String.format("%1$,d", pais.getPopulacao()));

        TextView txtArea = (TextView) findViewById(R.id.txtArea);
        txtArea.setText(String.format("%1$,d km\u00B2", pais.getArea()));

        TextView txtGini = (TextView) findViewById(R.id.txtGini);
        txtGini.setText(String.format("%.2f", pais.getGini()));

        TextView txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLatitude.setText(String.format("%.2f", pais.getLatitude()));

        TextView txtLongitude = (TextView) findViewById(R.id.txtLongitude);
        txtLongitude.setText(String.format("%.2f", pais.getLongitude()));

        TextView txtTodasInformacoes = (TextView) findViewById(R.id.txtTodasInformacoes);
        txtTodasInformacoes.setText(pais.toString());

        ImageView bandeira = (ImageView) findViewById(R.id.imagemBandeira);
        bandeira.setImageDrawable(Util.getDrawable(this, pais.getCodigo3().toLowerCase()));

    }
}
