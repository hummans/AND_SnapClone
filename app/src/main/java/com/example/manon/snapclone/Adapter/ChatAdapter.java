package com.example.manon.snapclone.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manon.snapclone.R;

/**
 * Created by manon on 08/03/2018.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{

    private int nbItems;
    final private ListItemClickListener mOnClickListener;

    public ChatAdapter(int nbItems, ListItemClickListener clickListener){
        this.nbItems = nbItems;
        mOnClickListener = clickListener;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_chat, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return nbItems;
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        View typeChat;
        TextView name;
        TextView date;

        public ChatViewHolder(View itemView) {
            super(itemView);
            typeChat = itemView.findViewById(R.id.snap_square);
            name = itemView.findViewById(R.id.snap_name);
            date = itemView.findViewById(R.id.snap_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
