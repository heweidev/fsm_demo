package com.hewei.wss_op;

import com.hewei.wss_op.model.OrderState;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 15:12
 * @Description:
 */
public class EditNode extends StateNodeBase {
    public EditNode(OrderInfo info) {
        super(info);
    }

    @Override
    public OrderState getState() {
        return OrderState.S_EDIT;
    }

    private boolean needAuth() {
        return info != null && info.needAuth();
    }

    @Override
    public StateNode transfer() {
        if (!info.isEditOK()) {
            return this;
        }

        if (needAuth()) {
            return new AuthNode(info);
        } else {
            return new CheckNode(info);
        }
    }
}
