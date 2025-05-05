package com.varun.mvc_java_drinksapp.view;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.varun.mvc_java_drinksapp.R;
import com.varun.mvc_java_drinksapp.controller.MainController;

public class MainActivity extends AppCompatActivity {

   public TextView tvDrinkName, tvLoginResult;
   public ProgressBar progressBar;
   public Button bGetDrink;

   MainController mainController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDrinkName = findViewById(R.id.tvDrinkName);
        progressBar = findViewById(R.id.progressBar);
        bGetDrink = findViewById(R.id.bGetDrink);

        mainController = new MainController(this);

        bGetDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainController.suggestDrinkController();
            }
        });

    }
}
