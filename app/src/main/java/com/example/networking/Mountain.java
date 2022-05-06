package com.example.networking;
//[{"ID":"mobilprog_k2","name":"K2","type":"brom","company":"","location":"The Karakoram range","category":"",
// "size":8611,"cost":28251,"auxdata":{"wiki":"https://en.wikipedia.org/wiki/K2","img":
// "https://en.wikipedia.org/wiki/K2#/media/File:K2_2006b.jpg"}}

import com.google.gson.annotations.SerializedName;

public class Mountain {
    public String getName() {
        return name;
    }

    Mountain(String name){
        this.name = name;
    }

    @SerializedName("ID")
    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    @SerializedName("size")
    private String size;
    private Auxdata auxdata;

}
