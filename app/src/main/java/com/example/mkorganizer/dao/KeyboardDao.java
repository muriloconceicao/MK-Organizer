package com.example.mkorganizer.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mkorganizer.entity.Keyboard;

import java.util.List;

@Dao
public interface KeyboardDao {

    @Insert
    void insertKeyboard(Keyboard keyboard);

    @Query("SELECT * FROM keyboards")
    List<Keyboard> getKeyboards();

    @Delete
    void deleteKeyboard(Keyboard keyboard);

}