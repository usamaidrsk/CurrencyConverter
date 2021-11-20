package com.ablut.currencyconverter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2;
    EditText edtAmount;
    TextView edtResult;
    Button btnConvert,btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        edtAmount = findViewById(R.id.edtAmount);
        edtResult = findViewById(R.id.edtResults);

        btnConvert=findViewById(R.id.btnConvert);
        btnClear = findViewById(R.id.btnClear);


        String[] currencies ={"USD","EURO","GBP","AUD","CAD","BDT"};
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,currencies);
        sp1.setAdapter(arrayAdapter);

        ArrayAdapter<String>Adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,currencies);
        sp2.setAdapter(Adapter);

        Double[] usdRates = {1.0, 0.89, 0.74, 1.38, 1.26, 85.67};
        Double[] eurRates = {1.13, 1.0, 1.13, 1.56, 1.43, 96.67};
        Double[] gdpRates = {1.34, 1.19, 1.0, 1.86, 1.70, 115.18};
        Double[] audRates = {0.72, 0.64, 0.54, 1.0, 0.91, 62.01};
        Double[] cadRates = {0.69, 0.61, 0.93, 0.96, 1.0, 83.14};
        Double[] bdtRates = {0.79, 0.70, 0.59, 1.09, 67.76, 1.0};


        btnClear.setOnClickListener(v -> {
             edtResult.setText(null);
             edtAmount.setText(null);
        });

        btnConvert.setOnClickListener(v -> {
         try {
             Double results =Double.parseDouble(edtAmount.getText().toString());
             Double[] rates = {};
             if(sp1.getSelectedItem().toString().equals(currencies[0])) rates = usdRates;
             if(sp1.getSelectedItem().toString().equals(currencies[1])) rates = eurRates;
             if(sp1.getSelectedItem().toString().equals(currencies[2])) rates = gdpRates;
             if(sp1.getSelectedItem().toString().equals(currencies[3])) rates = audRates;
             if(sp1.getSelectedItem().toString().equals(currencies[4])) rates = cadRates;
             if(sp1.getSelectedItem().toString().equals(currencies[5])) rates = bdtRates;
             for (int i = 0; i < rates.length; i++) {
                 if (sp2.getSelectedItem().toString().equals(currencies[i])) {
                     double answer = rates[i] * results;
                     edtResult.setText(Double.toString(answer));
                 }
            }
        }catch (Exception e){
             Toast.makeText(MainActivity.this, "Put Amount!!!", Toast.LENGTH_SHORT).show();
         }
        });
    }
    }
