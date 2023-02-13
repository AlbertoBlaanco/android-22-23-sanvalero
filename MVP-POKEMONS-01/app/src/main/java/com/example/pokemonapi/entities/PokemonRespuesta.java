package com.example.pokemonapi.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PokemonRespuesta {

    @SerializedName("results")
    private ArrayList<Pokemon> results;

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }
}
