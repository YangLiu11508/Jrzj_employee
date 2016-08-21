package jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.R;

/**
 * Created by Administrator on 2016/8/19.
 */
public class HistoryOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private Context context;

    public HistoryOrderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_histroy_order, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {
            super(view);

        }
    }
}
