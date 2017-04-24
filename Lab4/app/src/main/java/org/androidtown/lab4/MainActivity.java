package org.androidtown.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

   //define GUI variables
    EditText editText;
    Button btn;

    CheckBox chkSMS;
    CheckBox chkEmail;
    RadioButton radioMale;
    RadioButton radioFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);//get text field from xml
        btn = (Button) findViewById(R.id.submit);//get button from xml

        //get checkbox and radiobutton from xml
        chkSMS = (CheckBox) findViewById(R.id.chkSMS);
        chkEmail = (CheckBox) findViewById(R.id.chkEmail);
        radioFemale = (RadioButton) findViewById(R.id.radioFemale);
        radioMale = (RadioButton) findViewById(R.id.radioMale);

        //set button click listener
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String reception="";//represent the checked value on checkbox
                if(chkEmail.isChecked())
                    reception += "e-mail ";
                if(chkSMS.isChecked())
                    reception+= "SMS ";

                String gender="";//represent the checked value on radiobutton
                if(radioFemale.isChecked())
                    gender+="여자";
                else if(radioMale.isChecked())
                    gender+="남자";

                //make an intent and a bundle
                //and put bundle into the intent
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("name",editText.getText().toString());
                bundle.putString("gender",gender);
                bundle.putString("reception",reception);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }
}
