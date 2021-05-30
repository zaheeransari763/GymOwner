package com.example.gymowner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText email,pass;
   private   Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//fullscreen
        setContentView(R.layout.activity_login);

        TextView t = (TextView) findViewById(R.id.text1);
        Typeface myCustomFont= Typeface.createFromAsset(getAssets(),"fonts/Sony_Sketch_EF.ttf");
        t.setTypeface(myCustomFont);//font style

        TextView x = (TextView) findViewById(R.id.quotetext);
        Typeface myustomFont= Typeface.createFromAsset(getAssets(),"fonts/Sony_Sketch_EF.ttf");
        x.setTypeface(myustomFont);//font style


        email=(EditText)findViewById(R.id.emaill);
        pass=(EditText)findViewById(R.id.passwrd);
        login=(Button)findViewById(R.id.Lloginbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(email.getText().toString(),pass.getText().toString());
            }
        });




    }
    private void validate(String emaill,String password)
    {
        if ((emaill.equals("d") ) && (password.equals("1") )){

            Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        else if ((TextUtils.isEmpty(emaill) || TextUtils.isEmpty(password))){
            Toast.makeText(this,"Email or password cannot be empty",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
        }

    }


}
