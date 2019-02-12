package com.hewei.wss_op;

import com.hewei.wss_op.exception.EditException;
import com.hewei.wss_op.model.Customer;
import com.hewei.wss_op.model.OrderState;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 15:07
 * @Description:
 */
public class OrderInfo {
    private String id;
    private Customer customer;
    private int fmt;  // 购买金额
    private OrderState state = OrderState.S_NONE;

    private boolean authOK;
    private boolean materialOK;
    private boolean moneyOK;
    private boolean visitOK;
    private boolean editOK = true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getFmt() {
        return fmt;
    }

    public void setFmt(int fmt) {
        this.fmt = fmt;
    }

    public boolean needAuth() {
        return !authOK;
    }

    public boolean isAuthOK() {
        return authOK;
    }

    public void setAuthOK(boolean authOK) {
        this.authOK = authOK;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public boolean isEditOK() {
        return editOK;
    }

    public boolean isMaterialOK() {
        return materialOK;
    }

    public boolean isMoneyOK() {
        return moneyOK;
    }

    public boolean isVisitOK() {
        return visitOK;
    }

    public void setEditOK(boolean editOK) throws EditException {
        if (state != OrderState.S_EDIT) {
            throw new EditException("不可编辑， state = " + state);
        }

        this.editOK = editOK;
    }

    public void setMaterialOK(boolean materialOK) throws EditException {
        if (state != OrderState.S_CHECK) {
            throw new EditException("不可编辑， state = " + state);
        }

        this.materialOK = materialOK;
    }

    public void setMoneyOK(boolean moneyOK) throws EditException  {
        this.moneyOK = moneyOK;
    }

    public void setVisitOK(boolean visitOK) throws EditException {
        if (state != OrderState.S_CHECK) {
            throw new EditException("不可编辑， state = " + state);
        }

        this.visitOK = visitOK;
    }
}
