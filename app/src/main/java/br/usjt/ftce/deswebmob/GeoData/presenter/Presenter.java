package br.usjt.ftce.deswebmob.GeoData.presenter;

public interface Presenter {
    void onCreate();
    void onStart();
    void onRestart();
    void onPause();
    void onStop();
    void onResume();
    void onDestroy();
}
