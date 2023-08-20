package com.deepan;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import com.google.gson.*;

public class CountryConsoleApp {

    public static void main(String[] args) {
        System.out.println("Country App");
        System.out.println("===================");

        OkHttpClient client = new OkHttpClient.Builder().build();


        Request request = new Request.Builder()
                .url("https://restcountries.com/v3.1/all")
                .addHeader("apiKey","")
                .method("GET",null)
                .build();

        try {
            Response response = client.newCall(request).execute();

            String countriesString = response.body().string();
//            string representation of json array

            JsonArray jsonArray = new Gson().fromJson(countriesString,JsonArray.class);

            for(JsonElement countryElement: jsonArray){

//                converted to JsonObject from JsonElement
                JsonObject countryObject = countryElement.getAsJsonObject();
                JsonObject nameObject = countryObject.getAsJsonObject("name");
                JsonPrimitive official = nameObject.getAsJsonPrimitive("official");
                System.out.println(official);
            }


        } catch (IOException e) {
            System.out.println("Request Failed");
        }
    }
}


//https://restcountries.com/v3.1/all
//okhttp

//client sending the request
//request  preparing the request
//response refers to the response

//send the request

//get the response

//process the result

//json to java object

//java object to json


//gson

//Array ---  JsonArray
//Json Object --- JsonObject
//primitive --- Primitive

// JsonElement