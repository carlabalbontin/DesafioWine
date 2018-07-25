package com.cbalt.desafiowine.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cbalt.desafiowine.R;
import com.cbalt.desafiowine.data.Queries;
import com.cbalt.desafiowine.models.Wine;

import java.util.List;

public class WinesAdapter extends RecyclerView.Adapter<WinesAdapter.ViewHolder> {

    private List<Wine> wines = new Queries().wines();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_wine, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Wine wine = wines.get(i);
        viewHolder.wineName.setText(wine.getName());
        viewHolder.wineType.setText(wine.getType());
        viewHolder.wineAge.setText(String.valueOf(wine.getAge()));
    }

    @Override
    public int getItemCount() {
        return wines.size();
    }

    public void addWine(Wine wine){
        wines.add(wine);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView wineType;
        private TextView wineAge;
        private TextView wineName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            wineType = itemView.findViewById(R.id.wineType);
            wineAge = itemView.findViewById(R.id.wineAge);
            wineName = itemView.findViewById(R.id.wineName);
        }
    }
}
