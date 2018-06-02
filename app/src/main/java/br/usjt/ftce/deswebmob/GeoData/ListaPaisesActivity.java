package br.usjt.ftce.deswebmob.GeoData;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */
public class ListaPaisesActivity extends Activity {
    public static final String PAIS_SELECIONADO = "br.usjt.ftce.deswebmob.Geodata.pais_selecionado";
    Activity activity;
    ArrayList<Pais> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        activity = this;
        // Pega o continente que foi selecionado
        Intent intent = getIntent();
        paises = (ArrayList<Pais>) intent.getSerializableExtra(MainActivity.CHAVE);

        // Pega o listView e configura os países do continente selecionado
        ListView listView = (ListView) findViewById(R.id.listViewPaises);
        PaisAdapter adapter = new PaisAdapter(this, paises);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(activity, DetalhePaisActivity.class);
                intent.putExtra(PAIS_SELECIONADO, paises.get(i));
                startActivity(intent);
            }
        });
    }
}
