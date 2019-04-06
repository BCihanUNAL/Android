package com.example.cihan.blm3520_1;

import android.content.Context;
import android.content.Intent;
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
    private Context callBack;

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
    public MyAdapter(List<Dersler> myDataset,Context callback){
        list=myDataset;
        callBack=callback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.example, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Dersler name = list.get(position);
        holder.textHeader.setText(name.getDers());
        holder.textFooter.setText(name.getNot());

        View v = holder.layout;

        if(position!=0) {
            final int posSet = position;
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(callBack,DersDetayActivity.class);
                    intent.putExtra("ders_isim",list.get(position).getDers());
                    intent.putExtra("kisi",list.get(position).getKisi());
                    intent.putExtra("ortalama",list.get(position).getOrt());
                    callBack.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
