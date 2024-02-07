package be.davygevaert.gentsefeesten;

import androidx.appcompat.app.AppCompatActivity;
import be.davygevaert.gentsefeesten.asynctasks.JsonTaskCategorieen;
import be.davygevaert.gentsefeesten.asynctasks.JsonTaskEvenementen;
import be.davygevaert.gentsefeesten.databank.EventDB;
import be.davygevaert.gentsefeesten.model.Event;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends AppCompatActivity {

    private Context context;
    Button btnHit;
    ProgressDialog pd;

    private final String EVENEMENTEN = "https://data.stad.gent/api/explore/v2.1/catalog/datasets/gentse-feesten-evenementen-2023/exports/json?lang=nl&timezone=Europe%2FBrussels";
    private final String CATEGORIEEN = "https://data.stad.gent/api/explore/v2.1/catalog/datasets/gentse-feesten-themas-2023/exports/json?lang=nl&timezone=Europe%2FBrussels";
    private final String ORGANISATOREN = "https://data.stad.gent/api/explore/v2.1/catalog/datasets/gentse-feesten-organisatoren-2022/exports/json?lang=nl&timezone=Europe%2FBrussels";
    private final String LOCATIES = "https://data.stad.gent/api/explore/v2.1/catalog/datasets/gentse-feesten-locaties-2022/exports/json?lang=nl&timezone=Europe%2FBrussels";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        // set context to this getActivity()
        context = this;

        btnHit = findViewById(R.id.btnHit);

        // Executor ??? or Runnable

        // if db not exists
        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTaskEvenementen(context, pd).execute(EVENEMENTEN);
                new JsonTaskCategorieen(context, pd).execute(CATEGORIEEN);
            }
        });

        // else if db exists go to MainActivity
    }


}