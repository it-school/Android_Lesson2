package com.example.vanya.lab_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ActivityContent extends AppCompatActivity implements View.OnClickListener {
    private Button saveButton;
    private EditText addr;
    private EditText des;
    private EditText t;

    public static ArrayList<String> spisok = new ArrayList<String>();
    public static String[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        saveButton = (Button) findViewById(R.id.saveButton);


        saveButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.saveButton:


                addr = (EditText) findViewById(R.id.editText3);
                des = (EditText) findViewById(R.id.editText6);
                t = (EditText) findViewById(R.id.editText5);
                if (addr.getText().length() == 0 || des.getText().length() == 0 ||
                        t.getText().length() == 0)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Fell all fields", Toast.LENGTH_SHORT);
                    toast.show();

                    break;
                }
                else {

                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("address", addr.getText().toString());
                    intent.putExtra("description", des.getText().toString());
                    intent.putExtra("time", t.getText().toString());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

                break;
            default:
                break;

        }


    }

}
