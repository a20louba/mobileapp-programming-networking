package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("FieldCanBeLocal")

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private MyAdapter adapter;
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";

    /*
    public ArrayList getMountain() {
        return Mountain;
    }
    */

    private List<Mountain> mountain = new ArrayList<Mountain>();

    private RecyclerView recyclerView;

    @SuppressWarnings("WeakerAccess")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MyAdapter(mountain);
        /*adapter = new MyAdapter(mountain);*/

        new JsonTask(this).execute(JSON_URL);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       // new JsonFile(this, this).execute(JSON_FILE);
    }

    @Override
    public void onPostExecute(String json) {

        Gson gson = new Gson();
        /*mountain = gson.fromJson(json, Mountain.class);*/
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> tempList = gson.fromJson(json, type);
        Log.d("MainActivity", json);
        //List <Mountain> list = new ArrayList<>();
        mountain.addAll(tempList);
        //adapter.setMountains(mountain);
        adapter.notifyDataSetChanged();
    }

}


