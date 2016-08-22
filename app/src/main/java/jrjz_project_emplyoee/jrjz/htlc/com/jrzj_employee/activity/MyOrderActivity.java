package jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.R;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.adapter.MyPagerAdapter;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.base.BasePager;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.pager.DoingOrder;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.pager.HistoryOrder;

public class MyOrderActivity extends AppCompatActivity implements View.OnClickListener {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TextView tv_exit; //退出
    //viewpager的集合
    private List<BasePager> viewPagerDatas;
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        initView();
    }


    /**
     * 初始化视图
     */
    private void initView() {


        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        mInflater = LayoutInflater.from(this);
        tv_exit = (TextView)findViewById(R.id.tv_exit);

        tv_exit.setOnClickListener(this);
        //添加页卡标题
        mTitleList.add("进行中订单");
        mTitleList.add("历史订单");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));

        addViewPagerData();

        //设置适配器 MyPagerAdapter mAdapter =
        MyPagerAdapter mAdapter = new MyPagerAdapter(this, mTitleList, viewPagerDatas);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

    }

    /**
     * 添加viewPager的数据
     */
    private void addViewPagerData() {
        viewPagerDatas = new ArrayList<BasePager>();
        viewPagerDatas.add(new DoingOrder(this));
        viewPagerDatas.add(new HistoryOrder(this));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.tv_exit:
                //跳转到登陆页面
                startActivity(new Intent(MyOrderActivity.this,LoginActivity.class));
                finish();
                break;
        }
    }
}
