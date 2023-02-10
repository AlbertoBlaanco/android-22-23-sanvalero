package com.example.skill5.mvvmretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.skill5.AdapterPersonajes;
import com.example.skill5.PersonajeBO;
import com.example.skill5.R;

import java.util.ArrayList;

public class AdapterRetrofit extends RecyclerView.Adapter<AdapterRetrofit.ViewHolderRetrofit> {

    ArrayList<PersonajeBO> listaPersonajes;

    public AdapterRetrofit(ArrayList<PersonajeBO> listaPersonajes){
        this.listaPersonajes = listaPersonajes;
    }
    @Override
    public ViewHolderRetrofit onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_personalizado,null,false);

        return new AdapterRetrofit.ViewHolderRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRetrofit holder, int position) {

    }


   // @Override
    //public void onBindViewHolder(AdapterPersonajes.ViewHolderPersonajes holder, int position) {
        //holder.EtiNombre.setText(listaPersonajes.get(position).getNombre());
        //holder.EtiInformacion.setText(listaPersonajes.get(position).getDescripcion());
        //holder.foto.setImageResource(listaPersonajes.get(position).getFoto());

    //}

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public class ViewHolderRetrofit extends RecyclerView.ViewHolder {
        TextView EtiNombre,EtiInformacion;
        ImageView foto;
        public ViewHolderRetrofit(View itemView) {
            super(itemView);
            EtiNombre=itemView.findViewById(R.id.idNombre);
            EtiInformacion=itemView.findViewById(R.id.idDescripcion);
            foto=itemView.findViewById(R.id.idImagen);
        }
    }
}
