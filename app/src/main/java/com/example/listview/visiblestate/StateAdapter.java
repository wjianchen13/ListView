package com.example.listview.visiblestate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by baoyz on 2014/6/29.
 */
class StateAdapter extends BaseAdapter {

    // 数据集
    private List<String> mDataset;

    public StateAdapter(List<String> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataset.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, null);

            holder.tv_content = (TextView) convertView;
            //3.打标记
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_content.setText(getItem(position).toString());

        return convertView;
    }
}

class ViewHolder {
    TextView tv_content;
}