package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<String> mWordList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) this.mWordList.add("Word " + i);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        WordListAdapter mAdapter = new WordListAdapter(this, this.mWordList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(e -> {
            int index = this.mWordList.size();
            this.mWordList.add("Word " + index);
            mAdapter.notifyItemInserted(index);
        });
    }
}