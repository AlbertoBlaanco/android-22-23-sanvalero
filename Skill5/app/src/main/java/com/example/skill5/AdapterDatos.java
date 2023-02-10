package com.example.skill5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos>
{
    ArrayList<String> listDatos;

    public AdapterDatos(ArrayList<String> listDatos){
        this.listDatos = listDatos;
    }
    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,null,false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
            TextView dato;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato=itemView.findViewById(R.id.idDato);
        }
        public void asignarDatos(String datos){
            dato.setText(datos);
        }
    }
}
