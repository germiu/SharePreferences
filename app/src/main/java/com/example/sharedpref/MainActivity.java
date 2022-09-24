package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_user,et_pass;
    Button bt_save,bt_del,bt_retrieve;

    TextView v_user,v_pass;
    String ShareDB = "My_PDB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_pass);
        bt_save = findViewById(R.id.bt_save);
        bt_retrieve = findViewById(R.id.bt_retrieve);
        bt_del = findViewById(R.id.bt_del);
        v_user = findViewById(R.id.v_user);
        v_pass = findViewById(R.id.v_pass);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = et_user.getText().toString();
                String pass = et_pass.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences(ShareDB,MODE_PRIVATE).edit();
                editor.putString("username",user);
                editor.putString("password",pass);
                editor.apply();
                et_user.setText("");
                et_pass.setText("");
            }
        });

        //String SharedDB = "My_Preference";

        bt_retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences PrefDB = getSharedPreferences(ShareDB,MODE_PRIVATE);
                String user1 = PrefDB.getString("username", "No username defined ");
                String pass1 = PrefDB.getString("password","");

                et_user.setText(user1);
                et_pass.setText(pass1);

                // Toast.makeText(MainActivity.this,"values"+user1,Toast.LENGTH_SHORT).show();
                // Toast.makeText(MainActivity.this,"values"+pass1,Toast.LENGTH_SHORT).show();
            }
        });

        bt_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences PrefD = getSharedPreferences(ShareDB,MODE_PRIVATE);
                PrefD.edit().remove("username").commit();
                PrefD.edit().remove("password").commit();

//                SharedPreferences PrefDB = getSharedPreferences(ShareDB,MODE_PRIVATE);
                String user2 = PrefD.getString("username", "No username defined ");
                String pass2 = PrefD.getString("password","No password defined");

                et_user.setText(user2);
                et_pass.setText(pass2);
            }
        });
    }
}