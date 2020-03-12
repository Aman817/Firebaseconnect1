package com.example.firebaseconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText textname,textfname,textage,textnumber;
    Button btnsent;
    DatabaseReference reff;
    Member member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textname = (EditText) findViewById(R.id.textname);
        textfname = (EditText) findViewById(R.id.textFname);
        textage =(EditText) findViewById(R.id.textage);
        textname =(EditText) findViewById(R.id.textname);
        btnsent =(Button)findViewById(R.id.btnsent);
        member =new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        btnsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age =Integer.parseInt(textage.getText().toString().trim());
                Long phn = Long.parseLong(textnumber.getText().toString().trim());
                member.setName(textname.getText().toString().trim());
                member.setFName(textfname.getText().toString().trim());
                member.setAge(age);
                member.setPh(phn);
                reff.push().setValue(member);
                Toast.makeText(MainActivity.this, " data insert", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
