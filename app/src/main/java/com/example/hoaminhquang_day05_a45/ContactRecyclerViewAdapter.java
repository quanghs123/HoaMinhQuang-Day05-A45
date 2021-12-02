package com.example.hoaminhquang_day05_a45;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.Viewoder> {
    List<ContactDemo> contactDemoList;
    public ContactRecyclerViewAdapter(List<ContactDemo> contactDemoList) {
        this.contactDemoList = contactDemoList;
    }

    @NonNull
    @Override
    public ContactRecyclerViewAdapter.Viewoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.icon_recyclerview,parent,false);
        Viewoder viewoder = new Viewoder(view);

        return viewoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactRecyclerViewAdapter.Viewoder holder, int position) {
        ContactDemo contactDemo = contactDemoList.get(position);
        holder.tvName.setText(contactDemo.getName());


    }

    @Override
    public int getItemCount() {
        return contactDemoList.size();
    }

    public class Viewoder extends RecyclerView.ViewHolder {
        TextView tvName;
        public Viewoder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
