package com.varun.mvc_java_drinksapp.controller;

import android.view.View;

import com.varun.mvc_java_drinksapp.model.DrinksModel;
import com.varun.mvc_java_drinksapp.view.MainActivity;

public class MainController {

    private final DrinksModel drinksModel;
    private final MainActivity mainActivity;

    public MainController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        drinksModel = new DrinksModel(this);
    }
    public void suggestDrinkController(){
        this.mainActivity.progressBar.setVisibility(View.VISIBLE);
        drinksModel.suggestDrinkModel();
    }

    public void onDrinkSuggested(String drinkName){
        this.mainActivity.tvDrinkName.setText(drinkName);
        this.mainActivity.progressBar.setVisibility(View.INVISIBLE);
    }
}
