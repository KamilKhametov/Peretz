package com.example.peretz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.peretz.API.ResponseData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ExampleViewHolder> {

    static int a;
    static int sum=0;
    private List<ResponseData> mExampleList;


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        // Объявление полей
        public ImageView imageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public Button btn_plus;
        public Button btn_minus;
        public TextView text_sum;


        public ExampleViewHolder( View itemView ) {
            super ( itemView );

            // Нахождение полей по id
            imageView=itemView.findViewById ( R.id.imageView );
            mTextView1=itemView.findViewById ( R.id.text_name );
            mTextView2=itemView.findViewById ( R.id.text_desc );
            mTextView3=itemView.findViewById ( R.id.text_price );

            btn_plus=itemView.findViewById ( R.id.btn_plus );
            btn_minus=itemView.findViewById ( R.id.btn_minus );
            text_sum=itemView.findViewById ( R.id.text_sum );


        }


        public void bind( ResponseData responseData ) {
            // Получение данных с API
            // Получение имени с API
            mTextView1.setText ( responseData.getName () );
            // Получение описания с API
            mTextView2.setText ( responseData.getDescription () );
            // Получение цен C API
            int price=responseData.getPrice ();
            // Преобразование int-цена в String для установки цены в TextView
            String priceNew=String.valueOf ( price );
            mTextView3.setText ( priceNew + " ₽" );


            // Получение изображения с API с помощью библиотеки Picasso
            String url=responseData.getImage ();
            Picasso.with ( itemView.getContext () ).load ( url ).into ( imageView );


            // Скрытие кнопки -
            btn_minus.setVisibility ( View.GONE );
            text_sum.setVisibility ( View.GONE );

            a=responseData.getSort ();
            a=0;

            // Кликер + и - товаров
            // Нажатие на кнопку плюс
            btn_plus.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick( View v ) {
                    int number = Integer.parseInt ( text_sum.getText ().toString () ) + 1;
                    text_sum.setText ( String.valueOf ( number ) );
                    text_sum.setVisibility ( View.VISIBLE );
                    btn_minus.setVisibility ( View.VISIBLE );

                }
            } );

            // Нажатие на кнопку минус
            btn_minus.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick( View v ) {
                    if(Integer.parseInt ( text_sum.getText ().toString ()  ) > 0) {
                        int number=Integer.parseInt ( text_sum.getText ().toString () ) - 1;
                        text_sum.setText ( String.valueOf ( number ) );
                        if(Integer.parseInt ( text_sum.getText ().toString () ) == 0){
                            text_sum.setVisibility ( View.GONE );
                            btn_minus.setVisibility ( View.GONE );
                        }
                    }

                }
            } );

        }


    }

    public MyAdapter( List<ResponseData> exampleList ) {
        this.mExampleList=exampleList;

    }

    @Override
    public ExampleViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
        // Раздувание layout'a
        View v=LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.item_layout, parent, false );
        ExampleViewHolder evh=new ExampleViewHolder ( v );
        return evh;


    }


    @Override
    public void onBindViewHolder( ExampleViewHolder holder, int position ) {
        // Получение данных с arrayList по позиции
        holder.bind ( mExampleList.get ( position ) );


    }


    @Override
    public int getItemCount() {
        // Возвращаем размер ArrayList'a
        return mExampleList.size ();
    }
}