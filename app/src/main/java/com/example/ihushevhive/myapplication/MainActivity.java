package com.example.ihushevhive.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    private String chosenCategory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.disheslist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] dishesList = getResources().getStringArray(R.array.disheslist);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Your choice " + dishesList[selectedItemPosition], Toast.LENGTH_SHORT);
                toast.show();
                chosenCategory = dishesList[selectedItemPosition];
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final CheckBox checkBoxUnder1000 = findViewById(R.id.checkBoxUnder1000UAH);
        final CheckBox checkBoxAbove1000 = findViewById(R.id.checkBoxAbove1000UAH);
        final CheckBox checkBoxTefal = findViewById(R.id.checkBoxTefal);
        final CheckBox checkBoxVinzer = findViewById(R.id.checkBoxVinzer);
        final CheckBox checkBoxRondell = findViewById(R.id.checkBoxRondell);

        Button buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Category: " + chosenCategory + "\n";
                result += "Your price diapason: ";
                if (!checkBoxAbove1000.isChecked() && !checkBoxUnder1000.isChecked()){
                    result += "Nothing is selected";
                }else if (checkBoxAbove1000.isChecked() && checkBoxUnder1000.isChecked()){
                    result += "Any price";
                }else {
                    if (checkBoxAbove1000.isChecked()) {
                        result += "above 1000 UAH";
                    }
                    if (checkBoxUnder1000.isChecked()) {
                        result += " under 1000 UAH";
                    }
                }
                result += "\n";
                result += "Your suppliers choice: ";
                if(!checkBoxRondell.isChecked() && !checkBoxTefal.isChecked() && !checkBoxVinzer.isChecked()){
                    result += "Nothing is selected";
                }else if(checkBoxRondell.isChecked() && checkBoxTefal.isChecked() && checkBoxVinzer.isChecked()){
                    result += "All suppliers are selected";
                }else {
                    if (checkBoxRondell.isChecked()) {
                        result += "Rondell";
                    }
                    if (checkBoxTefal.isChecked()) {
                        result += " Tefal";
                    }
                    if (checkBoxVinzer.isChecked()) {
                        result += " Vinzer";
                    }
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Dishes")
                        .setMessage(result)
                        .setCancelable(false)
                        .setNegativeButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
