package com.example.glovoandroid.lst_restaurantes.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.entities.RestauranteRespuesta;
import com.example.glovoandroid.lst_restaurantes.LstRestaurantContract;

import java.util.ArrayList;

public class LstRestaurantAdapter extends RecyclerView.Adapter<LstRestaurantAdapter.ViewHolder> {
    private ArrayList<Restaurante> dataset;
    private Context mContext;

    public LstRestaurantAdapter(Context mContext, ArrayList<Restaurante> lstRestaurantes){
        this.dataset = lstRestaurantes;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_restaurant,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurante r = dataset.get(position);
        holder.idRestaurante.setText(r.getId());
        holder.nombreRestaurante.setText(r.getNombre());
        holder.direccionRestaurante.setText(r.getDireccion());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idRestaurante;
        private TextView nombreRestaurante;
        private TextView direccionRestaurante;

        public ViewHolder(View itemView) {
            super(itemView);

            idRestaurante = itemView.findViewById(R.id.Id_Restaurante);
            nombreRestaurante = itemView.findViewById(R.id.NombreRestaurante);
            direccionRestaurante = itemView.findViewById(R.id.Direccion);

        }
    }
    public void adicionarListaRestaurante(ArrayList<Restaurante> lstRestaurant) {
        //dataset.addAll(lstRestaurant);
        //notifyDataSetChanged();
    }

}
