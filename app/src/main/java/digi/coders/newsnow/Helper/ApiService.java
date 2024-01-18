package digi.coders.newsnow.Helper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("top-headlines")
    Call<JsonObject> getApiServiceNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country
    );



}
