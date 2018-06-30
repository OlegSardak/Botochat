package com.example.olegs.botochat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ChatViewActivity> {

    private List<ChatAppMsgDTO> msgDtoList = null;

    public RecyclerViewAdapter(List<ChatAppMsgDTO> msgDtoList) {
        this.msgDtoList = msgDtoList;
    }

    @NonNull
    @Override
    public ChatViewActivity onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_chat_view, parent, false);
        return new ChatViewActivity(view);
    }

    @Override
    public void onBindViewHolder(ChatViewActivity holder, int position) {



        ChatAppMsgDTO msgDto = this.msgDtoList.get(position);

        if(msgDto.MSG_TYPE_RECEIVED.equals(msgDto.getMsgType()))
        {

            holder.leftMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.leftMsgTextView.setText(msgDto.getMsgContent());

            holder.rightMsgLayout.setVisibility(LinearLayout.GONE);
        }

        else if(msgDto.MSG_TYPE_SENT.equals(msgDto.getMsgType()))
        {

            holder.rightMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.rightMsgTextView.setText(msgDto.getMsgContent());

            holder.leftMsgLayout.setVisibility(LinearLayout.GONE);
        }

    }

    @Override
    public int getItemCount() {
        if(msgDtoList==null)
        {
            msgDtoList = new ArrayList<ChatAppMsgDTO>();
        }
        return msgDtoList.size();
    }
}
