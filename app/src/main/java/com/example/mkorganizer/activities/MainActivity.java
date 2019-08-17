package com.example.mkorganizer.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mkorganizer.R;
import com.example.mkorganizer.controllers.KeyboardController;
import com.example.mkorganizer.entity.Keyboard;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    KeyboardController keyboardController;

    // Components
    @BindView(R.id.edtBrand) EditText edtBrand;
    @BindView(R.id.edtModel) EditText edtModel;
    @BindView(R.id.edtSwitch) EditText edtSwitch;

    // Components Actions, as Clicks, etc
    @OnClick(R.id.btnAdd)
    public void addKeyboard() {
        Keyboard keyboard = new Keyboard();
        String brand;
        String model;
        String switches;

        brand = edtBrand.getText().toString();
        model = edtModel.getText().toString();
        switches = edtSwitch.getText().toString();

        if(brand.isEmpty() || model.isEmpty() || switches.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please, fill the empty fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        keyboard.setBrand(brand);
        keyboard.setModel(model);
        keyboard.setSwitches(switches);

        keyboardController = new KeyboardController();
        keyboardController.addKeyboard(keyboard);
        Toast.makeText(getApplicationContext(), "Keyboard has been added.", Toast.LENGTH_SHORT).show();

        resetTextFields();

    }

    @OnClick(R.id.btnReset)
    public void resetTextFields() {
        edtBrand.setText("");
        edtModel.setText("");
        edtSwitch.setText("");
        edtBrand.requestFocus();
    }

    @OnClick(R.id.btnList)
    public void onBtnListClick() {
        startActivity(new Intent(MainActivity.this, KeyboardListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}