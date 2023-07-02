package com.example.knowledgeninja;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class FactAdapter extends RecyclerView.Adapter<FactAdapter.FactViewHolder> {
   private List<Fact> factList;
   private Context context;

    public FactAdapter(List<Fact> factList, Context context) {
    this.factList = factList;
    this.context = context;
    }

    @NonNull
    @Override
    public FactAdapter.FactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fact_card_layout, parent, false);
        return new FactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FactAdapter.FactViewHolder holder, int position) {
        Fact fact = factList.get(position);
        holder.factImage.setImageResource(fact.getFactImage());
        holder.topicFact.setText(fact.getTopic());
        holder.subTopicFact.setText(fact.getSubTopic());
        holder.factName.setText(fact.getFactName());

        holder.actionButton.setOnClickListener(view -> {
            String strFactName = fact.getFactName();

            Intent intent = new Intent(context, InformationActivity.class);
            intent.putExtra("factName_key", strFactName);
            intent.putExtra("fact_key", context.getString(fact.getFactFact()));
            intent.putExtra("imageLocation_key", fact.getFactImage());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return factList.size();
    }
    public void updateList(List<Fact> newList){
        factList = newList;
        notifyDataSetChanged();
    }

    public static class FactViewHolder extends RecyclerView.ViewHolder{
        ImageView factImage;
        TextView topicFact;
        TextView subTopicFact;
        TextView factName;
        ImageView actionButton;

        public FactViewHolder(@NonNull View itemView) {
            super(itemView);

            factImage = itemView.findViewById(R.id.imageViewOfFact);
            topicFact = itemView.findViewById(R.id.textViewTopic);
            subTopicFact = itemView.findViewById(R.id.textViewSubTopic);
            factName = itemView.findViewById(R.id.textViewFactName);
            actionButton = itemView.findViewById(R.id.imageViewActionButton);
        }
    }
}
