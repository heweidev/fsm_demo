package com.hewei.wss_op.cmd;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/11 16:11
 * @Description:
 */
public class BaseCommand implements Runnable {
    private String name;

    public BaseCommand(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("run cmd: " + name);
    }

    public static void deliver(String name) {
        new BaseCommand(name).run();       // ToDo 对象池
    }
}
