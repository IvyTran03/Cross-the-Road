package com.example.frogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button toSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSecond = (Button) findViewById(R.id.ToSecond);
        toSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfigScreen();
            }
        });
    }

    public void openConfigScreen() {
        Intent intent = new Intent(this, ConfigScreen.class);
        startActivity(intent);
    }
}