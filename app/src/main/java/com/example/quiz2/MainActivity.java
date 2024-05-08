package com.example.quiz2;

import static com.example.quiz2.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroupPs, radioGroupTambahan;
    private EditText et1;
    private Button btn1;
    private Map<String, Integer> psOptions = new HashMap<>();
    private Map<String, Integer> tambahanOptions = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroupPs = findViewById(R.id.radioGroupPs);
        radioGroupTambahan = findViewById(R.id.radioGroupTambahan);
        et1 = findViewById(R.id.et1);
        btn1 = findViewById(R.id.btn1);


        psOptions.put("Ps 5", 10000);
        psOptions.put("Ps 4", 8000);
        psOptions.put("Ps 3", 5000);
        psOptions.put("Ps VR", 20000);


        tambahanOptions.put("Indomie", 7000);
        tambahanOptions.put("Mie Ayam", 10000);
        tambahanOptions.put("Siomay", 5000);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedPsId = radioGroupPs.getCheckedRadioButtonId();
                int selectedTambahanId = radioGroupTambahan.getCheckedRadioButtonId();
                String jamString = et1.getText().toString().trim();

                if (selectedPsId != -1 && selectedTambahanId != -1 && !jamString.isEmpty()) {
                    RadioButton selectedPs = findViewById(selectedPsId);
                    RadioButton selectedTambahan = findViewById(selectedTambahanId);

                    String psText = selectedPs.getText().toString();
                    String tambahanText = selectedTambahan.getText().toString();
                    int jam = Integer.parseInt(jamString);

                    // Mendapatkan nilai dari radio button yang dipilih
                    int psValue = psOptions.get(psText);
                    int tambahanValue = tambahanOptions.get(tambahanText);

                    int total = calculateTotal(psText, tambahanText, jam);

                    // Mengirim data menggunakan Intent
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("ps", psText);
                    intent.putExtra("psValue", psValue); // Mengirim nilai dari radio button PS
                    intent.putExtra("tambahan", tambahanText);
                    intent.putExtra("tambahanValue", tambahanValue); // Mengirim nilai dari radio button Tambahan
                    intent.putExtra("jam", jam);
                    intent.putExtra("total", total);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Silakan lengkapi semua pilihan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int calculateTotal(String ps, String tambahan, int jam) {

        int psCost = psOptions.get(ps);
        int tambahanCost = tambahanOptions.get(tambahan);


        int total = (psCost * jam) + tambahanCost;
        return total;
    }
    }

