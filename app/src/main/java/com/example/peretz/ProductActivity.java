package com.example.peretz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;



import com.example.peretz.API.APIConfig;
import com.example.peretz.API.APIService;
import com.example.peretz.API.APIServiceConstructor;
import com.example.peretz.API.ResponseData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    // Обзъявление полей
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager ( this);


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_product );


        // Создание
        APIService service=APIServiceConstructor.CreateService ( APIService.class );

        Call<List<ResponseData>> call=service.getDataPeretz ( APIConfig.CATEGORY, APIConfig.KEY );
        call.enqueue ( new Callback<List<ResponseData>> () {

            @Override
            public void onResponse( Call<List<ResponseData>> call, Response<List<ResponseData>> response ) {
                // Если данные прогрузились успешно, то
                if (response.isSuccessful ()) {
                    // Добавь эти данные в List
                    List<ResponseData> responseData = response.body();

                    // Нахождение RecyclerView по id
                    mRecyclerView = findViewById(R.id.recyclerView);
                    // Установка RecyclerView
                    mRecyclerView.setHasFixedSize(true);
                    mAdapter = new MyAdapter (responseData);
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mRecyclerView.setAdapter(mAdapter);
                }

            }




            @Override
            public void onFailure( Call<List<ResponseData>> call, Throwable t ) {


            }
        } );

    }
}