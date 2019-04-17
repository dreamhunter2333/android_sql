package com.example.carsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.os.StrictMode;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MysqlTest sql = new MysqlTest();
    String inputText="";
    String inputText1="";
    String inputText2="";
    String inputText3="";
    String inputText4="";
    String inputText5="";


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

        EditText editText=(EditText)findViewById(R.id.editText3);
        inputText=editText.getText().toString();

        EditText editText1=(EditText)findViewById(R.id.editText5);
        inputText1=editText1.getText().toString();

        EditText editText2=(EditText)findViewById(R.id.editText6);
        inputText2=editText2.getText().toString();

        EditText editText3=(EditText)findViewById(R.id.editText7);
        inputText3=editText3.getText().toString();

        EditText editText4=(EditText)findViewById(R.id.editText8);
        inputText4=editText4.getText().toString();

        EditText editText5=(EditText)findViewById(R.id.editText9);
        inputText5=editText5.getText().toString();
        if (editText.length()==0){
            System.out.println("数据库地址为空");
            Toast.makeText(getApplicationContext(), "数据库地址为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (editText1.length()==0){
            System.out.println("用户名为空");
            Toast.makeText(getApplicationContext(), "用户名为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (editText2.length()==0){
            System.out.println("密码为空");
            Toast.makeText(getApplicationContext(), "密码为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (editText3.length()==0){
            System.out.println("数据库名称为空");
            Toast.makeText(getApplicationContext(), "数据库名称为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (editText4.length()==0){
            System.out.println("表名称为空");
            Toast.makeText(getApplicationContext(), "表名称为空", Toast.LENGTH_SHORT).show();
            return;
        }

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        String[] out = new String[1000];
        int[] count = new int[10];
        sql.select(out, count, inputText, inputText1, inputText2, inputText3, inputText4);
        String s = "" ;
        String l = "--------------------------------------------------------------------------------------------\n";
        int j = count[0];
        while (j>=0){
            s = s + l + out[j];
            j--;
        }
        text.setText(s);
        text.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
    public void click1(View v){
        EditText editText=(EditText)findViewById(R.id.editText3);
        inputText=editText.getText().toString();

        EditText editText1=(EditText)findViewById(R.id.editText5);
        inputText1=editText1.getText().toString();

        EditText editText2=(EditText)findViewById(R.id.editText6);
        inputText2=editText2.getText().toString();

        EditText editText3=(EditText)findViewById(R.id.editText7);
        inputText3=editText3.getText().toString();

        EditText editText4=(EditText)findViewById(R.id.editText8);
        inputText4=editText4.getText().toString();

        EditText editText5=(EditText)findViewById(R.id.editText9);
        inputText5=editText5.getText().toString();
        if (editText.length()==0){
            System.out.println("数据库地址为空");
            Toast.makeText(getApplicationContext(), "数据库地址为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (editText1.length()==0){
            System.out.println("用户名为空");
            Toast.makeText(getApplicationContext(), "用户名为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (editText2.length()==0){
            System.out.println("密码为空");
            Toast.makeText(getApplicationContext(), "密码为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (editText3.length()==0){
            System.out.println("数据库名称为空");
            Toast.makeText(getApplicationContext(), "数据库名称为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (editText4.length()==0){
            System.out.println("表名称为空");
            Toast.makeText(getApplicationContext(), "表名称为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (editText5.length()==0){
            System.out.println("关键字为空");
            Toast.makeText(getApplicationContext(), "关键字为空", Toast.LENGTH_SHORT).show();
            return;
        }

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        String[] out2 = new String[1000];
        int[] count2 = new int[10];
        sql.select2(out2, count2, inputText, inputText1, inputText2, inputText3, inputText4, inputText5);
        String s = "" ;
        String l = "--------------------------------------------------------------------------------------------\n";
        int j = count2[0];
        while (j>=0){
            s = s + l + out2[j];
            j--;
        }
        TextView text = (TextView) findViewById(R.id.textView7);
        text.setText(s);
        text.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
    public void click2(View v){
        EditText editText=(EditText)findViewById(R.id.editText3);
        editText.setText("");
//        editText.setText("192.168.2.100");
        EditText editText1=(EditText)findViewById(R.id.editText5);
        editText1.setText("");
//        editText1.setText("python");
        EditText editText2=(EditText)findViewById(R.id.editText6);
        editText2.setText("");
//        editText2.setText("Python12345@");
        EditText editText3=(EditText)findViewById(R.id.editText7);
        editText3.setText("");
//        editText3.setText("chepai");
        EditText editText4=(EditText)findViewById(R.id.editText8);
        editText4.setText("");
//        editText4.setText("CARINFO");
        EditText editText5=(EditText)findViewById(R.id.editText9);
        editText5.setText("");

        TextView text = (TextView) findViewById(R.id.textView7);
        text.setText("此处显示查询到的信息");
        text.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
