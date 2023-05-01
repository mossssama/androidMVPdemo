package com.example.demoforandroidmvp.ui;

public interface PlayerView {

    /* (7) Functions to handle the returned data */
    void onGetFullInformation(String s);
    void onGetPlayerDataOfBirth(int index);
    void onGetPlayerPosition(String position);

}
