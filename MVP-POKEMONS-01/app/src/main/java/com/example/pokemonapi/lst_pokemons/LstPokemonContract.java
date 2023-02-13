package com.example.pokemonapi.lst_pokemons;

import com.example.pokemonapi.entities.Pokemon;

import java.util.ArrayList;

public interface LstPokemonContract {
    public interface View{
        void onSuccessLstPokemon(ArrayList<Pokemon> lstPokemon);
        void onFailureLstPokemon(String err);

    }


    public interface Presenter{
        // CASO DE USO
        void lstPokemon(Pokemon pokemon);
    }


    public interface Model{
        interface onLstPokemonListener{
            void onSuccess(ArrayList<Pokemon> lstPokemon);
            void onFailure(String err);
        }
        void lstPokemonWS(Pokemon pokemon, onLstPokemonListener onLstPokemonListener);
    }
}
