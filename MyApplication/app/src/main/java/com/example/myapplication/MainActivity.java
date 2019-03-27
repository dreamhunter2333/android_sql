package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.os.StrictMode;

public class MainActivity extends AppCompatActivity {

    MysqlTest sql = new MysqlTest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.textView7);
        text.setText("此处显示查询到的信息");
        text.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
    public void click(View v){
        TextView text = (TextView) findViewById(R.id.textView7);

        text.setMovementMethod(ScrollingMovementMethod.getInstance());

        EditText editText=(EditText)findViewById(R.id.editText3);
        String inputText=editText.getText().toString();

        EditText editText1=(EditText)findViewById(R.id.editText5);
        String inputText1=editText1.getText().toString();

        EditText editText2=(EditText)findViewById(R.id.editText6);
        String inputText2=editText2.getText().toString();

        EditText editText3=(EditText)findViewById(R.id.editText7);
        String inputText3=editText3.getText().toString();

        EditText editText4=(EditText)findViewById(R.id.editText8);
        String inputText4=editText4.getText().toString();

        EditText editText5=(EditText)findViewById(R.id.editText9);
        String inputText5=editText5.getText().toString();

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        String[] out = new String[1000];
        int[] count = new int[10];
        sql.select(out, count);
        String s = "" ;
        String l = "--------------------------------------------------------------------------------------------\n";
        int j = count[0];
        while (j>=0){
            s = s + l + out[j];
            j--;
        }

        text.setText(s);
    }
    public void click1(View v){
        TextView text = (TextView) findViewById(R.id.textView7);
        text.setText("关键词查询");
        text.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
    public void click2(View v){
        EditText editText=(EditText)findViewById(R.id.editText3);
        editText.setText("");
        EditText editText1=(EditText)findViewById(R.id.editText5);
        editText1.setText("");
        EditText editText2=(EditText)findViewById(R.id.editText6);
        editText2.setText("");
        EditText editText3=(EditText)findViewById(R.id.editText7);
        editText3.setText("");
        EditText editText4=(EditText)findViewById(R.id.editText8);
        editText4.setText("");
        EditText editText5=(EditText)findViewById(R.id.editText9);
        editText5.setText("");

        TextView text = (TextView) findViewById(R.id.textView7);
        text.setText("此处显示查询到的信息");
        text.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
