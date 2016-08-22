package jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.pager;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.R;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.adapter.HistoryOrderAdapter;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.base.BasePager;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.refresh.PullToRefreshRecycleView;

/**
 * Created by Administrator on 2016/8/16.
 * 历史订单页
 */
public class HistoryOrder extends BasePager {

    private PullToRefreshRecycleView recyclerview_history_order;
    private HistoryOrderAdapter adapter;

    private Handler mHandler = new Handler();


    public HistoryOrder(Context context) {
        super(context);
    }

    @Override
    public void initData() {

        rootView = View.inflate(context, R.layout.history_order, null);

        fl_basepager.removeAllViews();
        fl_basepager.addView(rootView);
        findView();
        setAdapter();

    }

    private void setAdapter() {
        //设置adapter
        adapter = new HistoryOrderAdapter(context);

        recyclerview_history_order.setOnRefreshListener(new PullToRefreshRecycleView.OnRefreshListener() {
            @Override
            public void onPullDownRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //下拉刷新的操作

                        adapter.notifyDataSetChanged();
                        recyclerview_history_order.completeRefresh();
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
                        recyclerview_history_order.completeLoadMore();
                    }
                }, 1000);

            }
        });
//        recyclerview_history_order.setLayoutManager(new LinearLayoutManager(context));

        recyclerview_history_order.setAdapter(adapter);

    }

    private void findView() {
        recyclerview_history_order = (PullToRefreshRecycleView) rootView.findViewById(R.id.recyclerview_history_order);
    }
}
