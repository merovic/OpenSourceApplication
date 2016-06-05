package amirahmed.com.opensourcelibrary.GridCoordinatorLayout;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.opensourcelibrary.R;

public class GridFragment extends Fragment {

    private List<GridItem> gridItems;
    private RecyclerView rv10;
    public static final String TAG = "PE";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        rv10 =(RecyclerView)getActivity().findViewById(R.id.rv10);

        StaggeredGridLayoutManager llm = new StaggeredGridLayoutManager(2,1);
        rv10.setLayoutManager(llm);
        rv10.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData(){
         gridItems = new ArrayList<>();
         gridItems.add(new GridItem(R.drawable.android));
         gridItems.add(new GridItem(R.drawable.android));
         gridItems.add(new GridItem(R.drawable.android));
         gridItems.add(new GridItem(R.drawable.android));
    }

    private void initializeAdapter(){
        GridAdapter adapter = new GridAdapter(gridItems);
        rv10.setAdapter(adapter);
    }
}
