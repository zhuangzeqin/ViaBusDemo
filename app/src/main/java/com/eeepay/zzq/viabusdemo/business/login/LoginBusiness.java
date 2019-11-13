package com.eeepay.zzq.viabusdemo.business.login;

import android.support.annotation.NonNull;

import com.eeepay.zzq.viabusdemo.business.BusManager;
import com.kunminx.core.bus.Result;
import com.kunminx.core.business.BaseBusiness;

import java.io.IOException;

/**
 * 描述：登录的业务逻辑层
 * 作者：zhuangzeqin
 * 时间: 2019/11/8-17:47
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public final class LoginBusiness extends BaseBusiness<BusManager> implements ILoginRequest {
    @Override
    public void login(@NonNull final String username, @NonNull String password) {
        handleRequest(new IAsync() {
            @Override
            public Result onExecute(io.reactivex.ObservableEmitter<Result> e) throws IOException {
                //异步从api 接口获取数据
                //这里就直接返回登录成功的提示语即可
                return new Result(LoginResultCode.QUERY_LOGIN, username+"登录成功");
            }
        });
    }

    @Override
    public void onDestroy() {

    }
}
