package com.hewei.wss_op;

import com.hewei.wss_op.model.OrderState;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 14:18
 * @Description:
 */
public abstract class StateNodeBase implements StateNode {
    protected OrderInfo info;

    public StateNodeBase(OrderInfo info) {
        this.info = info;

        OrderState state = getState();
        if (info.getState() != state) {
            info.setState(state);
        }
    }

    public abstract OrderState getState();

    public OrderInfo getInfo() {
        return info;
    }

    public boolean testState() {
        return info.getState() == getState();
    }
}
