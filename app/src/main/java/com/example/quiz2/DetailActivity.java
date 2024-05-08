package com.example.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String ps = intent.getStringExtra("ps");
        String tambahan = intent.getStringExtra("tambahan");
        int jam = intent.getIntExtra("jam", 0);
        int total = intent.getIntExtra("total", 0);
        int psValue = intent.getIntExtra("psValue", 0);
        int tambahanValue = intent.getIntExtra("tambahanValue", 0);

        // Tampilkan data pada TextView
        TextView psTextView = findViewById(R.id.psTextView);
        TextView tambahanTextView = findViewById(R.id.tambahanTextView);
        TextView jamTextView = findViewById(R.id.jamTextView);
        TextView totalTextView = findViewById(R.id.totalTextView);

        String psDetailText = ps + " (" + psValue + ")";
        String tambahanDetailText = tambahan + " (" + tambahanValue + ")";

        psTextView.setText("PS: " + psDetailText);
        tambahanTextView.setText("Tambahan: " + tambahanDetailText);
        jamTextView.setText("Jam: " + jam);
        totalTextView.setText("Total Biaya: Rp " + total);

        }
    }
