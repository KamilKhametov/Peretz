package com.example.peretz.API;

import java.util.List;


import com.example.peretz.MyAdapter;
import com.google.gson.annotations.SerializedName;


public class ResponseData {

    @SerializedName("id")
    private int id;
    @SerializedName("date")

    private String date;
    @SerializedName("name")

    private String name;
    @SerializedName("description")

    private String description;
    @SerializedName("new")

    private boolean _new;
    @SerializedName("variations")

    private List<Object> variations=null;
    @SerializedName("price")

    private int price;
    @SerializedName("image_app")

    private String imageApp;
    @SerializedName("image")

    private String image;
    @SerializedName("sort")

    private int sort;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id=id;
    }

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name=name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description=description;
    }

    public boolean isNew() {
        return _new;
    }

    public void setNew( boolean _new ) {
        this._new=_new;
    }

    public List<Object> getVariations() {
        return variations;
    }

    public void setVariations( List<Object> variations ) {
        this.variations=variations;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice( int price ) {
        this.price=price;
    }

    public String getImageApp() {
        return imageApp;
    }

    public void setImageApp( String imageApp ) {
        this.imageApp=imageApp;
    }

    public String getImage() {
        return image;
    }

    public void setImage( String image ) {
        this.image=image;
    }

    public int getSort() {
        return sort;
    }

    public void setSort( int sort ) {
        this.sort = sort ;
    }


}
