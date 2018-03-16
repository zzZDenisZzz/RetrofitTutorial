package com.psi.retrofittutorial;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    static final String BASE_URL = "https://umorili.herokuapp.com";

    public static UmoriliApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)                                       //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create(gson))  //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();

        UmoriliApi umoriliApi = retrofit.create(UmoriliApi.class);       //Создаем объект, при помощи которого будем выполнять запросы
        return umoriliApi;

    }
}
