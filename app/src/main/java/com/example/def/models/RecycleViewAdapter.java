package com.example.def.models;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.def.R;
import java.util.ArrayList;


public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    public RecycleViewAdapter(Context context, ArrayList<String> items, ArrayList<String> answares) {
        this.context = context;
        this.questions = items;
        this.answers = answares;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.interno_recycle_view, viewGroup, false);
        return new Item(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((Item) viewHolder).textViewQuestion.setText(questions.get(i));
        ((Item) viewHolder).textViewAnsware.setText(answers.get(i));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class Item extends RecyclerView.ViewHolder {
        TextView textViewQuestion;
        TextView textViewAnsware;

        public Item(@NonNull View itemView) {
            super(itemView);
            textViewQuestion = itemView.findViewById(R.id.viewMessaggio);
            textViewAnsware = itemView.findViewById(R.id.viewMessaggioBot);
        }
    }
}
