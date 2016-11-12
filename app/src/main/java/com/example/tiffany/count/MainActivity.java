package com.example.tiffany.count;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    public static final String PREFS = "example";

    Button b1;
    Button b2;
    TextView tv1;
    TextView tv2;
    int counter;
    int counter2;
    String stringCounter;
    String stringCounter2;
    SharedPreferences example; // made shared Preferences global so you declare it once and make it accessible everywhere.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.save);
        b2 = (Button) findViewById(R.id.increase);
        tv1 = (TextView) findViewById(R.id.integer_number);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        example = getSharedPreferences(PREFS, counter);
        String userString = example.getString("userMessage", "Nothing Found");
        tv1.setText(userString);

    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        if (v==b1){

            counter++;
          stringCounter = Integer.toString(counter);
            tv1.setText(stringCounter);

        }

        if (v==b2){
            SharedPreferences.Editor editor = example.edit();
            editor.putString("userMessage", stringCounter);
            editor.commit();

        }
    }



}
