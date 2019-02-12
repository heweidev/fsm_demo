package com.hewei.wss_op;

import com.hewei.wss_op.model.OrderState;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 15:16
 * @Description:
 */
public class CheckNode extends StateNodeBase {
    public CheckNode(OrderInfo info) {
        super(info);
    }

    @Override
    public OrderState getState() {
        return OrderState.S_CHECK;
    }

    @Override
    public StateNode transfer() {
        // 材料不完整，退回
        if (!info.isMaterialOK()) {
            System.out.println("材料不完整");
            info.setEditOK(false);
            return new EditNode(info);
        }

        if (info.isMoneyOK() && info.isVisitOK()) {
            return new OKNode(info);
        } else {
            return this; // 等待资金到账、回访
        }
    }
}
