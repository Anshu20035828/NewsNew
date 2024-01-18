package digi.coders.newsnow;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import digi.coders.newsnow.Activity.SecondActivity;
import digi.coders.newsnow.Model.UserDetailModel;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<UserDetailModel> userDetailModelList;
    Context context;

    public NewsAdapter(List<UserDetailModel> userDetailModelList, Context context) {
        this.userDetailModelList = userDetailModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.news_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {

        UserDetailModel userDetailModel = userDetailModelList.get(position);


//        if (userDetailModel.getAuthor() != null) {

//            holder.source.setText(userDetailModel.getSource().getId());
            holder.source.setText(userDetailModel.getSource().getName());
            holder.author.setText(userDetailModel.getAuthor());
            holder.title.setText(userDetailModel.getTitle());
            Picasso.get().load(userDetailModel.getUrlToImage()).into(holder.urlToImage);

//            holder.description.setText(userDetailModel.getDescription());
//            holder.publishedAt.setText(userDetailModel.getPublishedAt());
//            holder.content.setText(userDetailModel.getContent());
//            Picasso.get().load(userDetailModel.getUrl()).into(holder.url);


//        } else {
//            holder.source.setVisibility(View.GONE);
//            holder.author.setVisibility(View.GONE);
//            holder.title.setVisibility(View.GONE);
//            holder.urlToImage.setVisibility(View.GONE);
//            holder.id.setVisibility(View.GONE);
//            holder.name.setVisibility(View.GONE);
//            holder.description.setVisibility(View.GONE);
//            holder.publishedAt.setVisibility(View.GONE);
//            holder.content.setVisibility(View.GONE);
//            holder.url.setVisibility(View.GONE);
//        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(context, SecondActivity.class);


                a.putExtra("author",userDetailModel.getAuthor());
                a.putExtra("title",userDetailModel.getTitle());
                a.putExtra("source",userDetailModel.getSource().getName());
                a.putExtra("id",userDetailModel.getSource().getId());
                a.putExtra("description",userDetailModel.getDescription());
                a.putExtra("publishedAt",userDetailModel.getPublishedAt());
                a.putExtra("content",userDetailModel.getContent());

                a.putExtra("url",userDetailModel.getUrl());
                a.putExtra("urlToImage",userDetailModel.getUrlToImage());


                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                //Toast.makeText(context, "getUrlToImage", Toast.LENGTH_SHORT).show();
                context.startActivity(a);

            }
        });


    }

    @Override
    public int getItemCount() {
        return userDetailModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView source, id, name, author, title, description, publishedAt, content;

        ImageView url, urlToImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            source = itemView.findViewById(R.id.source);
//            id = itemView.findViewById(R.id.id);
//            name = itemView.findViewById(R.id.name)
//            description = itemView.findViewById(R.id.description);

            author = itemView.findViewById(R.id.author);
            title = itemView.findViewById(R.id.title);
            urlToImage = itemView.findViewById(R.id.urlToImage);
//            publishedAt = itemView.findViewById(R.id.publishedAt);
//            content = itemView.findViewById(R.id.content);
//            url = itemView.findViewById(R.id.url);


        }
    }
}
