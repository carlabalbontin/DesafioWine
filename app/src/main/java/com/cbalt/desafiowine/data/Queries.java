package com.cbalt.desafiowine.data;

import com.cbalt.desafiowine.models.Wine;

import java.util.ArrayList;
import java.util.List;

public class Queries {

    public List<Wine> wines(){
        List<Wine> wines = new ArrayList<>();
        List<Wine> wineList = Wine.listAll(Wine.class);

        if(wineList != null && wineList.size() > 0 ){
            wines.addAll(wineList);
        }

        return wines;

    }


}
