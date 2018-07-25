package com.cbalt.desafiowine;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.cbalt.desafiowine.adapters.WinesAdapter;
import com.cbalt.desafiowine.models.Wine;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WinesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                //dialog.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
                dialog.setContentView(R.layout.dialog_new_wine);

                Button saveBtn = dialog.findViewById(R.id.saveNewWine);
                saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        EditText wineNameInput = dialog.findViewById(R.id.wineNameEt);
                        EditText wineTypeInput = dialog.findViewById(R.id.wineTypeEt);
                        EditText wineAgeInput = dialog.findViewById(R.id.wineAgeEt);

                        String wineName = wineNameInput.getText().toString();
                        String wineType = wineTypeInput.getText().toString();
                        String wineAgeString = wineAgeInput.getText().toString();

                        if (wineName.trim().length() > 0 && wineType.trim().length() > 0 && wineAgeString.trim().length() > 0) {
                            int wineAge = Integer.parseInt(wineAgeString);

                            Wine newWine = new Wine();
                            newWine.setName(wineName);
                            newWine.setType(wineType);
                            newWine.setAge(wineAge);
                            newWine.save();
                            updateList(newWine);
                        }

                        dialog.dismiss();
                    }
                });


                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.wineRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        /*Wine wine1 = new Wine("Santa Carolina", "Cabernet", 10);
        wine1.save();
        Wine wine2 = new Wine("Valdivieso", "Champaña", 1);
        wine2.save();
        Wine wine3 = new Wine("Casillero del Diablo", "Syrah", 15);
        wine3.save();
        Wine wine4 = new Wine("Clos de Pirque", "Cabernet", 3);
        wine4.save();
        Wine wine5 = new Wine("Undurraga", "Champaña", 2);
        wine5.save();*/

        adapter = new WinesAdapter();
        recyclerView.setAdapter(adapter);

    }

    public void updateList(Wine newWine) {
        adapter.addWine(newWine);
        Log.d("NEW_WINE", newWine.getName());
    }
}
