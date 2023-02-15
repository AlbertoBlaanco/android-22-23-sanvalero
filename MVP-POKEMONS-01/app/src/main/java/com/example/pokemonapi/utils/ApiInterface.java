package com.example.pokemonapi.utils;


import com.example.pokemonapi.entities.Pokemon;
import com.example.pokemonapi.entities.PokemonRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    /*@GET("pokemon")
    Call<ArrayList<Pokemon>> getPokemons();*/

    /*https://pokeapi.co/api/v2/pokemon/?limit=20&offset=20*/
    @GET("pokemon")
    Call<PokemonRespuesta> getPokemons(@Query("limit") int limit, @Query("offset") int offset);
}
