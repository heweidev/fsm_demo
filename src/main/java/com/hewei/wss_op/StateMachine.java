package com.hewei.wss_op;

/**
 * @Auther: fengyinpeng
 * @Date: 2019/2/3 14:18
 * @Description:
 */
public class StateMachine {
    private Repo repo;


    public StateMachine(Repo repo) {
        this.repo = repo;
    }

    /**
     * 不能多线程并发
     * @param id
     */
    synchronized public void step(String id) {
        StateNodeBase curNode = Util.getNode(repo, id);
        do {
            StateNodeBase node = (StateNodeBase) curNode.transfer();
            if (node == curNode || node == null) {
                break;
            }

            System.out.println("node: " + id + " transfer to state: " + node.getState());
            if (!node.testState()) {
                System.out.println("state mismatch " + id);
            }

            curNode = node;
        } while (true);
    }
}
