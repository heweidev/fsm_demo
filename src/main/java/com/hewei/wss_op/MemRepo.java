package com.hewei.wss_op;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/11 16:19
 * @Description:
 */
public class MemRepo implements Repo {
    private Map<String, OrderInfo> cache = new HashMap<>();

    private static long sId = 1000;

    @Override
    public OrderInfo getOder(String id) {
        return cache.get(id);
    }

    @Override
    public OrderInfo createOrder() {
        OrderInfo info = new OrderInfo();
        info.setId("" + sId++);
        cache.put(info.getId(), info);
        return info;
    }

    @Override
    public OrderInfo updateOrder(OrderInfo info) {
        OrderInfo old = getOder(info.getId());
        if (old != null) {
            cache.put(info.getId(), info);
        }

        return old;
    }
}
