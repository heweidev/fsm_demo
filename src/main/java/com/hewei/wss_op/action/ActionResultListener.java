package com.hewei.wss_op.action;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 15:35
 * @Description:
 */
public interface ActionResultListener {
    void onFinished(Action action);
    void onError(Action action, Exception e);
}
