package com.example.knowledgeninja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends BaseAdapter
{
    private Context context;
    private List<Card> cards;

    public CardAdapter(Context context, List<Card> cards)
    {
        this.context = context;
        this.cards = cards;
    }
    @Override
    public int getCount()
    {
        return cards.size();
    }
    @Override
    public Object getItem(int position)
    {
        return cards.get(position);
    }
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item_card, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.cardImageView = view.findViewById(R.id.cardImageView);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        Card card = cards.get(position);
        if (card.isFlipped())
        {
            viewHolder.cardImageView.setImageResource(card.getImageResId());
        }
        else
        {
            viewHolder.cardImageView.setImageResource(R.drawable.card_back);
        }
        return view;
    }
    private static class ViewHolder
    {
        ImageView cardImageView;
    }
}
