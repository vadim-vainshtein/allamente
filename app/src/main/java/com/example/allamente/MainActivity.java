package com.example.allamente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.open_button);
        button.setOnClickListener(this);
    }

    public void onClick(View view) {

        if (view.getId() == R.id.open_button) {
                Intent lessonIntent = new Intent(this, Lesson.class);
                startActivity(lessonIntent);
        }
    }
}