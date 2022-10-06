package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerCampus;
    private EditText editTextUserName, editTextPasswoord;
    private RadioButton radioButtonManager, radioButtonStaff, radioButtonAdmin;
    private CheckBox checkBoxRemember;
    private String role, campus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCampus = findViewById(R.id.spinner);
        radioButtonAdmin = findViewById(R.id.radioButtonAdmin);
        radioButtonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Admin is selected", Toast.LENGTH_LONG).show();
                role = "Admin";
            }
        });
        radioButtonStaff = findViewById(R.id.radioButtonStaff);
        radioButtonStaff.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Staff is selected", Toast.LENGTH_LONG).show();
            role = "Staff";
        });
        radioButtonManager = findViewById(R.id.radioButtonManager);
        radioButtonManager.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Manager is selected", Toast.LENGTH_LONG).show();
            role = "Manager";
        });
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPasswoord = findViewById(R.id.editTextPassword);
        checkBoxRemember = findViewById(R.id.checkBoxRememberPassword);

        //Set listener for spinner
        spinnerCampus.setOnItemSelectedListener(this);
        //Create adapter for Spinner
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.campus_array,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCampus.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(), "Selected Item: " + adapterView.getSelectedItem().toString(),
//                Toast.LENGTH_SHORT).show();
        campus = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    protected void onStart() {
        super.onStart();
        // More codes before Activity started
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     *
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Handle action when user click on button Login
     * @param view
     */
    public void onLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("UserName", editTextUserName.getText().toString());
        intent.putExtra("Role", role);
        startActivity(intent);
    }
}