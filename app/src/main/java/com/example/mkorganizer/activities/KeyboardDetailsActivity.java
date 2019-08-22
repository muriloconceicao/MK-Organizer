package com.example.mkorganizer.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.mkorganizer.R;
import com.example.mkorganizer.controllers.KeyboardController;
import com.example.mkorganizer.entity.Keyboard;
import com.google.android.material.snackbar.Snackbar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KeyboardDetailsActivity extends AppCompatActivity {
    KeyboardController keyboardController;

    // Components
    @BindView(R.id.edtBrand) EditText edtBrand;
    @BindView(R.id.edtModel) EditText edtModel;
    @BindView(R.id.edtSwitch) EditText edtSwitch;
    @BindView(R.id.btnAdd) Button btnAdd;
    @BindView(R.id.toolbarKeyboardDetails) Toolbar toolbarKeyboardDetails;

    // Components Actions
    @OnClick(R.id.btnAdd)
    public void insertKeyboard() {
        String brand = edtBrand.getText().toString();
        String model = edtModel.getText().toString();
        String switches = edtSwitch.getText().toString();

        if(!(brand.isEmpty() || model.isEmpty() || switches.isEmpty())) {
            Keyboard keyboard = new Keyboard();
            keyboard.setBrand(brand);
            keyboard.setModel(model);
            keyboard.setSwitches(switches);
            keyboardController = new KeyboardController();
            keyboardController.addKeyboard(keyboard);
            Snackbar.make(btnAdd, getResources().getText(R.string.insertKeyboardSuccess), Snackbar.LENGTH_SHORT).show();
            resetFields();
        } else {
            Snackbar.make(btnAdd, getResources().getText(R.string.insertKeyboardFillAllFIeldsError), Snackbar.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btnReset)
    public void resetFields() {
        edtBrand.setText("");
        edtModel.setText("");
        edtSwitch.setText("");
        edtBrand.clearFocus();
        edtModel.clearFocus();
        edtSwitch.clearFocus();
        View view = findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard_details);
        ButterKnife.bind(this);
        toolbarKeyboardDetails.setTitle("");
        setSupportActionBar(toolbarKeyboardDetails);
        toolbarKeyboardDetails.setNavigationOnClickListener(view -> startActivity(new Intent(KeyboardDetailsActivity.this, MainActivity.class)));
    }
}