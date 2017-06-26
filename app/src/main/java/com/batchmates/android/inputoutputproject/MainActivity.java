package com.batchmates.android.inputoutputproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private static final String FILENAME="MyFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.tvWhatsInTheFile);

        editText=(EditText)findViewById(R.id.etInput);
    }

    public void writeToFile(View view) throws IOException {

        OutputStream outputStream=openFileOutput(FILENAME, Context.MODE_PRIVATE);

        outputStream.write(editText.getText().toString().getBytes());
        outputStream.close();
    }

    public void readFromFile(View view) throws IOException {

//        InputStream inputStream=openFileInput(FILENAME);
//        File file= new File(FILENAME);
//        Log.d(""+inputStream, "readFromFile: Input");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(openFileInput(FILENAME)));
        String inputString;
        StringBuffer stringBuffer = new StringBuffer();
        //InputStreamReader inputStreamReader=new InputStreamReader();

        while((inputString=bufferedReader.readLine())!=null)
        {
            stringBuffer.append(inputString+"\n");
        }

        textView.setText(stringBuffer);

        bufferedReader.close();

    }
}
