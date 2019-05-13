package com.example.Lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button ContentActivityButton;
    private TextView address;
    private TextView description;
    private TextView time;
    static String txtAddress;


    static String[] names = {"1)", "2)", "3)", "4)", "5)", "6)", "7)", "8)", "9)", "10)",};
    static int i = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentActivityButton = findViewById(R.id.ContentActivityButton);
        ContentActivityButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getStringExtra("address") == null) //это костыль, можете не вникать
        {
            return;
        }

        else {

            txtAddress = getIntent().getStringExtra("address") + ';' +
                    getIntent().getStringExtra("time") + ';' +
                    getIntent().getStringExtra("description");


            i = i + 1;
            if (i == 9 || i < 0) {
                i = 0;
                onPause();
            }
            names[i] += txtAddress;

            ListView List = findViewById(R.id.List);

            ArrayAdapter<String> adapter;
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, names);

            List.setAdapter(adapter);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ContentActivityButton:
                Intent intent = new Intent(this, ActivityContent.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //finish();
                break;

            default:

                break;
        }
    }

}
