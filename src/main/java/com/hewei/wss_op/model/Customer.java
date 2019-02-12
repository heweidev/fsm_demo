package com.hewei.wss_op.model;

import com.hewei.wss_op.model.Address;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 15:08
 * @Description:
 */
public class Customer {
    private String id;
    private String name;
    private String mobile;
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
