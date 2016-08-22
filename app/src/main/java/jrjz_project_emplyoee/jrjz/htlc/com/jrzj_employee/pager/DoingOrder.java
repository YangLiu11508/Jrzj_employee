package jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.pager;

import android.content.Context;
import android.os.Handler;
import android.view.View;


import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.R;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.adapter.DoingOrderAdapter;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.base.BasePager;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.refresh.PullToRefreshRecycleView;

/**
 * Created by Administrator on 2016/8/16.
 * 进行中订单页
 */
public class DoingOrder extends BasePager {

    private PullToRefreshRecycleView recyclerview_doing_order;
    private DoingOrderAdapter adapter;

    private Handler mHandler = new Handler();


    public DoingOrder(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        rootView = View.inflate(context, R.layout.doing_order, null);
        fl_basepager.removeAllViews();
        fl_basepager.addView(rootView);
        findView();
        setAdapter();
    }

    /**
     * 设置适配器
     */
    private void setAdapter() {
        //设置adapter
        adapter = new DoingOrderAdapter(context);
        recyclerview_doing_order.setAdapter(adapter);

        recyclerview_doing_order.setOnRefreshListener(new PullToRefreshRecycleView.OnRefreshListener() {
            @Override
            public void onPullDownRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //下拉刷新的操作

                        adapter.notifyDataSetChanged();
                        recyclerview_doing_order.completeRefresh();
                    }
                }, 2000);

            }

            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //加载更多的操作

                        adapter.notifyDataSetChanged();
                        recyclerview_doing_order.completeLoadMore();
                    }
                }, 1000);

            }
        });

//        recyclerview_doing_order.setLayoutManager(new LinearLayoutManager(context));



    }

    /**
     * 初始化控件
     */
    private void findView() {
        recyclerview_doing_order = (PullToRefreshRecycleView) rootView.findViewById(R.id.recyclerview_doing_order);
    }

}
