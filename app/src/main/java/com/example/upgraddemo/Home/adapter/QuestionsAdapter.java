package com.example.upgraddemo.Home.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.upgraddemo.Home.model.data.hot.Item;
import com.example.upgraddemo.R;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.CustomViewHolder> {
    private final List<Item> Questions;
    private final String priority;
    private final List<com.example.upgraddemo.Home.model.data.week.Item> weekQuestions;

    public QuestionsAdapter(List<Item> Questions,List<com.example.upgraddemo.Home.model.data.week.Item> weekQuestions,String priority) {
            this.Questions = Questions;
            this.priority = priority;
            this.weekQuestions = weekQuestions;
    }

    @NonNull
    @Override
    public QuestionsAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsAdapter.CustomViewHolder customViewHolder, int i) {
        if(priority=="hot"){
            final Item question = Questions.get(i);
            final String title = question.getTitle();
            final String link = question.getLink();
            customViewHolder.QuestionTextView.setText(title);
            customViewHolder.QuestionTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  openTabinBrowser(link,v.getContext());
                }
            });

            customViewHolder.QuestionTextView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, link);
                    v.getContext().startActivity(Intent.createChooser(sharingIntent, "choose an app"));
                   return true;
                }
            });
        }
        else if(priority == "week"){
            final com.example.upgraddemo.Home.model.data.week.Item question = weekQuestions.get(i);
            final String title = question.getTitle();
            final String link = question.getLink();
            customViewHolder.QuestionTextView.setText(title);
            customViewHolder.QuestionTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openTabinBrowser(link, v.getContext());
                }
            });

            customViewHolder.QuestionTextView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, link);
                    v.getContext().startActivity(Intent.createChooser(sharingIntent, "choose an app"));
                    return true;
                }
            });
        }

    }

    private void openTabinBrowser(String link, Context context) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(link));
    }

    @Override
    public int getItemCount() {
        if(priority == "hot"){
            return Questions.size() ;
        }
        else if(priority == "week"){
            return weekQuestions.size();
        }
        return Questions.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private final TextView QuestionTextView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            QuestionTextView = itemView.findViewById(R.id.questionName);
        }
    }
}
