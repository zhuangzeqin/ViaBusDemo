package com.eeepay.zzq.viabusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.eeepay.zzq.viabusdemo.business.BusManager;
import com.eeepay.zzq.viabusdemo.business.login.LoginBusiness;
import com.eeepay.zzq.viabusdemo.business.login.LoginResultCode;
import com.kunminx.core.bus.IResponse;
import com.kunminx.core.bus.Result;

/**
 * 描述：ViaBus 是一款响应式架构，借助总线转发数据的请求和响应，实现 UI、业务的完全解耦。
 * 作者：zhuangzeqin
 * 时间: 2019/11/8-17:03
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class MainActivity extends AppCompatActivity implements IResponse {
    LoginBusiness loginBusiness;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)this.findViewById(R.id.tv_msg);
        loginBusiness = new LoginBusiness();
        BusManager.registerRequestHandler(loginBusiness);
        BusManager.registerResponseObserver(this);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusManager.loginApi().login("zhuangzeqin", "abc123");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusManager.unregisterRequestHandler(loginBusiness);
        BusManager.unregisterResponseObserver(this);

    }

    @Override
    public void onResult(Result testResult) {
        String resultCode = (String) testResult.getResultCode();
        switch (resultCode) {
            case LoginResultCode.QUERY_LOGIN:
                Toast.makeText(this, testResult.getResultObject().toString(), Toast.LENGTH_SHORT).show();
                textView.setText(testResult.getResultObject().toString());
                break;
        }
    }
}
