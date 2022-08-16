package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    public int id;
    public int numFondo=0;
    public int maxFondo=30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonAnterior=findViewById(R.id.btnAnterior);
        Button buttonSiguiente=findViewById(R.id.btnSiguiente);
        Button buttonSetWallpaper=findViewById(R.id.btnSetWallpapers);

        ImageView imPreview=findViewById(R.id.ivPreview);


        imPreview.setImageResource(R.drawable.fondo1);

        numFondo=1;
        id = R.drawable.fondo1;

            
        buttonSetWallpaper.setOnClickListener(new View.OnClickListener() 
        {
          @Override
          public void onClick(View view) 
          {
              WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
              try {
                  wallpaperManager.setResource(id);
              } 
              
              catch (IOException e) {
                  e.printStackTrace();
              }
          }

        }
        );

        buttonSiguiente.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View view) 
            {
                numFondo++;
                if (numFondo > maxFondo)
                    numFondo = 1;

                id = getResources().getIdentifier("fondo"+numFondo, "drawable", getPackageName());
                imPreview.setImageResource(id);

            }
        });

        buttonAnterior.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View view) 
            {
                numFondo--;
                if (numFondo == 0)
                    numFondo = 30;


                id = getResources().getIdentifier("fondo"+numFondo, "drawable", getPackageName());
                imPreview.setImageResource(id);

            }
            
        });

    }




    }
