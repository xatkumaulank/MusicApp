package com.example.ashikap.thefinalmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper db;
    Button bRegister;
    EditText eName, eMobile, eUsername, ePassword;
    //TextView tvnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);  db = new DatabaseHelper(this);
        eName =  findViewById(R.id.eName);
        eMobile =  findViewById(R.id.eMobile);
        eUsername =  findViewById(R.id.eUsername);
        ePassword =  findViewById(R.id.ePassword);
        bRegister =  findViewById(R.id.bRegister);
        

        bRegister.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String s1= eName.getText().toString();
        String s2= eMobile.getText().toString();
        String s3= eUsername.getText().toString();
        String s4= ePassword.getText().toString();
        if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("")){
            Toast.makeText(getApplicationContext(), "fields are empty", Toast.LENGTH_SHORT).show();;
        }
        else{

            Boolean checkusername= db.checkusername(s3);
            if (checkusername==true){
                Boolean insert = db.insert(s1, Integer.parseInt(s2), s3, s4);
                if (insert==true){
                    switch (v.getId()){
                        case R.id.bRegister:
                            Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT ).show();
                            startActivity(new Intent(this, LoginActivity.class));
                            break;
                    }
                }
            }
            Toast.makeText(getApplicationContext(), "Username or Password is not Valid", Toast.LENGTH_SHORT).show();
        }
    }
}
