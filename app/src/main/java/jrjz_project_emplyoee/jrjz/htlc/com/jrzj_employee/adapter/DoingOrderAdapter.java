package jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.R;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.activity.ProductOrderActivity;

/**
 * Created by Administrator on 2016/8/19.
 */
public class DoingOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public DoingOrderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_doing_order, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myHolder = (MyViewHolder) holder;
        myHolder.tv_product_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到生成订单页
                context.startActivity(new Intent(context,ProductOrderActivity.class));
            }
        });


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_product_order;

        public MyViewHolder(View view) {
            super(view);
            tv_product_order = (TextView) view.findViewById(R.id.tv_product_order);
        }
    }
}
