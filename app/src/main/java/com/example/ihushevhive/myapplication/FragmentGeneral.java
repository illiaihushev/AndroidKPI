package com.example.ihushevhive.myapplication;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

public class FragmentGeneral extends Fragment {
    private String chosenCategory;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_general_main, container, false);

        Spinner spinner = rootView.findViewById(R.id.spinner);

        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.disheslist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] dishesList = getResources().getStringArray(R.array.disheslist);
                chosenCategory = dishesList[selectedItemPosition];
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final CheckBox checkBoxUnder1000 = rootView.findViewById(R.id.checkBoxUnder1000UAH);
        final CheckBox checkBoxAbove1000 = rootView.findViewById(R.id.checkBoxAbove1000UAH);
        final CheckBox checkBoxTefal = rootView.findViewById(R.id.checkBoxTefal);
        final CheckBox checkBoxVinzer = rootView.findViewById(R.id.checkBoxVinzer);
        final CheckBox checkBoxRondell = rootView.findViewById(R.id.checkBoxRondell);

        Button buttonOk = rootView.findViewById(R.id.buttonOk);
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


                FragmentResult fragmentResult = (FragmentResult) (getActivity().getFragmentManager().findFragmentByTag("frag2"));
                fragmentResult.fill(result);
            }
        });

        return rootView;
    }
}
