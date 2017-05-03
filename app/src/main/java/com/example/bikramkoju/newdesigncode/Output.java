package com.example.bikramkoju.newdesigncode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Bikramkoju on 5/3/2017.
 */

public class Output extends AppCompatActivity  {
   Module m;
    TextView output;
    TextView expenses;
    TypeB oobj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        output = (TextView) findViewById(R.id.output);
        expenses= (TextView) findViewById(R.id.expenses);

        oobj=new TypeB();

      long value=oobj.getSum();



        m=new Module();
        output.setText("income is"+String.valueOf(m.getSum()));



        //output.setText(String.valueOf(b));


        expenses.setText("expenses is:"+value);



    }
}
