package com.eeepay.zzq.viabusdemo.business;

import com.eeepay.zzq.viabusdemo.business.login.ILoginRequest;
import com.kunminx.core.bus.BaseBus;

/**
 * 描述：定义 bus，用于支持请求接口的访问
 * 作者：zhuangzeqin
 * 时间: 2019/11/8-17:42
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public final class BusManager extends BaseBus {
    /** ------注释说明----支持请求登录接口的访问---- **/
    public static ILoginRequest loginApi() {
        return (ILoginRequest) getRequest(ILoginRequest.class);
    }
}
