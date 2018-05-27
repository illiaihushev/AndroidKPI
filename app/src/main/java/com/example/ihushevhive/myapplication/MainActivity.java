package com.example.ihushevhive.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ihushevhive.myapplication.model.SecondActivity_Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends Activity {
    private String chosenCategory;
    private String result;
    private final static String FILE_NAME = "content.txt";
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
        deleteFile("content.txt");
        Button buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                result = "Category: " + chosenCategory + "\n";
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
                    result += "\n";
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
                    FileOutputStream fos = null;
                    try
                    {
                        String text_of_list = result;

                        fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
//                        fos = new FileOutputStream(FILE_NAME, false);

                        fos.write(text_of_list.getBytes());
                        Toast.makeText(getBaseContext(), "Data is saved", Toast.LENGTH_SHORT).show();
                    }
                    catch(IOException ex)
                    {
                        Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    finally
                    {
                        try
                        {
                            if(fos!=null)
                                fos.close();
                        }
                        catch(IOException ex)
                        {

                            Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

            }

        });
    }

    public void openText(View view) {
        FileInputStream fin = null;

        try
        {
            fin = openFileInput(FILE_NAME);
            Intent n = new Intent(this, SecondActivity_Output.class);

            startActivity(n);
        }
        catch (IOException ex)
        {
            Toast.makeText(this, "File is empty!", Toast.LENGTH_SHORT).show();
        }

        //Intent n = new Intent(this, SecondActivity_Output.class);
        //startActivity(n);
    }
}
