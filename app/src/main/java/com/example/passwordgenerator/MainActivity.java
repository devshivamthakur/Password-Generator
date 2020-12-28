package com.example.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private TextView set_password;
private Button generate_password,copy_password;
private String ps="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$&";
   private Random rp=new Random();
private     Integer len[]={4,5,6,7,8,9,10,11};
private Spinner  spinner;
    private  int plength=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set_password=findViewById(R.id.set_password);
        generate_password=findViewById(R.id.generate_password);
        copy_password=findViewById(R.id.copy_password);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item,len);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
        generate_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate_password();
            }
        });
    }

    private void generate_password() {

        //new password
        String np = "";
        while (np.length()!=plength){
            np+=String.valueOf(ps.charAt(rp.nextInt(ps.length())));
        }
     set_password.setText(np);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        plength=len[position];
        Toast.makeText(MainActivity.this, "you selected  "+plength+" ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}