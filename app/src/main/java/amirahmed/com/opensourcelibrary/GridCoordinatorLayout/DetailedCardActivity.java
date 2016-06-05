package amirahmed.com.opensourcelibrary.GridCoordinatorLayout;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

import amirahmed.com.opensourcelibrary.MyScrollListener;
import amirahmed.com.opensourcelibrary.R;

public class DetailedCardActivity extends AppCompatActivity {

    private List<DetailedCard> itemses;
    private RecyclerView rv20;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_item_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Activity activity = this;
        setTitle(getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        if (toolbar != null) {
            activity.setTitle(Html.fromHtml("<small>Open Source library</small>"));
        }


        rv20 =(RecyclerView)findViewById(R.id.rv20);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv20.setLayoutManager(llm);
        rv20.setHasFixedSize(true);

        rv20.addOnScrollListener(new MyScrollListener(this) {
            @Override
            public void onMoved(int distance) {
                toolbar.setTranslationY(-distance);
            }
        });


        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        itemses = new ArrayList<>();
        itemses.add(new DetailedCard("Value","Value","Value","Value","Value","Value","Value", R.drawable.android));
        itemses.add(new DetailedCard("Value","Value","Value","Value","Value","Value","Value", R.drawable.android));
    }

    private void initializeAdapter(){
        DetailedCardAdapter adapter = new DetailedCardAdapter(itemses);
        rv20.setAdapter(adapter);
    }
}
