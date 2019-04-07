package com.example.upgraddemo.userInterest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.upgraddemo.R;
import com.example.upgraddemo.userInterest.model.data.Item;

import java.util.List;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.CustomViewHolder> {

    private List<Item> Tags;
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tag_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        Item tag = Tags.get(i);
        customViewHolder.tagTextView.setText(tag.getName().toString());
    }

    @Override
    public int getItemCount() {
        return Tags.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private final TextView tagTextView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tagTextView = itemView.findViewById(R.id.TagName);
        }
    }

    public TagsAdapter(List<Item> tags) {
        Tags = tags;
    }
}
