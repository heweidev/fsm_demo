package com.hewei.wss_op;

import com.hewei.wss_op.model.OrderState;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/11 15:45
 * @Description:
 */
public class OKNode extends StateNodeBase {
    public OKNode(OrderInfo info) {
        super(info);
    }

    @Override
    public OrderState getState() {
        return OrderState.S_OK;
    }

    @Override
    public StateNode transfer() {
        return this;
    }
}
