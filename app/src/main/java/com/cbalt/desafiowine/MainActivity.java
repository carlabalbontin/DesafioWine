package com.cbalt.desafiowine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cbalt.desafiowine.adapters.WinesAdapter;
import com.cbalt.desafiowine.models.Wine;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.wineRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        /*List<Wine> wines = new ArrayList<>();*/

        Wine wine1 = new Wine("Santa Carolina", "Cabernet", 10);
        wine1.save();
        Wine wine2 = new Wine("Valdivieso", "Champaña", 1);
        wine2.save();
        Wine wine3 = new Wine("Casillero del Diablo", "Syrah", 15);
        wine3.save();
        Wine wine4 = new Wine("Clos de Pirque", "Cabernet", 3);
        wine4.save();
        Wine wine5 = new Wine("Undurraga", "Champaña", 2);
        wine5.save();

        WinesAdapter adapter = new WinesAdapter();
        recyclerView.setAdapter(adapter);

    }
}
