package com.example.mkorganizer.controller;

import androidx.room.Room;
import com.example.mkorganizer.database.KeyboardDatabase;
import com.example.mkorganizer.entity.Keyboard;
import com.example.mkorganizer.utils.AppContext;

public class KeyboardController {

    public void addKeyboard(Keyboard keyboard) {
        KeyboardDatabase keyboardDatabase = Room.databaseBuilder(AppContext.getContext(), KeyboardDatabase.class, "keyboarddb").allowMainThreadQueries().build();
        keyboardDatabase.keyboardDao().addKeyboard(keyboard);
    }
}
