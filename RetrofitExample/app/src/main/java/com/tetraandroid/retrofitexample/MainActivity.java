package com.tetraandroid.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tetraandroid.retrofitexample.http.TwitchAPI;
import com.tetraandroid.retrofitexample.http.apimodel.APISS;
import com.tetraandroid.retrofitexample.root.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    TwitchAPI twitchAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);

        Call<APISS> call = twitchAPI.getTopGames("glm4y8j3jeo9gk37wjoe3qaiewxz9w");

        call.enqueue(new Callback<APISS>() {
            @Override
            public void onResponse(Call<APISS> call, Response<APISS> response) {
                List<APISS.TopEntity> gameList = response.body().getTop();

                for (APISS.TopEntity top : gameList){
                    System.out.println(top.getGame().getName());
                }
            }

            @Override
            public void onFailure(Call<APISS> call, Throwable t) {
                     t.printStackTrace();
            }
        });

    }
}
