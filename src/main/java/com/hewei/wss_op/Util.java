package com.hewei.wss_op;

import com.hewei.wss_op.model.OrderState;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/11 16:46
 * @Description:
 */
public class Util {
    public static StateNodeBase getNode(Repo repo, String id) {
        OrderInfo info = repo.getOder(id);
        OrderState state = info.getState();
        switch (state) {
            case S_EDIT:
                return new EditNode(info);
            case S_AUTH:
                return new AuthNode(info);
            case S_CHECK:
                return new CheckNode(info);
            case S_OK:
                return new OKNode(info);
            case S_CANCEL:
        }

        return null;
    }
}
