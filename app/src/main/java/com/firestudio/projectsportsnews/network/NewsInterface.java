package com.firestudio.projectsportsnews.network;

import com.firestudio.projectsportsnews.mainModels.News;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsInterface {
    @GET("top-headlines?country=in&category=sports&apiKey=d1c7a30b76ea4462a4c2e4f10ee83df2")
    Call<News> getNewsArticle();

}
