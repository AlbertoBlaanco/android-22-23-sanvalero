package com.example.pokemonapi.entities;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
    /*
    "name": "bulbasaur",
            "url": "https://pokeapi.co/api/v2/pokemon/1/"
    * */
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @Override
    public String toString() {
        return "Simpson{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}
