package com.example.glovoandroid.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RestauranteRespuesta {

    private ArrayList<Restaurante> results;

    public void setResults(ArrayList<Restaurante> results) {
        this.results = results;
    }

    public ArrayList<Restaurante> getResults() {
        return results;
    }
}
