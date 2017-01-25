package com.example.seedcommando_9.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2;
    TextView name,email;
    Button b1,b2,b3;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        t1=(EditText)findViewById(R.id.ed);
        t2=(EditText)findViewById(R.id.ed2);

    sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
    if (sharedpreferences.contains(Name)) {
        t1.setText(sharedpreferences.getString(Name, ""));
    }
    if (sharedpreferences.contains(Email)) {
        t2.setText(sharedpreferences.getString(Email, ""));

    }

}

    public void save(View view) {
        String n = t1.getText().toString();
        String e =t2.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();
    }

    public void clear(View view) {
        name = (TextView) findViewById(R.id.t1);
        email = (TextView) findViewById(R.id.t2);
        t1.setText("");
        t2.setText("");

    }

    public void get(View view) {
        name = (TextView) findViewById(R.id.t1);
        email = (TextView) findViewById(R.id.t2);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            t1.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            t2.setText(sharedpreferences.getString(Email, ""));

        }
    }



}
