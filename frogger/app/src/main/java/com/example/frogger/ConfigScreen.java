package com.example.frogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ConfigScreen extends AppCompatActivity {
    private String name;
    private int difficulty;
    private int character;

    private EditText insertName;
    private RadioGroup radioGroupDif;
    private RadioButton radioButtonDif;
    private RadioGroup radioGroupSpr;
    private RadioButton radioButtonSpr;

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_screen);

        insertName = (EditText) findViewById(R.id.insertName);
        radioGroupDif = findViewById(R.id.radioButtonDif);
        radioGroupSpr = findViewById(R.id.rbSprite);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int radioId = radioGroupDif.getCheckedRadioButtonId();
                    radioButtonDif = findViewById(radioId);
                    name = insertName.getText().toString();
                    if (radioButtonDif.getText().equals("Easy")) {
                        difficulty = 1;
                    } else if (radioButtonDif.getText().equals("Medium")) {
                        difficulty = 2;
                    } else if (radioButtonDif.getText().equals("Hard")) {
                        difficulty = 3;
                    }
                    int radioIdSprite = radioGroupSpr.getCheckedRadioButtonId();
                    radioButtonSpr = findViewById(radioIdSprite);
                    if (radioButtonSpr.getText().equals("Frog")) {
                        character = 1;
                    } else if (radioButtonSpr.getText().equals("Dog")) {
                        character = 2;
                    } else if (radioButtonSpr.getText().equals("Cat")) {
                        character = 3;
                    }
                    if (name != null && !name.trim().isEmpty() && !name.isEmpty() && character <= 3
                            && character > 0 && difficulty < 4 && difficulty > 0) {
                        openGameInfo();
                    } else {
                        openDialog();
                    }
                } catch (Exception e) {
                    openDialog();
                }
            }
        });
    }

    public void openGameInfo() {
        Intent intent = new Intent(this, GameInfo.class);
        intent.putExtra("keyname", name);
        intent.putExtra("keydifficulty", difficulty);
        intent.putExtra("keysprite", character);
        startActivity(intent);
    }

    public void openDialog() {
        ErrorDialog errorDialog = new ErrorDialog();
        errorDialog.show(getSupportFragmentManager(), "error");
    }
}