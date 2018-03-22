package com.idouble.recyclertext;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder>{
    private List<Num> mNumList;
    public MyAdapter(List<Num> mNumList){
        this.mNumList = mNumList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ())
                .inflate (R.layout.item,parent,false);

        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Num num = mNumList.get (position);
        holder.textView.setText (num.getNumber ());
    }

    @Override
    public int getItemCount() {
        return mNumList.size ();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(View itemView) {
            super (itemView);
            textView = (TextView)itemView.findViewById (R.id.id_num);
        }
    }

}
