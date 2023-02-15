package com.example.pokemonapi.lst_pokemons.model;

import com.example.pokemonapi.entities.Pokemon;
import com.example.pokemonapi.entities.PokemonRespuesta;
import com.example.pokemonapi.lst_pokemons.LstPokemonContract;
import com.example.pokemonapi.utils.ApiClient;
import com.example.pokemonapi.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstModelPokemon implements LstPokemonContract.Model {
    @Override
    public void lstPokemonWS(Pokemon pokemon, onLstPokemonListener onLstPokemonListener) {
            /*onLstPokemonListener.onSuccess();
            onLstPokemonListener.onFailure();*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<PokemonRespuesta> call = apiService.getPokemons(20,20);
        call.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                PokemonRespuesta pokemonRespuesta = response.body();
                ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();
                onLstPokemonListener.onSuccess(listaPokemon);

            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                onLstPokemonListener.onFailure("Error de Pokemons.");
            }
        });

    }
}
