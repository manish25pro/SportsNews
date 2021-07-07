package com.firestudio.projectsportsnews.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firestudio.projectsportsnews.R;
import com.firestudio.projectsportsnews.adapter.NewsAdapter;
import com.firestudio.projectsportsnews.database.FavouriteDataBase;
import com.firestudio.projectsportsnews.mainModels.Article;
import com.firestudio.projectsportsnews.mainModels.News;
import com.firestudio.projectsportsnews.network.NewsInterface;
import com.firestudio.projectsportsnews.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    List<Article> articleList;
    public static FavouriteDataBase favouriteDataBase;
    ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = rootView.findViewById(R.id.news_recyclerview);
        recyclerView.setHasFixedSize(true);
        favouriteDataBase = Room.databaseBuilder(getContext(), FavouriteDataBase.class, "myfavdb").allowMainThreadQueries().build();
        progressBar = rootView.findViewById(R.id.progressBar);
        NewsInterface newsInterface = RetrofitClient.getRetrofitClient().create(NewsInterface.class);
        Call<News> call = newsInterface.getNewsArticle();
        articleList = new ArrayList<>();
        progressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                progressBar.setVisibility(View.VISIBLE);
                articleList = response.body().getArticles();
                newsAdapter = new NewsAdapter(getActivity(), articleList);
                recyclerView.setAdapter(newsAdapter);
                progressBar.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }

        });


        return rootView;


    }


}
