package com.example.manon.snapclone.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.manon.snapclone.Adapter.ChatAdapter;
import com.example.manon.snapclone.R;

public class ChatFragment extends Fragment implements ChatAdapter.ListItemClickListener {

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    private ChatAdapter adapter;
    private RecyclerView recycler;
    private Toast toast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        recycler = view.findViewById(R.id.chatRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);

        adapter = new ChatAdapter(25, this);
        recycler.setAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), Integer.toString(clickedItemIndex), Toast.LENGTH_SHORT);
        toast.show();
    }
}
