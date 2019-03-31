package com.example.cihan.blm3520_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cihan on 26.03.2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Dersler> list;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textHeader;
        public TextView textFooter;
        public View layout;

        public ViewHolder(View v){
            super(v);
            layout=v;
            textHeader = (TextView)v.findViewById(R.id.firstLine);
            textFooter = (TextView)v.findViewById(R.id.secondLine);
        }
    }
    public void add(int position,Dersler item){
        list.add(position,item);
        notifyItemInserted(position);
    }
    public void remove(int pos){
        list.remove(pos);
        notifyItemRemoved(pos);
    }
    public MyAdapter(List<Dersler> myDataset){list=myDataset;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.example, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Dersler name = list.get(position);
        holder.textHeader.setText(name.getDers());
        holder.textFooter.setText(name.getNot());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
