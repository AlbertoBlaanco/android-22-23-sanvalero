package com.example.glovoandroid.register;

import com.example.glovoandroid.entities.Usuario;

public interface RegisterContract {


    public interface View{
        void onSuccessRegister(Usuario user);
        void onFailureRegister(String err);
    }
    public interface Presenter{
        //Register del usuario
        void register(Usuario usuario);
    }
    public interface Model{
        interface onRegisterListener{
            void onSuccess(Usuario user);
            void onFailure(String err);
        }
        void registerWS(Usuario user, RegisterContract.Model.onRegisterListener onRegisterListener);
    }
}
