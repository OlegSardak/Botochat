package com.example.olegs.botochat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button  = (Button)  findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);


        button.setOnClickListener(this);



    }
    @Override
    public void onClick(View view){

        if (editText.getText().toString().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b") &&
                editText2.getText().toString().matches("\\b(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*\\b")){
            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Login or Password is incorect", Toast.LENGTH_SHORT).show();
        }


    }
}
