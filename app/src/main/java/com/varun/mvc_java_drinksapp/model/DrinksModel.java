package com.varun.mvc_java_drinksapp.model;

import android.os.Handler;
import android.os.Looper;

import com.varun.mvc_java_drinksapp.controller.MainController;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DrinksModel {
    String[] drinksListRemote = {"Spiking coffee", "Sweet Bananas", "Tomato Tang",
            "Apple Berry Smoothie", "Coding Reel Coffee"};

    private final MainController mainController;
    public DrinksModel(MainController controller){
        this.mainController = controller;
    }
    public void suggestDrinkModel() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        final String[] drinkName = {""};
        //Before executing background task

        executor.execute(new Runnable() {
            @Override
            public void run() {

                //Background work here
                try {
                    Thread.sleep(1000); // Mimic server request / long execution
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                drinkName[0] = drinksListRemote[new Random()
                            .nextInt(drinksListRemote.length)];
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                    mainController.onDrinkSuggested(drinkName[0]);
                    }
                });
            }
        });
    }
}
