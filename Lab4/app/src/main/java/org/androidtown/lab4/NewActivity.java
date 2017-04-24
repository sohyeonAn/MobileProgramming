package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    //define GUI variables
    Button backBtn;
    TextView name, gender, reception;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        //get each widgets from xml
        backBtn = (Button) findViewById(R.id.back);
        name = (TextView) findViewById(R.id.nameText);
        gender= (TextView) findViewById(R.id.genderText);
        reception = (TextView) findViewById(R.id.receptionText);

        //get the sent intent
        Intent intent = getIntent();

        //make bundle and get extras from received intent
        Bundle bundle = new Bundle();
        bundle = intent.getExtras();

        //set text-field's text to the value with curtain key
        name.setText(bundle.getString("name"));
        gender.setText(bundle.getString("gender"));
        reception.setText(bundle.getString("reception"));

        //set button click listener
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();//close the current activity
            }
        });

    }
}
