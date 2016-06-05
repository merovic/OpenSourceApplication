package amirahmed.com.opensourcelibrary.RecyclerListView;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import amirahmed.com.opensourcelibrary.R;

public class RecyclerListViewAdapter extends RecyclerView.Adapter<RecyclerListViewAdapter.ViewHolder> {

    List<RecyclerListViewItem> listItems;

    RecyclerListViewAdapter(List<RecyclerListViewItem> listItems){

        this.listItems = listItems;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_layout, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder itemViewHolder, int position) {

        itemViewHolder.itemName.setText(listItems.get(position).Item);
    }

    @Override
    public int getItemCount() {

        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        CardView cv;
        Context context;

        public ViewHolder(View itemView) {

            super(itemView);
            context = itemView.getContext();
            cv = (CardView)itemView.findViewById(R.id.cv);
            itemName = (TextView)itemView.findViewById(R.id.itemName);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = null;
                    switch (getLayoutPosition()){
                        case 0:
                            intent = new Intent(context , IntroActivity.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }
}
