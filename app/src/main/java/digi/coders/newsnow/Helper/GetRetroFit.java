package digi.coders.newsnow.Helper;

import digi.coders.newsnow.Helper.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRetroFit {

    public static ApiService getAdapterNews(){

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://newsapi.org/v2/")
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;

    }

}
