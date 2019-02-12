package com.hewei.wss_op;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 14:16
 * @Description:
 */
public interface StateNode {
    /**
     * @return 下个Node，如果不能转移返回null或者this
     */
    StateNode transfer();
}
