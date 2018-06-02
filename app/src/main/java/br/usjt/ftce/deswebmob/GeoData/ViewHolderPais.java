package br.usjt.ftce.deswebmob.GeoData;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Kaue Victor Paz Garcia Mirkai  - RA: 81613004
 * Turma: CCP3AN-MCA
 * Professor:Bonato
 */


public class ViewHolderPais {
    ImageView bandeira;
    TextView nome, regiao, capital;

    public ViewHolderPais(ImageView bandeira, TextView nome, TextView regiao, TextView capital) {
        this.bandeira = bandeira;
        this.nome = nome;
        this.regiao = regiao;
        this.capital = capital;
    }

    public ImageView getBandeira() {
        return bandeira;
    }

    public void setBandeira(ImageView bandeira) {
        this.bandeira = bandeira;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getRegiao() {
        return regiao;
    }

    public void setRegiao(TextView regiao) {
        this.regiao = regiao;
    }

    public TextView getCapital() {
        return capital;
    }

    public void setCapital(TextView capital) {
        this.capital = capital;
    }
}
