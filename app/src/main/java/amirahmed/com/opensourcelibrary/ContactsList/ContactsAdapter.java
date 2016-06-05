package amirahmed.com.opensourcelibrary.ContactsList;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import amirahmed.com.opensourcelibrary.R;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    List<Contact> contacts;

    ContactsAdapter(List<Contact> contacts){
        this.contacts = contacts;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        ContactViewHolder cvh = new ContactViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.name.setText(contacts.get(position).name);
        holder.job.setText(contacts.get(position).job);
        holder.email.setText(contacts.get(position).email);
        holder.phone.setText(contacts.get(position).phone);
    }

    @Override
    public int getItemCount() {

        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView job;
        TextView email;
        TextView phone;

        public ContactViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            name = (TextView)itemView.findViewById(R.id.name);
            job = (TextView)itemView.findViewById(R.id.job);
            email = (TextView)itemView.findViewById(R.id.email);
            phone = (TextView)itemView.findViewById(R.id.phone);
        }
    }
}
