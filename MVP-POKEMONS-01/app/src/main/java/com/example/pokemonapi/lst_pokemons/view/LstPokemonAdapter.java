package com.example.pokemonapi.lst_pokemons.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapi.R;
import com.example.pokemonapi.entities.Pokemon;

public class LstPokemonAdapter extends RecyclerView.Adapter<LstPokemonAdapter.ViewHolder>{

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());

        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + p.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    /*VIEW HOLDER*/
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoImageView;
        private TextView nombreTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            fotoImageView = itemView.findViewById(R.id.fotoImageView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);

        }
    }
}
