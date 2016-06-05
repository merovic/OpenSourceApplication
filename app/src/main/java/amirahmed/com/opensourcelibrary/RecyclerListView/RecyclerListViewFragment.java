package amirahmed.com.opensourcelibrary.RecyclerListView;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.opensourcelibrary.R;

public class RecyclerListViewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<RecyclerListViewItem> recyclerItems;
    public static String TAG = "AGA";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_recycler_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.items_recycler_view);

        mRecyclerView.setHasFixedSize(true);


        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        initializeData();
        initializeAdapter();
    }

    public void initializeData(){
        recyclerItems = new ArrayList<>();
        recyclerItems.add(new RecyclerListViewItem("Item1"));
    }

    private void initializeAdapter() {
        RecyclerListViewAdapter adapter = new RecyclerListViewAdapter(recyclerItems);
        mRecyclerView.setAdapter(adapter);
    }
}
