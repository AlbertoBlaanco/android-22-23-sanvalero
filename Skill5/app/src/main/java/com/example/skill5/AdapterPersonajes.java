package com.example.skill5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPersonajes extends RecyclerView.Adapter<AdapterPersonajes.ViewHolderPersonajes>
{
    ArrayList<PersonajeBO> listaPersonajes;

    public AdapterPersonajes(ArrayList<PersonajeBO> listaPersonajes){
        this.listaPersonajes = listaPersonajes;
    }
    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_personalizado,null,false);

        return new ViewHolderPersonajes(view);
    }


    @Override
    public void onBindViewHolder(ViewHolderPersonajes holder, int position) {
        holder.EtiNombre.setText(listaPersonajes.get(position).getNombre());
        holder.EtiInformacion.setText(listaPersonajes.get(position).getDescripcion());
        holder.foto.setImageResource(listaPersonajes.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {
        TextView EtiNombre,EtiInformacion;
        ImageView foto;
        public ViewHolderPersonajes(View itemView) {
            super(itemView);
            EtiNombre=itemView.findViewById(R.id.idNombre);
            EtiInformacion=itemView.findViewById(R.id.idDescripcion);
            foto=itemView.findViewById(R.id.idImagen);
        }
    }
}