package com.hewei.wss_op;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/11 16:18
 * @Description:
 */
public interface Repo {
    OrderInfo getOder(String id);
    OrderInfo createOrder();
    OrderInfo updateOrder(OrderInfo info);
}
