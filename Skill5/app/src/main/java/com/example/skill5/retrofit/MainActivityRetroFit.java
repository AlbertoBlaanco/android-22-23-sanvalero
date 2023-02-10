package com.example.skill5.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.skill5.R;
import com.example.skill5.retrofit.Interface.JsonPlaceHolderApi;
import com.example.skill5.retrofit.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityRetroFit extends AppCompatActivity {
    private TextView mJsonView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_retro_fit);

        mJsonView = (TextView) findViewById(R.id.jsontext);

        getPosts();
    }

    private void getPosts(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Posts>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(!response.isSuccessful()){
                    mJsonView.setText("Codigo: " + response.code());
                    return;
                }

                List<Posts> listPosts = response.body();

                for (Posts posts : listPosts){
                    String content = "";
                    content += "userId:" + posts.getUserId() + "\n";
                    content += "id:" + posts.getId() + "\n";
                    content += "title:" + posts.getTitle() + "\n";
                    content += "body:" + posts.getBody() + "\n\n";

                    mJsonView.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                    mJsonView.setText(t.getMessage());
            }
        });


    }
}