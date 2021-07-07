package com.firestudio.projectsportsnews.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firestudio.projectsportsnews.R;
import com.firestudio.projectsportsnews.adapter.FavouriteAdapter;
import com.firestudio.projectsportsnews.mainModels.Article;

import java.util.List;

public class SavedFragment extends Fragment {
    RecyclerView recyclerView;
    FavouriteAdapter favouriteAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved, container, false);
        recyclerView = view.findViewById(R.id.saved_recyclerview);
        recyclerView.setHasFixedSize(true);
        List<Article> articles = HomeFragment.favouriteDataBase.favouriteDao().getArticle();
        favouriteAdapter = new FavouriteAdapter(getActivity(), articles);
        recyclerView.setAdapter(favouriteAdapter);
        return view;
    }
}
