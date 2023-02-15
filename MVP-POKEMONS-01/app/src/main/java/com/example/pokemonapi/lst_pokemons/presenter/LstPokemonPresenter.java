package com.example.pokemonapi.lst_pokemons.presenter;

import com.example.pokemonapi.entities.Pokemon;
import com.example.pokemonapi.lst_pokemons.LstPokemonContract;
import com.example.pokemonapi.lst_pokemons.model.LstModelPokemon;

import java.util.ArrayList;

public class LstPokemonPresenter implements LstPokemonContract.Presenter {
    private LstModelPokemon lstPokemonModel;
    private LstPokemonContract.View view;

    public LstPokemonPresenter(LstPokemonContract.View view){
            this.view = view;
            this.lstPokemonModel = new LstModelPokemon();
    }
    @Override
    public void lstPokemon(Pokemon pokemon) {
            lstPokemonModel.lstPokemonWS(null, new LstPokemonContract.Model.onLstPokemonListener() {
                @Override
                public void onSuccess(ArrayList<Pokemon> lstPokemon) {
                    if(lstPokemon!=null && lstPokemon.size()>0){
                        view.onSuccessLstPokemon(lstPokemon);
                    }
                }

                @Override
                public void onFailure(String err) {
                        view.onFailureLstPokemon("Error en Datos Pokemon.");
                }
            });
    }
}
