package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView textViewUserName = findViewById(R.id.textViewUserNameLabel);
        TextView textViewRole = findViewById(R.id.textViewRoleLabel);
        Intent  intent = getIntent();
        String role = intent.getStringExtra("Role");
        textViewRole.setText(role);
        String userName = intent.getStringExtra("UserName");
        textViewUserName.setText(userName);
        Log.d("onCreate", "role:" + role);
    }

    /**
     * Handle action when user click on "OnCallPhone"
     * @param view
     */
    public void onPhoneCall(View view) {
        Uri uri =  Uri.parse("tel:01912210727");
        startActivity(new Intent(Intent.ACTION_DIAL, uri));
    }

    /**
     * Handle action when the user click on "onSelectAddress" button
     * @param view
     */
    public void onSelectAddress(View view) {
        Intent intent = new Intent(HomeActivity.this, AddressListActivity.class);
        startActivityForResult(intent, 2);
    }

    /**
     * Handle the result when AddressListActivity finish
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            String selectedAddress = data.getStringExtra("ADDRESS");
            //Set data for displaying on screen
            TextView textViewSelectedAddress = findViewById(R.id.textViewSelectedAddress);
            textViewSelectedAddress.setText(textViewSelectedAddress.getText() + " " + selectedAddress);
        }
    }
}