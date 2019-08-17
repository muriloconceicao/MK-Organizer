package com.example.mkorganizer.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mkorganizer.R;
import com.example.mkorganizer.adapters.KeyboardAdapter;
import com.example.mkorganizer.controllers.KeyboardController;
import com.example.mkorganizer.entity.Keyboard;
import android.os.Bundle;
import java.util.List;

public class KeyboardListActivity extends AppCompatActivity {
    // Listing all the keyboards
    RecyclerView keyboardRecycleView;
    RecyclerView.Adapter adapter;
    List<Keyboard> keyboardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_list);

        keyboardRecycleView = findViewById(R.id.keyboardRecycleView);
        keyboardRecycleView.setLayoutManager(new LinearLayoutManager(this));
        KeyboardController keyboardController = new KeyboardController();
        keyboardList = keyboardController.getKeyboardList();
        adapter = new KeyboardAdapter(keyboardList);
        keyboardRecycleView.setAdapter(adapter);

    }
}