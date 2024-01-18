package digi.coders.newsnow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import digi.coders.newsnow.Helper.GetRetroFit;
import digi.coders.newsnow.NewsAdapter;
import digi.coders.newsnow.R;
import digi.coders.newsnow.Model.UserDetailModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        String apikey = "401e361ad8894f07841b60da2bb3da02";
        String country = "us";
        getAlNews(apikey, country);
    }

    void getAlNews(String apiKey, String country) {
        List<UserDetailModel> userDetailModelList = new ArrayList<>();

        GetRetroFit.getAdapterNews().getApiServiceNews(apiKey, country).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d("ApiCalling", "response successful");
                        JsonObject jsonObject = response.body();

                        JsonArray jsonArray = jsonObject.getAsJsonArray("articles");

                        for (int i = 0; i < jsonArray.size(); i++) {

                            JsonObject jsonObject1 = jsonArray.get(i).getAsJsonObject();

                            Log.d("ApiCalling", "Data: " + jsonObject1.getAsJsonObject().toString());
                            UserDetailModel userDetailModel = new Gson().fromJson(jsonObject1, UserDetailModel.class);
                            userDetailModelList.add(userDetailModel);

//                            String author = jsonObject1.get("author").getAsString();
//                            String title = jsonObject1.get("title").getAsString();
//                            String description = jsonObject1.get("description").getAsString();
//                            String url = jsonObject1.get("url").getAsString();
//                            String content = jsonObject1.get("content").getAsString();
//                            Log.d("ApiCalling", "content" + content);

                            NewsAdapter adapter = new NewsAdapter(userDetailModelList, MainActivity.this);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                            recyclerView.setAdapter(adapter);
                        }
                    } else {
                        Log.d("ApiCalling", "response failed");
                    }

                } catch (Exception e) {
                    Log.d("ApiCalling", "Exception " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("ApiCalling", "Throwable " + t.getMessage());
            }
        });
    }
}