package com.hewei.wss_op;

import com.hewei.wss_op.exception.EditException;
import com.hewei.wss_op.model.OrderState;
import com.hewei.wss_op.test.TestUtils;

import java.util.Scanner;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 11:27
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        Repo repo = new MemRepo();
        StateMachine fsm = new StateMachine(repo);

        Scanner scanner = new Scanner(System.in);
        String data;
        while ((data = scanner.nextLine()) != null) {
            if (data.contains("create")) {
                OrderInfo info = TestUtils.createOrder(repo);
                System.out.println("create ok, id = " + info.getId());
                fsm.step(info.getId());
            } else {
                String id = data.substring(4);
                OrderInfo info = repo.getOder(id);
                OrderState state = info.getState();

                if (info != null) {
                    try {
                        if (data.startsWith("auth")) {
                            info.setAuthOK(true);
                        } else if (data.contains("mok@")) {
                            info.setMoneyOK(true);
                        } else if (data.contains("cok@")) {
                            info.setMaterialOK(true);
                        } else if (data.contains("vok@")) {
                            info.setVisitOK(true);
                        } else if (data.contains("edt@")) {
                            info.setEditOK(true);
                        } else {

                        }
                        fsm.step(info.getId());
                    } catch (EditException e) {
                        System.out.println("edit error: " + e.getMessage());
                    }
                } else {
                    System.out.println("invalid id: " + id);
                }
            }
        }
    }
}
