package com.eeepay.zzq.viabusdemo.business.login;

import android.support.annotation.NonNull;

import com.kunminx.core.bus.IRequest;

/**
 * 描述：登录相关的接口，用于发送请求
 * 作者：zhuangzeqin
 * 时间: 2019/11/8-17:39
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public interface ILoginRequest extends IRequest {
    /** ------登录-------- **/
    void login(@NonNull final String username, @NonNull final String password);
}
