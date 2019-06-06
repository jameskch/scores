package com.example.aa.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class result_Activity extends AppCompatActivity{
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        tvResult = (TextView)findViewById(R.id.textView2);
        showResult();
    }

    private void showResult(){
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int programming = bundle.getInt("programming");
        int dataStructure =bundle.getInt("dataStructure");
        int algorithm = bundle.getInt("alforithm");
        int sum = programming + dataStructure +algorithm;
        double average = sum/3.0;
        String text = "programming = " +programming +
                "\ndataSturcture = " +dataStructure +
                "\nalgorithm = " +algorithm +
                "\nsum = " +sum +
                "\naverage = " +nf.format(average);
        tvResult.setText(text);
        alert(average);
    }

    private void alert(double average){
        String message = new String();
        String title = new String();
        int pic = 0;
        if(average ==100){
            message = "100";
            title = "Pass";
            pic = R.drawable.ic_launcher_foreground;
        }

        else if(average >=60 ){
            message ="Congratulation!!";
            title ="Pass";
            pic =R.drawable.ic_launcher_background;
        }
        else {
            message = "sorry";
            title = "fail";
            pic =R.drawable.ic_launcher_foreground;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("cancel",null);
        builder.setNeutralButton("Nothing",null);
        builder.show();


    }
}
