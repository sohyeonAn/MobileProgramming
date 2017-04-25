package org.androidtown.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pass the id of the view that may be reference as an instance in the code.
        button1 = (Button) findViewById(R.id.submit);
        Name = (EditText) findViewById(R.id.name);
        Age = (EditText) findViewById(R.id.age);

        //If button1 is clicked, gets values in EditText fields that each include name and age values
        //and puts into String type values inName and inAge.
        //Received values are passed newActivicty.class by intent.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inName = Name.getText().toString();
                String inAge = Age.getText().toString();

                Intent intent = new Intent (getApplicationContext(), org.androidtown.lab2.newActivity.class);
                intent.putExtra("loginName",inName);// The inName is given as loginName.
                intent.putExtra("loginAge",inAge);// The inAge is given as loginName.

                startActivity(intent);
            }
        });
    }
}
