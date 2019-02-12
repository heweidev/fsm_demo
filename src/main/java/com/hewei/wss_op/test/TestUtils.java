package com.hewei.wss_op.test;

import com.hewei.wss_op.OrderInfo;
import com.hewei.wss_op.Repo;
import com.hewei.wss_op.model.OrderState;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/11 16:27
 * @Description:
 */
public class TestUtils {
    public static OrderInfo createOrder(Repo repo) {
        OrderInfo info = repo.createOrder();
        info.setState(OrderState.S_EDIT);
        return info;
    }
}
