package com.firestudio.projectsportsnews.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.firestudio.projectsportsnews.databaseModel.ArticleFav;
import com.firestudio.projectsportsnews.mainModels.Article;

import java.util.List;

@Dao
public interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addData(Article articleFav);

    @Query("SELECT * FROM favouriteTable")
    public List<Article> getArticle();


   /* @Query("SELECT EXISTS (SELECT 1 FROM favouriteTable WHERE id=:title)")
    int isFavorite(String title);
*/
    @Delete
    void delete(Article articleFav);
}
