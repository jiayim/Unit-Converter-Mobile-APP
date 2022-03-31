package com.example.unitconvertermobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView result1;
    TextView result2;
    TextView result3;
    TextView error;
    private Spinner menu;
    private String   getContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.menu);
        input = findViewById(R.id.input);
        ImageButton MeterButton = findViewById(R.id.MeterButton);
        ImageButton CelsiusButton = findViewById(R.id.CelsiusButton);
        ImageButton KilogramButton = findViewById(R.id.KilogramButton);
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        result3 = findViewById(R.id.result3);
        error = findViewById(R.id.error);

        String s2 = "Celsius";
        String S3 = "Kilogram";

        menu.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                getContent = MainActivity.this.getResources().getStringArray(R.array.unit)[arg2];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

            MeterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    float a = Float.parseFloat(input.getText().toString());
                    float b = Float.parseFloat(input.getText().toString());
                    float c = Float.parseFloat(input.getText().toString());
                    double result4 = a * 100;
                    double result5 = b * 3.280839;
                    double result6 = c * 39.3700787402;

                    String s1 = "Metre";
                    if (s1.equals(getContent)){
                        result1.setText(String.format("%.2f", result4) + "  Centimetre");
                        result2.setText(String.format("%.2f", result5) + "  Foot");
                        result3.setText(String.format("%.2f", result6) + "  Inch");
                        error.setText("");
                    }else {
                        error.setText("error: Please select the correct conversion icon!");

                    }
                }
            });

        CelsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(input.getText().toString());
                float b = Float.parseFloat(input.getText().toString());
                double result4 = a * 9 / 5 + 32;
                double result5 = b + 273.15 ;

                String s2 = "Celsius";
                if (s2.equals(getContent)){
                    result1.setText(String.format("%.2f", result4) + "  Fahrenheit");
                    result2.setText(String.format("%.2f", result5) + "  Kelvin");
                    error.setText("");
                }else {
                    error.setText("error: Please select the correct conversion icon!");
                }
            }
        });

        KilogramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(input.getText().toString());
                float b = Float.parseFloat(input.getText().toString());
                float c = Float.parseFloat(input.getText().toString());
                double result4 = a * 1000;
                double result5 = b * 35.2739619496;
                double result6 = c * 2.20462262185;

                String s3 = "Kilogram";
                if (s3.equals(getContent)){
                    result1.setText(String.format("%.2f", result4) + "  Gram");
                    result2.setText(String.format("%.2f", result5) + "  Ounce(Oz)");
                    result3.setText(String.format("%.2f", result6) + "  Pound(Ib)");
                    error.setText("");
                }else {
                    error.setText("error: Please select the correct conversion icon!");

                }
            }
        });
    }
}