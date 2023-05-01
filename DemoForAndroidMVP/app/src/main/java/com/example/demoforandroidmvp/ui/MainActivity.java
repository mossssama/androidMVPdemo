package com.example.demoforandroidmvp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.demoforandroidmvp.R;
import com.example.demoforandroidmvp.databinding.ActivityMainBinding;

/* (1,8) MainActivity is view Container */
public class MainActivity extends AppCompatActivity  implements View.OnClickListener, PlayerView{

    ActivityMainBinding binding;
    PlayerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        /* (2) Activate onclickListeners for all buttons */
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);

        presenter = new PlayerPresenter(this);
    }

    /* (3) Handling what happens onClick Listeners */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /* TextView is view V */
            case R.id.button1: presenter.getFullInformation(0);       break;
            case R.id.button2: presenter.getPlayerPosition(1);        break;
            case R.id.button3: presenter.getPlayerDataOfBirth(0);     break;
        }

    }

    @Override
    public void onGetFullInformation(String s) { binding.tv.setText(s); }

    @Override
    public void onGetPlayerDataOfBirth(int index) { binding.tv.setText(index+""); }

    @Override
    public void onGetPlayerPosition(String position) { binding.tv.setText(position); }

}



// [1] let view Container implements View.OnClickListener to allow using single onClick to handle all ClickListeners
// [2] Activate onClickListeners in onCreate of the view Container
// [3] State what will happens onClickListener
// [4] create modelClass for the data you want to be viewed in the views inside your controller

/* [5] Create Presenter class that will contain implementation as the following & make an instance of it in view Container*/

// [6] build a function inside the Presenter to handle getting data from Source
// [7] build functions inside the Presenter to handle using data returned

/* [8] let view Container implements PresenterInterface to allow overriding its methods */