package amirahmed.com.opensourcelibrary.ContactsList;


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

public class ContactsFragment extends Fragment {

    public static final String TAG = "CON";
    private List<Contact> contacts;
    private RecyclerView rv2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_contacts, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rv2 = (RecyclerView) getActivity().findViewById(R.id.rv2);

        rv2.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv2.setLayoutManager(llm);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Name 1", "Job 1", "Email 1", "Num 1"));
        contacts.add(new Contact("Name 2", "Job 2", "Email 2", "Num 2"));
    }

    private void initializeAdapter() {
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        rv2.setAdapter(adapter);
    }
}

