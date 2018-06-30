package com.example.olegs.botochat;

import android.app.Activity;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ChatActivity extends AppCompatActivity {

    /*Button button4;
    EditText editText4;
    //TextView textView2;
    RecyclerView recyclerView;

    private List<ChatAppMsgDTO> msgDtoList = null;

    public RecyclerViewAdapter(List<ChatAppMsgDTO> msgDtoList) {
        this.msgDtoList = msgDtoList;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        button4 = (Button)findViewById(R.id.button4);
        editText4 = (EditText)findViewById(R.id.editText4);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        //recyclerView.setMovementMethod(new ScrollingMovementMethod());
        button4.setOnClickListener(this);

        final RecyclerView msgRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        final List<ChatAppMsgDTO> msgDtoList = new ArrayList<ChatAppMsgDTO>();
        ChatAppMsgDTO msgDto = new ChatAppMsgDTO(ChatAppMsgDTO.MSG_TYPE_RECEIVED, "hello");
        msgDtoList.add(msgDto);

        final RecyclerViewAdapter chatAppMsgAdapter = new RecyclerViewAdapter(msgDtoList);

        msgRecyclerView.setAdapter(RecyclerView);

        final List<ChatAppMsgDTO> msgDtoList = new ArrayList<ChatAppMsgDTO>();
        ChatAppMsgDTO msgDto = new ChatAppMsgDTO(ChatAppMsgDTO.MSG_TYPE_RECEIVED, "hello");
        msgDtoList.add(msgDto);

    }



    @Override
    public void onClick(View view) {

        ///textView2.append(editText4.getText()+"\r\n");
       // editText4.setText("");
        ///textView2.append(getRandomString(10)+"\r\n");

        String msgContent = editText4.getText().toString();
        if(!TextUtils.isEmpty(msgContent))
        {
            // Add a new sent message to the list.
            ChatAppMsgDTO msgDto = new ChatAppMsgDTO(ChatAppMsgDTO.MSG_TYPE_SENT, msgContent);
            msgDtoList.add(msgDto);

            int newMsgPosition = msgDtoList.size() - 1;

            // Notify recycler view insert one new data.
            recyclerView.notifyItemInserted(newMsgPosition);

            // Scroll RecyclerView to the last message.
            msgRecyclerView.scrollToPosition(newMsgPosition);

            // Empty the input edit text box.
            msgInputText.setText("");
        }

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
*/

    private static final String ALLOWED_CHARACTERS ="0123456789qwertyuiopasdfghjklzxcvbnm";

    private  String getRandomString(final int sizeOfRandomString)
    {
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(sizeOfRandomString);
        for(int i=0;i<sizeOfRandomString;++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        setTitle("Botochat");

        // Get RecyclerView object.
        final RecyclerView msgRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        // Set RecyclerView layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this);
        msgRecyclerView.setLayoutManager(linearLayoutManager);

        // Create the initial data list.


        final List<ChatAppMsgDTO> msgDtoList = new ArrayList<ChatAppMsgDTO>();
        final ChatAppMsgDTO msgDto = new ChatAppMsgDTO(ChatAppMsgDTO.MSG_TYPE_RECEIVED, getRandomString(10));
        msgDtoList.add(msgDto);

        // Create the data adapter with above data list.
        final RecyclerViewAdapter chatAppMsgAdapter = new RecyclerViewAdapter(msgDtoList);

        // Set data adapter to RecyclerView.
        msgRecyclerView.setAdapter(chatAppMsgAdapter);

        final EditText msgInputText = (EditText)findViewById(R.id.editText4);

        Button msgSendButton = (Button)findViewById(R.id.button4);

        msgSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgContent = msgInputText.getText().toString();
                if(!TextUtils.isEmpty(msgContent))
                {
                    // Add a new sent message to the list.
                    ChatAppMsgDTO msgDto = new ChatAppMsgDTO(ChatAppMsgDTO.MSG_TYPE_SENT, msgContent);
                    msgDtoList.add(msgDto);

                    int newMsgPosition = msgDtoList.size() - 1;

                    // Notify recycler view insert one new data.
                    chatAppMsgAdapter.notifyItemInserted(newMsgPosition);

                    // Scroll RecyclerView to the last message.
                    msgRecyclerView.scrollToPosition(newMsgPosition);

                    // Empty the input edit text box.
                    msgInputText.setText("");
                }

                ChatAppMsgDTO msgDto = new ChatAppMsgDTO(ChatAppMsgDTO.MSG_TYPE_RECEIVED, getRandomString(10));
                msgDtoList.add(msgDto);


            }
        });
    }
}