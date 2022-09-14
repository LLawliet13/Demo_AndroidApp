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


public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private Spinner spinnerCampus;
    private EditText editTextUserName, editTextPassword;
    private RadioButton radioButtonManager, radioButtonStaff, radioButtonAdmin;
    private CheckBox checkBoxRemember;
    private String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCampus = findViewById(R.id.spinner);
        radioButtonAdmin = findViewById(R.id.radioButton3);
        radioButtonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Admin is selected", Toast.LENGTH_LONG).show();
                role = "Admin";
            }
        });
        radioButtonManager = findViewById(R.id.radioButton2);
        radioButtonManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Manager is selected", Toast.LENGTH_LONG).show();
                role = "Manager";
            }
        });
        radioButtonStaff = findViewById(R.id.radioButton);
        radioButtonStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Staff is selected", Toast.LENGTH_LONG).show();
                role = "Staff";
            }
        });
        editTextUserName = findViewById(R.id.editTextTextPersonName);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        checkBoxRemember = findViewById(R.id.checkBox);
        spinnerCampus.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        spinnerCampus.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), "Selected Item: " + adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Handle action when user click on button Login
     *
     * @pram view
     */
    public void onLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("UserName", editTextUserName.getText().toString());
        intent.putExtra("Role", role);
        startActivity(intent);
    }
}

