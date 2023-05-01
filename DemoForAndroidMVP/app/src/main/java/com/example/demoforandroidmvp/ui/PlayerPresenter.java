package com.example.demoforandroidmvp.ui;

import com.example.demoforandroidmvp.pojo.PlayerModel;

import java.util.ArrayList;

/*(5) PlayerPresenter is Presenter P */
public class PlayerPresenter {

    PlayerView playerView;

    public PlayerPresenter(PlayerView playerView) {
        this.playerView = playerView;
    }


    /* (6) This function should return data from Source
    Source could be from { JavaObject - SharedPrefs - SQLite - Room - API }  Here the source is plain java object
    */
    public ArrayList<PlayerModel> getDataFromSource(){
        ArrayList<PlayerModel> data = new ArrayList();
        data.add(new PlayerModel("LeoMessi","PlayMaker",1987));
        data.add(new PlayerModel("Cristiano","Striker",1985));
        return data;
    }

    /* (7) Functions to handle the returned data; they call the presenter's interface methods */
    public void getFullInformation(int index){ playerView.onGetFullInformation("Name: "+getDataFromSource().get(index).getName()+", Position: "+getDataFromSource().get(index).getPosition()+", BirthYear: "+getDataFromSource().get(index).getYearOfBirth()); }

    public void getPlayerPosition(int index){ playerView.onGetPlayerPosition(getDataFromSource().get(index).getPosition()); }

    public void getPlayerDataOfBirth(int index){ playerView.onGetPlayerDataOfBirth(getDataFromSource().get(index).getYearOfBirth()); }

}
