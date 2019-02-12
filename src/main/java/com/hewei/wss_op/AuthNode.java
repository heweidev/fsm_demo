package com.hewei.wss_op;

import com.hewei.wss_op.cmd.BaseCommand;
import com.hewei.wss_op.model.OrderState;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 15:15
 * @Description:
 */
public class AuthNode extends StateNodeBase {
    public AuthNode(OrderInfo info) {
        super(info);
    }

    @Override
    public OrderState getState() {
        return OrderState.S_AUTH;
    }

    @Override
    public StateNode transfer() {
        if (info.needAuth()) {
            BaseCommand.deliver("触发审批流： " + info.getId());
            return this;
        } else {
            return new CheckNode(info);
        }
    }
}
