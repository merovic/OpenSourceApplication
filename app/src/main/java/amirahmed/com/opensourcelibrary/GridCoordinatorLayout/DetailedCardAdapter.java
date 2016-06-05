package amirahmed.com.opensourcelibrary.GridCoordinatorLayout;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import amirahmed.com.opensourcelibrary.R;

public class DetailedCardAdapter extends RecyclerView.Adapter<DetailedCardAdapter.ItemViewHolder> {

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        CardView cv20;
        TextView Item;
        TextView Item1;
        TextView Item2;
        TextView Item3;
        TextView Item4;
        TextView Item5;
        TextView Item6;
        ImageView Pic;
        Context context;

        ItemViewHolder(View itemView) {
            super(itemView);
            cv20 = (CardView)itemView.findViewById(R.id.cv);
            context = itemView.getContext();
            Item = (TextView)itemView.findViewById(R.id.Item);
            Item1 = (TextView)itemView.findViewById(R.id.Item1);
            Item2 = (TextView)itemView.findViewById(R.id.Item2);
            Item3 = (TextView)itemView.findViewById(R.id.Item3);
            Item4 = (TextView)itemView.findViewById(R.id.Item4);
            Item5 = (TextView)itemView.findViewById(R.id.Item5);
            Item6 = (TextView)itemView.findViewById(R.id.Item6);
            Pic = (ImageView)itemView.findViewById(R.id.pic);


            cv20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = null;
                    switch (getLayoutPosition()){
                        case 0:
                            intent = new Intent(context , CoordinatorActivity.class);
                            break;
                        case 1:
                            intent = new Intent(context , CoordinatorActivity.class );
                            break;
                        case 2:
                            intent = new Intent(context , CoordinatorActivity.class);
                            break;
                        case 3:
                            intent = new Intent(context , CoordinatorActivity.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });

        }
    }

    List<DetailedCard> items;

    DetailedCardAdapter(List<DetailedCard> items){

        this.items = items;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.Item.setText(items.get(i).Item);
        itemViewHolder.Item1.setText(items.get(i).Item1);
        itemViewHolder.Item2.setText(items.get(i).Item2);
        itemViewHolder.Item3.setText(items.get(i).Item3);
        itemViewHolder.Item4.setText(items.get(i).Item4);
        itemViewHolder.Item5.setText(items.get(i).Item5);
        itemViewHolder.Item6.setText(items.get(i).Item6);
        itemViewHolder.Pic.setImageResource(items.get(i).Pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
