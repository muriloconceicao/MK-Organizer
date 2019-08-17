package com.example.mkorganizer.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mkorganizer.entity.Keyboard;

import java.util.List;

@Dao
public interface KeyboardDao {

    @Insert
    void addKeyboard(Keyboard keyboard);

    @Query("SELECT * FROM keyboards")
    public List<Keyboard> getKeyboards();

}
