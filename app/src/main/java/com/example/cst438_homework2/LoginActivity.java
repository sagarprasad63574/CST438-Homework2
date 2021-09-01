package com.example.cst438_homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = findViewById(R.id.button);
        EditText usernameET = findViewById(R.id.editTextTextPersonName);
        EditText passwordET = findViewById(R.id.editTextTextPassword);
        TextView errorMessage = findViewById(R.id.textView);

        if(Accounts.accounts.isEmpty()){
            Accounts.createAccounts();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();
                Accounts temp = Accounts.getByUsername(username);
                if(temp == null){
                    usernameET.setBackgroundColor(Color.BLUE);
                    errorMessage.setText("Wrong Username");
                    return;
                }
                errorMessage.setTextColor(Color.WHITE);

                if(Accounts.getByPassword(password) == null) {
                    passwordET.setBackgroundColor(Color.BLUE);
                    errorMessage.setText("Wrong Password");
                    return;
                }
                errorMessage.setTextColor(Color.WHITE);

                Intent intent = MainActivity.intentFactory(LoginActivity.this, temp.userId);
                startActivity(intent);
            }
        });
    }
}