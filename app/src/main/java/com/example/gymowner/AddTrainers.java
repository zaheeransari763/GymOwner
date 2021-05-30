package com.example.gymowner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddTrainers extends AppCompatActivity {
    private EditText name, contact, experience, email, speciality;
    private Button regtrainerbtn;

    FirebaseAuth mAuth;
    DatabaseReference reference;
    addtrainerAdapter addtrainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//fullscreen
        setContentView(R.layout.activity_add_trainers);

        TextView x = (TextView) findViewById(R.id.trainer_text);
        Typeface myustomFont = Typeface.createFromAsset(getAssets(), "fonts/Sony_Sketch_EF.ttf");
        x.setTypeface(myustomFont);//font style


        mAuth = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.trainername);
        contact = (EditText) findViewById(R.id.trainercontact);
        experience = (EditText) findViewById(R.id.trainerexp);
        email = (EditText) findViewById(R.id.traineremail);
        speciality = (EditText) findViewById(R.id.trainerspecial);

        addtrainer=new addtrainerAdapter();
        regtrainerbtn = (Button) findViewById(R.id.btn_addtrainer);
        regtrainerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regtrainer();
            }
        });

    }

    private void regtrainer() {

        final String namee = name.getText().toString();
        final String emaill = email.getText().toString();
        final String exp = experience.getText().toString();
        final String special = speciality.getText().toString();
        final String phone = contact.getText().toString();

        if (TextUtils.isEmpty(namee)) {
            Toast.makeText(this, "Name is Mandatory...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(emaill)) {
            Toast.makeText(this, "E-mail is empty...", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emaill).matches()) {
            Toast.makeText(AddTrainers.this, "Incorrect E-mail", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Contact is empty...", Toast.LENGTH_SHORT).show();
        } else if (phone.length() != 10) {
            Toast.makeText(this, "Invalid Contact...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(exp)) {
            Toast.makeText(this, "Experience needed...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(special)) {
            Toast.makeText(this, "Provide Your Speciality...", Toast.LENGTH_SHORT).show();
        }
        else {

                        reference = FirebaseDatabase.getInstance().getReference().child("Trainer");

                        addtrainer.setName(namee);
                        addtrainer.setContact(phone);
                        addtrainer.setEmail(emaill);
                        addtrainer.setExperience(exp);
                        addtrainer.setSpeciality(special);

                        reference.push().setValue(addtrainer);
                        Toast.makeText(AddTrainers.this, "Trainer Added Successfully...", Toast.LENGTH_SHORT).show();

                                    Intent DashMainIntent = new Intent(AddTrainers.this, DashboardActivity.class);
                                    DashMainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(DashMainIntent);
                                    finish();
        }

    }
}


