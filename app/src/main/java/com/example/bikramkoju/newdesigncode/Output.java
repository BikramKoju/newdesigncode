package com.example.bikramkoju.newdesigncode;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Bikramkoju on 5/3/2017.
 */

public class Output extends AppCompatActivity {
    DatabaseHelper db;
    Module m;
    TextView output;
    TextView expenses;
    TypeB oobj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        output = (TextView) findViewById(R.id.output);
        expenses = (TextView) findViewById(R.id.expenses);

        db=new DatabaseHelper(this);

        String exp=db.getExpense();

        int inco=db.getIncome();

        m = new Module();
        m.getSum();
        //Toast.makeText(Output.this, "value" + m.getSum(), Toast.LENGTH_SHORT).show();
       // output.setText("Income is: " + String.valueOf(m.getSum()));
        output.setText("Your Income is: " + inco);

        //output.setText(String.valueOf(b));

        oobj = new TypeB();
        long value = oobj.getSum();
        expenses.setText("\n\n\nYour Expenses is: " + exp);

    }
}
