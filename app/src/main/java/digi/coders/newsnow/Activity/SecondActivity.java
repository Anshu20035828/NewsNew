package digi.coders.newsnow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import digi.coders.newsnow.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    TextView name3, id3,author3, title3, description3, publishedAt3, content3;
    ImageView url3, urlToImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name3 = findViewById(R.id.source2);
        id3 = findViewById(R.id.id2);
        description3 = findViewById(R.id.description2);
        author3 = findViewById(R.id.author2);
        title3 = findViewById(R.id.title2);
        urlToImage3 = findViewById(R.id.urlToImage2);
        publishedAt3 = findViewById(R.id.publishedAt2);
        content3 = findViewById(R.id.content2);
        url3 = findViewById(R.id.url2);

        String author=getIntent().getStringExtra("author");
        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        String description = getIntent().getStringExtra("description");
        String publishedAt = getIntent().getStringExtra("publishedAt3");
        String content = getIntent().getStringExtra("content");
        String title=getIntent().getStringExtra("title");
        String url=getIntent().getStringExtra("url");
        String urlToImage=getIntent().getStringExtra("urlToImage");
        //Log.d("authorname","title"+title);


        author3.setText(author);
        name3.setText(name);
        id3.setText(id);
        description3.setText(description);
        publishedAt3.setText(publishedAt);
        content3.setText(content);
        title3.setText(title);
        Picasso.get().load(url).into(url3);
        Picasso.get().load(urlToImage).into(urlToImage3);

//        String apikey = "401e361ad8894f07841b60da2bb3da02";
//        String country = "us";


//        String urlToImages = getIntent().getStringExtra("urlToImage");
//         Toast.makeText(this, "urlToImage"+apikey, Toast.LENGTH_SHORT).show();
//         Toast.makeText(this, "urlToImage"+country, Toast.LENGTH_SHORT).show();
//        getAllNewsApiCalling(apikey,country);

    }


//    void getAllNewsApiCalling(String apikey, String country) {
//        GetRetroFit.getAdapterNews().getApiServiceNews(apikey,country).enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                ArrayList<UserDetailModel>userDetailModelArrayList=new ArrayList<>();
//                try {
//                    if (response.isSuccessful()) {
//
//                        //Log.d("ApiCalling","isSuccessful"+response.body().toString());
//
//                        JsonObject jsonObject = response.body();
//                        UserDetailModel userDetailModel = new Gson().fromJson(jsonObject, UserDetailModel.class);
//                        //Log.d("ApiCalling2", "isSuccessfull" + response.body().toString());
//
//                        userDetailModelArrayList.add(userDetailModel);
//
////                        NewsAdapter adapter=new NewsAdapter(userDetailModelArrayList,SecondActivity.this);
////
////                        recyclerView.setAdapter(adapter);
//
//
//
////                        Log.d("ApiCalling2","author  "+userDetailModelArrayList.size());
////                        source3.setText("" + userDetailModel.getSource().getName());
////                        author3.setText("" + userDetailModel.getAuthor());
////                        title3.setText("" + userDetailModel.getTitle());
////                        description3.setText("" + userDetailModel.getDescription());
////                        publishedAt3.setText("" + userDetailModel.getPublishedAt());
////                        content3.setText("" + userDetailModel.getContent());
////
////                        Picasso.get().load(userDetailModel.getUrlToImage()).into(urlToImage3);
////                        Picasso.get().load(userDetailModel.getUrl()).into(url3);
//
////                        Log.d("ApiCalling", "Source Name: " + userDetailModel.getSource().getName());
////                        Picasso.get().load(userDetailModel.getUrlToImage()).into(urlToImage3);
////                        Picasso.get().load(userDetailModel.getUrl()).into(url3);
//
//                    }
//
//                    else {
//                        Log.d("ApiCalling", "isNotSuccessfull");
//                    }
//                }
//                catch (Exception e) {
//                    Log.d("ApiCalling", "Exception" + e.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//                Log.d("ApiCalling", "onFailure" + t.getMessage());
//            }
//        });
//    }

}