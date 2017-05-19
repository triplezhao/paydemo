package com.potato.library.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class PotatoBaseListAdapter<VH extends RecyclerView.ViewHolder> extends BaseAdapter {

    public Context mContext;

    public List mData = new ArrayList();
    ;
    public LayoutInflater mInflater;


    public PotatoBaseListAdapter(Context context) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    //返回绑定的数据
    public void setDataList(List data) {
        if (mData == null) {
            mData = new ArrayList();
        }
        mData.clear();
        mData.addAll(data);
    }


    @Override
    public int getCount() {
        if (mData == null || mData.size() == 0) {
            return 0;
        }
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //item控件
        VH vh = null;
        if (convertView == null) {
            //findview  clumn
            vh = onCreateViewHolder(parent, getItemViewType(position));
            convertView = vh.itemView;
            convertView.setTag(vh);
        } else {
            vh = (VH) convertView.getTag();
        }
        onBindViewHolder(vh, position);
        return convertView;
    }

    //返回 inflate出 每个元素的 layout，可以根据type给不同的布局
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    //将数据设置到itemView上 @Override
    public abstract void onBindViewHolder(VH vh, int position);
}