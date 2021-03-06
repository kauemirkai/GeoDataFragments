package br.usjt.ftce.deswebmob.GeoData.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ftce.deswebmob.GeoData.R;
import br.usjt.ftce.deswebmob.GeoData.model.Pais;
import br.usjt.ftce.deswebmob.GeoData.model.PaisDb;
import br.usjt.ftce.deswebmob.GeoData.model.PaisesNetworking;
import br.usjt.ftce.deswebmob.GeoData.viewModel.MainViewModel;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */


public class MainActivity extends Activity implements MainView {
    Spinner spinner;
    String continente = "";
    Context contexto;
    MainViewModel viewModel = new MainViewModel();



    public static final String CHAVE = "br.usjt.ftce.deswebmob.dadosmundi.paises";


    @Override
    public Pais configurarView(Pais paises) {
        viewModel.configurarView(paises);
        return paises;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto = this;

        // Pega o spinner do layout
        spinner = (Spinner) findViewById(R.id.spinnerContinentes);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //
                continente = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        viewModel.onCreate();

    }

    public void listarPaises(View view) {
        /*
        * Se não escolher nenhum, pega todos os países
        * Caso contrário ele pega da region (continente) que selecionou:
        *
        * Documentaçâo:
        * REGION
            Search by region: Africa, Americas, Asia, Europe, Oceania
            e.g. https://restcountries.eu/rest/v2/region/europe
        * */
        String finalUrl;
        if (continente == "" || continente.equals("Todos")) {
            finalUrl = "all";
        } else {
            finalUrl = "region/" + continente.toLowerCase();
        }

        // Se tiver internet, baixa o json e popula o banco, caso contrário tenta pegar o que já tem
        if (PaisesNetworking.isConnected(this)) {
            new DownloadJsonPaises().execute("https://restcountries.eu/rest/v2/" + finalUrl);
        } else {
            new BuscaBancoPaises().execute();
        }

    }


    // Classe para a thread que busca o JSON que vai vir pelo serviço
    private class DownloadJsonPaises extends AsyncTask<String, Void, ArrayList<Pais>> {

        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> paises = new ArrayList<>();

            try {
                // Busca o JSON
                paises = PaisesNetworking.buscarPaises(strings[0]);
                // Popula o banco do SQLite
                PaisDb paisDb = new PaisDb(contexto);
                paisDb.inserirPais(paises);


            } catch (IOException | SQLiteException e) {
                e.printStackTrace();
            }

            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises) {
            Intent intent = new Intent(contexto, ListaPaisesActivity.class);
            intent.putExtra(CHAVE, paises);
            startActivity(intent);
        }
    }

    // Classe para buscar os paises do SQLite
    private class BuscaBancoPaises extends AsyncTask<String, Void, ArrayList<Pais>> {

        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> paises = new ArrayList<>();

            try {
                // Popula o banco do SQLite
                PaisDb paisDb = new PaisDb(contexto);

                // Só pega os países do continente selecionado (ou todos)
                if (continente.equals("Todos")) {
                    paises = paisDb.listarPaises();
                } else {
                    paises = paisDb.listarPaises(continente);
                }

            } catch (SQLiteException e) {
                e.printStackTrace();
            }

            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises) {
            Intent intent = new Intent(contexto, ListaPaisesActivity.class);
            intent.putExtra(CHAVE, paises);
            startActivity(intent);
        }
    }
}
