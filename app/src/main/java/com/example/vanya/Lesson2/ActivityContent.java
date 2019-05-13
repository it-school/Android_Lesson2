package com.example.vanya.Lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

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

        saveButton = findViewById(R.id.saveButton);


        saveButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.saveButton:


                addr = findViewById(R.id.editText3);
                des = findViewById(R.id.editText6);
                t = findViewById(R.id.editText5);
                if (addr.getText().equals("") || des.getText().length() == 0 ||
                        t.getText().length() == 0)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            R.string.ErrorFill, Toast.LENGTH_SHORT);
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
