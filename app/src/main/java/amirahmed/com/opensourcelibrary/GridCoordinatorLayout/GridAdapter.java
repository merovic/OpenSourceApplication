package amirahmed.com.opensourcelibrary.GridCoordinatorLayout;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import amirahmed.com.opensourcelibrary.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    public static class GridViewHolder extends RecyclerView.ViewHolder {

        CardView cv10;
        ImageView Photo;
        Context context;

        GridViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            cv10 = (CardView)itemView.findViewById(R.id.cv10);
            Photo = (ImageView)itemView.findViewById(R.id.photo);


            Photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = null;
                    switch (getLayoutPosition()){
                        case 0:
                            intent = new Intent(context , DetailedCardActivity.class);
                            break;
                        case 1:
                            intent = new Intent(context , DetailedCardActivity.class );
                            break;
                        case 2:
                            intent = new Intent(context , DetailedCardActivity.class);
                            break;
                        case 3:
                            intent = new Intent(context , DetailedCardActivity.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });

        }
    }

    List<GridItem> gridItems;

    GridAdapter(List<GridItem> gridItems){

        this.gridItems = gridItems;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid, viewGroup, false);
        GridViewHolder pvh = new GridViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(GridViewHolder gridViewHolder, int i) {

        gridViewHolder.Photo.setImageResource(gridItems.get(i).brandId);
    }

    @Override
    public int getItemCount() {
        return gridItems.size();
    }
}
