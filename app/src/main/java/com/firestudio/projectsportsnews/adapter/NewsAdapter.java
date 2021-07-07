package com.firestudio.projectsportsnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firestudio.projectsportsnews.R;
import com.firestudio.projectsportsnews.databaseModel.ArticleFav;
import com.firestudio.projectsportsnews.mainModels.Article;
import com.firestudio.projectsportsnews.ui.DetailActivity;
import com.firestudio.projectsportsnews.ui.HomeFragment;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    Context context;
    List<Article> articles;

    public NewsAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new NewsHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsHolder holder, int position) {
        Article articleNew = articles.get(position);
        holder.textView.setText(articleNew.getTitle());
        Glide.with(context).load(articleNew.getUrlToImage()).into(holder.imageView);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Article articleFav = new Article();
                int id = articleNew.getId();
                String name = articleNew.getTitle();
                String url = articleNew.getUrlToImage();
                articleFav.setId(id);
                articleFav.setTitle(name);
                articleFav.setUrlToImage(url);
                HomeFragment.favouriteDataBase.favouriteDao().addData(articleFav);
                holder.btn.setImageResource(R.drawable.baseline_favorite);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("url", articleNew.getUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ImageView btn;
        CardView cardView;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.textview);
            btn = itemView.findViewById(R.id.favouirte_btn);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
