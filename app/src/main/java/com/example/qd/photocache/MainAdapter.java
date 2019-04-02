package com.example.qd.photocache;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.qd.photocache.utils.BitmapUtils;

/**
 * Created by qd on 2018/2/2.
 * 发现首页adapter,
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context mContext;

    public MainAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_main, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Log.e("=====position", position + "");
        if (position > 5) {
            BitmapUtils.getInstance().disPlay(holder.iv_icon, "http://static.gamemm.com/upload/avatar/201903/29/62018_1553847955.jpg");
        } else {
            BitmapUtils.getInstance().disPlay(holder.iv_icon, "http://static.gamemm.com/upload/record/201904/2/62511_1554183931_95789.jpg");
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
        }
    }
}
