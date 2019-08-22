package com.example.mkorganizer.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.mkorganizer.adapters.KeyboardAdapter;
import com.example.mkorganizer.controllers.KeyboardController;
import com.example.mkorganizer.entity.Keyboard;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mkorganizer.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    RecyclerView.Adapter adapter;
    List<Keyboard> keyboardList;
    KeyboardController keyboardController;

    // Components
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.keyboardRecycleView) RecyclerView keyboardRecycleView;

    // Components Actions
    @OnClick(R.id.fabInserKeyboard)
    public void goToInsertKeyboard() {
        startActivity(new Intent(MainActivity.this, KeyboardDetailsActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        keyboardRecycleView.setLayoutManager(new LinearLayoutManager(this));
        keyboardController = new KeyboardController();
        getKeyboards();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getKeyboards();
    }

    public void getKeyboards() {
        keyboardList = keyboardController.getKeyboardList();
        adapter = new KeyboardAdapter(keyboardList);
        keyboardRecycleView.setAdapter(adapter);
    }

}