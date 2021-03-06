package com.pf.tutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.pf.tutorial.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    MultiAutoCompleteTextView multiAutoCompleteTextViewMainActivityCountry;
    Button buttonMainActivitySubmitMACTV;

    ArrayList<String> arrayListCountrySuggestion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiAutoCompleteTextViewMainActivityCountry = findViewById(R.id.multiAutoCompleteTextViewMainActivityCountry);
        buttonMainActivitySubmitMACTV = findViewById(R.id.buttonMainActivitySubmitMACTV);
        
        multiAutoCompleteTextViewMainActivityCountry.setThreshold(1);
        ArrayAdapter<String> adapterMACTV = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, arrayListCountrySuggestion);
        multiAutoCompleteTextViewMainActivityCountry.setAdapter(adapterMACTV);
        multiAutoCompleteTextViewMainActivityCountry.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        multiAutoCompleteTextViewMainActivityCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String country = adapterView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected Country is : " + country, Toast.LENGTH_SHORT).show();
            }
        });

        buttonMainActivitySubmitMACTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country = multiAutoCompleteTextViewMainActivityCountry.getText().toString();
                Toast.makeText(MainActivity.this, "Country: " + country, Toast.LENGTH_SHORT).show();
            }
        });

        // countries list have been changed and notify the adapterMACTV
        arrayListCountrySuggestion.addAll( Arrays.asList("Pakistan", "China", "USA", "Australia", "UK", "Italy", "Ireland", "Africa") );
        adapterMACTV.notifyDataSetChanged();
        
    }
}
