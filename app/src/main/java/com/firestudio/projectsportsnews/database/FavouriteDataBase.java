package com.firestudio.projectsportsnews.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.firestudio.projectsportsnews.dao.FavouriteDao;
import com.firestudio.projectsportsnews.mainModels.Article;

@Database(entities = {Article.class},version = 1)
public abstract class FavouriteDataBase extends RoomDatabase {
    public abstract FavouriteDao favouriteDao();
}
