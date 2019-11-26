package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView showMessage;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        showMessage = findViewById(R.id.showMessage);

        sharedPreferences = getSharedPreferences("android advance", MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }


    public void dataSave(View view) {
        String data = editText.getText().toString();
        editor.putString("message", data);
        editor.commit();
        editText.setText(null);
        Toast.makeText(this, "Data Save Succussfully "+ data, Toast.LENGTH_SHORT).show();

    }

    public void daraRetrive(View view) {
        String message = sharedPreferences.getString("message","No data Save");
        showMessage.setText(message);

    }
}
