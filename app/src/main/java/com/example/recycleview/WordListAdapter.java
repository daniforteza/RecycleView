package com.example.recycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private WordListAdapter adapter;
        public TextView wordItemView;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            this.wordItemView = itemView.findViewById(R.id.word);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {
            this.wordItemView.setText("Clicked!" + this.wordItemView.getText());
        }
    }

    private LayoutInflater layoutInflater;
    private LinkedList<String> mWordList;

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = this.layoutInflater.inflate(R.layout.item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = this.mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return this.mWordList.size();
    }
}