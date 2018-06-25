package com.example.olegs.botochat;

import android.app.Activity;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class ChatActivity extends AppCompatActivity implements View.OnClickListener{

    Button button4;
    EditText editText4;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        button4 = (Button)findViewById(R.id.button4);
        editText4 = (EditText)findViewById(R.id.editText4);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setMovementMethod(new ScrollingMovementMethod());
        button4.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        textView2.append(editText4.getText()+"\r\n");
        editText4.setText("");
        textView2.append(getRandomString(10)+"\r\n");

    }

    private static final String ALLOWED_CHARACTERS ="0123456789qwertyuiopasdfghjklzxcvbnm";

    private  String getRandomString(final int sizeOfRandomString)
    {
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(sizeOfRandomString);
        for(int i=0;i<sizeOfRandomString;++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }
}
