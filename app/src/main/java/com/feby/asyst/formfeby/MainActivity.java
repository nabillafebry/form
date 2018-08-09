package com.feby.asyst.formfeby;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.feby.asyst.formfeby.utility.Constant;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener,
        CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {


    //form layout
    Button buttonFirst;
    EditText editTextFirst;
    String firstString, selectedGender = "Male", selectedCity;
    TextView textViewFirst;
    RadioGroup genderRadio;
    CheckBox cbNasgor, cbBakso, cbPasta;
    String foods = "";
//    String nasiGoreng = "", bakso = "", pasta ="";
    Spinner citySpinner;
    ArrayList<String> listFood = new ArrayList<String>();
    ArrayList<String> listCity = new ArrayList<>();
    Switch switchFirst;
    ToggleButton toggleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //form layout
        buttonFirst = findViewById(R.id.button_first);
        editTextFirst = findViewById(R.id.edittext_first);
        textViewFirst = findViewById(R.id.textview_first);


        genderRadio = findViewById(R.id.radio_gender);
        genderRadio.setOnCheckedChangeListener(this);
//        ((RadioButton)findViewById(R.id.radio_male)).setChecked(true); //menentukan pilihan awal

        cbNasgor=findViewById(R.id.cb_nasgor);
        cbBakso=findViewById(R.id.cb_bakso);
        cbPasta=findViewById(R.id.cb_pasta);

        cbNasgor.setOnCheckedChangeListener(this);
        cbBakso.setOnCheckedChangeListener(this);
        cbPasta.setOnCheckedChangeListener(this);

        citySpinner = findViewById(R.id.spinner_city);
        citySpinner.setOnItemSelectedListener(this);

        listCity.add("Jember");
        listCity.add("Malang");
        listCity.add("Jakarta");

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listCity);

        citySpinner.setAdapter(cityAdapter);

        switchFirst = findViewById(R.id.switch_first);
        toggleBtn = findViewById(R.id.togglebtn);

        switchFirst.setOnCheckedChangeListener(this);
        toggleBtn.setOnCheckedChangeListener(this);

        buttonFirst.setOnClickListener(this);
        
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        //form layout
        switch (id){
            case R.id.button_first :
                firstString = editTextFirst.getText().toString();

                if (!TextUtils.isEmpty(firstString)) {
//                    Toast.makeText(getApplicationContext(), "Welcome " + firstString, Toast.LENGTH_SHORT).show();

                    foods = "";

                    for (int i=0; i<listFood.size(); i++)
                    {
                        foods = foods+" "+listFood.get(i);
                    }

//                    textViewFirst.setText("Halo " + firstString + "\n" + "Gender : " + selectedGender+ "\n" + "Makanan Favorit : " + foods + "\n" + "Kota Asal : " + selectedCity);

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Confirmation").setCancelable(false).setMessage("Are You Sure?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String result = "Halo " + firstString + "\n" + "Gender : " + selectedGender+ "\n" + "Makanan Favorit : " + foods + "\n" + "Kota Asal : " + selectedCity;
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra(Constant.KEY_RESULT, result);
                            startActivity(intent);
                        }
                    }).setNegativeButton("No", null).show();




                }
                break;
        }

    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radio_male :
                selectedGender = "Male";
                break;
            case R.id.radio_female :
                selectedGender = "Female";
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();

        switch (id){
            case R.id.cb_nasgor :
                if (isChecked){
                    listFood.add("Nasi Goreng");
                }
                else {
                    listFood.remove("Nasi Goreng");
                }
                break;
            case R.id.cb_bakso :
                if (isChecked){
                    listFood.add("Bakso");
                }
                else {
                    listFood.remove("Bakso");
                }
                break;
            case R.id.cb_pasta :
                if (isChecked){
                    listFood.add("Pasta");
                }
                else {
                    listFood.remove("Pasta");
                }
                break;

            case R.id.switch_first :
                Log.d("MainAct TestSwitch", String.valueOf(isChecked));
                break;
            case R.id.togglebtn :
                Log.d("MainAct TestToggle", String.valueOf(isChecked));
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCity = citySpinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

//kalkulator
//    EditText et1, et2;
//    Button bTambah, bKurang, bKali, bBagi;
//    String string1, string2;
//    TextView tvHasil;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        et1 = findViewById(R.id.angka1);
//        et2 = findViewById(R.id.angka2);
//        bTambah = findViewById(R.id.tambah);
//        bKurang = findViewById(R.id.kurang);
//        bKali = findViewById(R.id.kali);
//        bBagi = findViewById(R.id.bagi);
//        tvHasil = findViewById(R.id.hasil);
//
//        bTambah.setOnClickListener(this);
//        bKurang.setOnClickListener(this);
//        bKali.setOnClickListener(this);
//        bBagi.setOnClickListener(this);

//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        string1 = et1.getText().toString();
//        string2 = et2.getText().toString();

//        if (TextUtils.isEmpty(string1) || TextUtils.isEmpty(string2)) {
//            Toast.makeText(getApplicationContext(), "HARAP DIISI!", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            int ang1 = Integer.parseInt(string1);
//            int ang2 = Integer.parseInt(string2);
//            switch (id) {
//                case R.id.tambah:
//                    int hasil = ang1 + ang2;
//                    tvHasil.setText(String.valueOf(hasil));
//                    break;
//                case R.id.kurang:
//                    int hasil2 = ang1 - ang2;
//                    tvHasil.setText(String.valueOf(hasil2));
//                    break;
//                case R.id.kali:
//                    int hasil3 = ang1 * ang2;
//                    tvHasil.setText(String.valueOf(hasil3));
//                    break;
//                case R.id.bagi:
//                    if (ang2==0){
//                        tvHasil.setText("Undefined");
//                    }
//                    else {
//                        float a = Float.parseFloat(string1);
//                        float b = Float.parseFloat(string2);
//                        float hasil4 = a / b ;
//                        tvHasil.setText(""+hasil4);
//            }
//                    break;
//            }
//        }



