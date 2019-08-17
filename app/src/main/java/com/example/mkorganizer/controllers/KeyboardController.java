package com.example.mkorganizer.controllers;

import androidx.room.Room;
import com.example.mkorganizer.database.KeyboardDatabase;
import com.example.mkorganizer.entity.Keyboard;
import com.example.mkorganizer.utils.AppContext;

import java.util.List;

public class KeyboardController {
    private KeyboardDatabase keyboardDatabase;

    public void addKeyboard(Keyboard keyboard) {
        keyboardDatabase =  Room.databaseBuilder(AppContext.getContext(), KeyboardDatabase.class, "keyboarddb").allowMainThreadQueries().build();
        keyboardDatabase.keyboardDao().addKeyboard(keyboard);
        keyboardDatabase.close();
    }

    public List<Keyboard> getKeyboardList() {
        keyboardDatabase = Room.databaseBuilder(AppContext.getContext(), KeyboardDatabase.class, "keyboarddb").allowMainThreadQueries().build();
        return keyboardDatabase.keyboardDao().getKeyboards();
    }
}
