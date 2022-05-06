package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("FieldCanBeLocal")

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {





    private MyAdapter adapter ;


    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";

    public ArrayList getMountain() {
        return Mountain;
    }

    private ArrayList Mountain;

    private RecyclerView recyclerView;

    @SuppressWarnings("WeakerAccess")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MyAdapter();

        new JsonTask(this).execute(JSON_URL);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       // new JsonFile(this, this).execute(JSON_FILE);
    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Mountain mountain[] = gson.fromJson(json, Mountain[].class);
        Log.d("MainActivity", json);
        List <Mountain> list = new ArrayList<>();
        for(int i = 0; i < mountain.length; i++){
            list.add(mountain[i]);

        }
        adapter.setMountains(list);
        adapter.notifyDataSetChanged();
    }

}


