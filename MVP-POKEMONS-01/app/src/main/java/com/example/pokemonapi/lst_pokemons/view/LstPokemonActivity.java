package com.example.pokemonapi.lst_pokemons.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pokemonapi.R;
import com.example.pokemonapi.entities.Pokemon;
import com.example.pokemonapi.lst_pokemons.LstPokemonContract;

import java.util.ArrayList;

public class LstPokemonActivity extends AppCompatActivity implements LstPokemonContract.View {
    private LstPokemonAdapter lstPokemonAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_pokemons);
    }

    @Override
    public void onSuccessLstPokemon(ArrayList<Pokemon> lstPokemon) {
        //lstPokemonAdapter.adicionarListaPokemon(lstPokemon);
    }

    @Override
    public void onFailureLstPokemon(String err) {

    }
}