package org.androidtown.lab06;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static android.R.attr.button;
import static java.lang.System.in;

public class MainActivity extends AppCompatActivity {

    //define objects
    EditText editText;
    Button writeBtn, clearBtn, readBtn, finishBtn;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get GUI components from xml
        editText = (EditText) findViewById(R.id.editTxt);
        writeBtn = (Button) findViewById(R.id.writeBtn);
        clearBtn = (Button) findViewById(R.id.clearBtn);
        readBtn = (Button) findViewById(R.id.readBtn);
        finishBtn = (Button) findViewById(R.id.finishBtn);

        //using external storage
        File sdCard = Environment.getExternalStorageDirectory();
        File directory = new File(sdCard.getAbsolutePath()+"/MyFiles");
        directory.mkdirs();

        file = new File(directory, "Lab06.txt");

        //set write button click listener
        //if the button is clicked, the text in text field is written into file
        writeBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                try {
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter out = new OutputStreamWriter(fOut);
                    out.write(editText.getText().toString());
                    out.close();
                }catch (Throwable t){
                    Toast.makeText(getApplicationContext(), "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(),"success write to file",Toast.LENGTH_SHORT).show();
            }
        });

        //set clear button click listener
        //if the button clicked, text field is cleared.
        clearBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                editText.setText("");//text field is cleared
                Toast.makeText(getApplicationContext(),"clear text filed",Toast.LENGTH_SHORT).show();
            }
        });

        //set read button click listener
        //if the button clicked, the text in file is read and show read text in text field
        readBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                try{
                    FileInputStream fIn = new FileInputStream(file);

                    if(fIn != null){
                        BufferedReader reader = new BufferedReader(new InputStreamReader(fIn));
                        String str="";
                        StringBuffer buf = new StringBuffer();

                        while((str = reader.readLine())!=null){
                            buf.append(str+"\n");
                        }
                        fIn.close();
                        editText.setText(buf.toString());
                    }
                }catch (java.io.FileNotFoundException e){
                }catch(Throwable t){
                    Toast.makeText(getApplicationContext(), "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(getApplicationContext(),"success read from file",Toast.LENGTH_SHORT).show();
            }
        });


        //set finish button click listener
        finishBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"finish app",Toast.LENGTH_SHORT).show();
                finish();//the application is terminated
            }
        });


    }
}
