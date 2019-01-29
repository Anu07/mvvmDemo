package com.example.anub.mvvmdemo.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.anub.mvvmdemo.model.PostResponse;

import java.util.List;

@Dao
public interface PostDao {

    @Query("SELECT * FROM postresponse")
    List<PostResponse> getAll();

    @Query("SELECT * FROM postresponse WHERE title LIKE :name LIMIT 1")
    PostResponse findByTitle(String name);

    @Insert
    void insertAll(List<PostResponse> products);

    @Update
    void update(PostResponse product);

    @Delete
    void delete(PostResponse product);
}