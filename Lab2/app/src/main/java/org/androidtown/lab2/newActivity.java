package org.androidtown.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class newActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new);

        //Pass the id of the view that may be reference as an instance in the code.
        Button button0 = (Button) findViewById(R.id.close);

        Intent passedIntent= getIntent();// gets an intent from MainActivity

        //If there's something in intent,
        // puts passed values loginName, loginAge into each new String loginName, loginAge.
        // And display toast message about student's name and age.
        if(passedIntent!=null)
        {
            String loginName = passedIntent.getStringExtra("loginName");
            String loginAge = passedIntent.getStringExtra("loginAge");
            Toast.makeText(getApplication(),"Student info: "+loginName+", "+loginAge,Toast.LENGTH_SHORT).show();
        }

        //If button0 is clicked, this acticity is closed and display before activity.
        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
}
