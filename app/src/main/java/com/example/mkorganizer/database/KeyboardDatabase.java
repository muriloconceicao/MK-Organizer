package com.example.mkorganizer.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.mkorganizer.dao.KeyboardDao;
import com.example.mkorganizer.entity.Keyboard;

@Database(entities = {Keyboard.class}, version = 1, exportSchema = false)
public abstract class KeyboardDatabase extends RoomDatabase {

    public abstract KeyboardDao keyboardDao();

}