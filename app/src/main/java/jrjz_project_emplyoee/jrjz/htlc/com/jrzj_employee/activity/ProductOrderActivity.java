package jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.R;
import jrjz_project_emplyoee.jrjz.htlc.com.jrzj_employee.util.EditInputFilter;

public class ProductOrderActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText et_service_price; //服务费
    private EditText et_material_price;    //主材料费
    private EditText et_other_price;    //增项费
    private CheckBox cb_service_price;
    private CheckBox cb_material;
    private CheckBox cb_other;

    private TextView tv_totle_price; //合计总价格

    private double servicePrice; //服务价格
    private double materialPrice; //材料价格
    private double otherPrice;   //增项价格

    private boolean isService; //是否选中服务
    private boolean isMaterial; //是否选中价格
    private boolean isOther;   //是否选中增项

    private double totalPrice = 0; //总价格

    private TextView tv_commit; //提交按钮
    private ImageView img_back; //后退


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_order);

        initView();
    }

    private void initView() {

        et_service_price = (EditText) findViewById(R.id.et_service_price);
        et_material_price = (EditText) findViewById(R.id.et_material_price);
        et_other_price = (EditText) findViewById(R.id.et_other_price);
        tv_totle_price = (TextView) findViewById(R.id.tv_totle_price);
        cb_service_price = (CheckBox) findViewById(R.id.cb_service_price);
        cb_material = (CheckBox) findViewById(R.id.cb_material);
        cb_other = (CheckBox) findViewById(R.id.cb_other);
        tv_commit = (TextView) findViewById(R.id.tv_commit);
        img_back = (ImageView) findViewById(R.id.img_back);

        //设置editText的过滤
        setEditTextFilter();

        addTotalNumForCheckBoxChange();
        addTotalNumForEditTextChange();
        img_back.setOnClickListener(this);
        tv_commit.setOnClickListener(this);


    }

    /**
     * 当用户输入改变时重新计算总价格
     */
    private void addTotalNumForEditTextChange() {

        et_service_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isService) {
                    //重新计算
                    getTotalPrice();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        et_material_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isMaterial) {
                    //重新计算
                    getTotalPrice();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        et_other_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isOther) {
                    //重新计算
                    getTotalPrice();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    /**
     * 当checkbox改变时重新计算价格
     */
    private void addTotalNumForCheckBoxChange() {
        cb_service_price.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //选中时，重新计算合计
                    isService = true;
                    getTotalPrice();

                } else {
                    //未选中时，重新计算合计
                    isService = false;
                    getTotalPrice();
                }
            }
        });
        cb_material.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //选中时，重新计算合计
                    isMaterial = true;
                    getTotalPrice();

                } else {
                    //未选中时，重新计算合计
                    isMaterial = false;
                    getTotalPrice();
                }
            }
        });
        cb_other.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //选中时，重新计算合计
                    isOther = true;
                    getTotalPrice();

                } else {
                    //未选中时，重新计算合计
                    isOther = false;
                    getTotalPrice();
                }
            }
        });

    }

    /**
     * 计算总价格,并显示
     */
    private void getTotalPrice() {
        totalPrice = 0;
        if (isService) {
            if (!TextUtils.isEmpty(et_service_price.getText().toString())) {
                servicePrice = Double.parseDouble(et_service_price.getText().toString());
                totalPrice += servicePrice;
            }
        }
        if (isMaterial) {
            if (!TextUtils.isEmpty(et_material_price.getText().toString())) {
                materialPrice = Double.parseDouble(et_material_price.getText().toString());
                totalPrice += materialPrice;
            }
        }
        if (isOther) {
            if (!TextUtils.isEmpty(et_other_price.getText().toString())) {
                otherPrice = Double.parseDouble(et_other_price.getText().toString());
                totalPrice += otherPrice;
            }
        }
        tv_totle_price.setText(totalPrice + "元");

    }

    /**
     * 设置editText的过滤
     */
    private void setEditTextFilter() {
        InputFilter[] filters = {new EditInputFilter(this)};
        et_service_price.setFilters(filters);
        et_material_price.setFilters(filters);
        et_other_price.setFilters(filters);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_commit:
                Toast.makeText(ProductOrderActivity.this, "金额合计" + totalPrice + "元，提交成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}