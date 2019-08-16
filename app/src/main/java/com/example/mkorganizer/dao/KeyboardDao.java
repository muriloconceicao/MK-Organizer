package com.example.mkorganizer.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.mkorganizer.entity.Keyboard;

@Dao
public interface KeyboardDao {

    @Insert
    void addKeyboard(Keyboard keyboard);



}
