package com.mildbot.sharebear;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText UnField;
    EditText PwdField;
    TextView DisplayUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UnField = (EditText) findViewById(R.id.UnField);
        PwdField = (EditText) findViewById(R.id.PwdField);
        DisplayUserInfo = (TextView) findViewById(R.id.DisplayUserInfo);
    }

    public void saveInfo(View view) {
        SharedPreferences sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("UserName", UnField.getText().toString());
        editor.putString("Password", PwdField.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }

    public void displayData(View view) {
        SharedPreferences sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("UserName", "");
        String password = sharedPref.getString("Password", "");

        DisplayUserInfo.setText(name + " - " + password);
    }

}
