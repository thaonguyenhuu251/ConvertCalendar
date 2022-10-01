package com.example.convertcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txtYearConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnConvert = findViewById(R.id.btnConvert);
        EditText edtInputYear = findViewById(R.id.edtInputYear);
        txtYearConvert = findViewById(R.id.txtYearConvert);
        btnConvert.setOnClickListener(v->{
            try {
                int a =Integer.parseInt(String.valueOf(edtInputYear.getText()));
                if(!edtInputYear.getText().toString().isEmpty() && a > 1900) {
                    processData(a);
                } else {
                    Toast.makeText(MainActivity.this, "Year > 1900", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Không để trống", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void processData(int year) {
        List<String> calendarA = Arrays.asList(getResources().getStringArray(R.array.can_year));
        List<String> calendarB = Arrays.asList(getResources().getStringArray(R.array.chi_year));
        txtYearConvert.setText(calendarA.get(year % 10) + " " + calendarB.get(year%12));
    }

}