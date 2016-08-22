package jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        initView();
    }

    private void initView() {

        tv_ok = (TextView)findViewById(R.id.tv_ok);
        tv_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.tv_ok:
                //跳转到我的订单
                startActivity(new Intent(LoginActivity.this,MyOrderActivity.class));
                finish();
                break;
        }
    }
}
