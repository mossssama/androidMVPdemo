# androidMVPdemo
Demo for How to use MVP architecture pattern in android using Java language

[1] **Model** is the model class  
[2] **View** is the view that display data like editText,textView,listView   
[3] **Presenter** is the class contains logic used to present data to view

The Controller of the View in MVC = The Container of the View in MVP

**In this demo** Model is **PlayerModel**, View is **TextView**(tv), Presenter is **PlayerPresenter**
# **Usage**
***
[1] **Let Container implements View.OnClickListener to allow using single onClick to handle all ClickListeners**

    implements View.OnClickListener
    
[2] **Activate onClickListeners in onCreate of the Controller**    

    binding.button1.setOnClickListener(this);
    binding.button2.setOnClickListener(this);
    binding.button3.setOnClickListener(this);
    
[3] **State what will happens onClickListener**

      @Override
      public void onClick(View v) {
          switch (v.getId()){
              /* TextView is view V */
              case R.id.button1: binding.tv.setText(0);        break;
              case R.id.button2: binding.tv.setText(1);        break;
              case R.id.button3: binding.tv.setText(1);        break;
          }

      }

[4] **Create [model class](https://github.com/mossssama/androidMVCdemo/blob/main/DemoForAndroidMVP/app/src/main/java/com/example/demoforandroidmvc/pojo/PlayerModel.java) representing the data scheme**
      
[5] **Create [Presenter class](https://github.com/mossssama/androidMVPdemo/blob/main/DemoForAndroidMVP/app/src/main/java/com/example/demoforandroidmvp/ui/PlayerPresenter.java) that will contain implementation of the following 2 points[6,7] & make an instance of it in Container**    

[6] **Build a function inside the Presenter to handle getting data from Source**    

    /* (6) This function should return data from Source
      Source could be from { JavaObject - SharedPrefs - SQLite - Room - API }  Here the source is plain java object
    */
    public ArrayList<PlayerModel> getDataFromSource(){
        ArrayList<PlayerModel> data = new ArrayList();
        data.add(new PlayerModel("LeoMessi","PlayMaker",1987));
        data.add(new PlayerModel("Cristiano","Striker",1985));
        return data;
    }
    
    
[7] **Create [Presenter interface](https://github.com/mossssama/androidMVPdemo/blob/main/DemoForAndroidMVP/app/src/main/java/com/example/demoforandroidmvp/ui/PlayerPresenter.java) that contains the functions that will be overriden in the Container**    

    /* (7) Functions to handle the returned data */
    void onGetFullInformation(String s);
    void onGetPlayerDataOfBirth(int index);
    void onGetPlayerPosition(String position);
    

[8] **Build functions inside the Presenter to handle using data returned**
    
    /* (8) Functions to handle the returned data; they call the presenter's interface methods */
    public void getFullInformation(int index){ playerView.onGetFullInformation("Name: "+getDataFromSource().get(index).getName()+", Position: "+getDataFromSource().get(index).getPosition()+", BirthYear: "+getDataFromSource().get(index).getYearOfBirth()); }

    public void getPlayerPosition(int index){ playerView.onGetPlayerPosition(getDataFromSource().get(index).getPosition()); }

    public void getPlayerDataOfBirth(int index){ playerView.onGetPlayerDataOfBirth(getDataFromSource().get(index).getYearOfBirth()); }


[9] **Let Controller also implements Presenter interface to allow overriding its methods**

    implements View.OnClickListener, PlayerView
    
    
[10] **Override Presenter interface functions in Container**

    @Override
    public void onGetFullInformation(String s) { binding.tv.setText(s); }

    @Override
    public void onGetPlayerDataOfBirth(int index) { binding.tv.setText(index+""); }

    @Override
    public void onGetPlayerPosition(String position) { binding.tv.setText(position); }
    

