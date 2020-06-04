package com.open.learncode.设计模式.责任链模式;

/**
 * 领导人抽象类
 */
public abstract class AbstractLeader implements IPower {

    // 当前领导能批复的金额
    private int money;
    // 上级领导
    private AbstractLeader mSuperLeader;

    /**
     * 含参构造方法
     *
     * @param money 当前领导能批复的金额
     */
    public AbstractLeader(int money) {
        this.money = money;
    }

    /**
     * 领导批复某员工报销申请
     *
     * @param person 待批复的员工
     */
    protected abstract void reply(AbstractPerson person);

    /**
     * 为当前领导设置一个上级领导
     *
     * @param superLeader 上级领导
     */
    public void setLeader(AbstractLeader superLeader) {
        this.mSuperLeader = superLeader;
    }

    /**
     * 处理报销请求
     *
     * @param person 具体的员工
     */
    @Override
    public void handleRequest(AbstractPerson person) {
        /*
         * 如果说员工申请的money在当前领导的批复范围内
         */
        if (person.getMoney() <= money) {
            // 那么就由当前领导批复即可
            reply(person);
        } else {
            // 否则看看当前领导有木有上级
            if (mSuperLeader != null) {
                // 有的话简单撒直接扔给上级处理即可
                mSuperLeader.handleRequest(person);
            } else {
                // 没有上级的话就批复不了……不过在这个场景中总会有领导批复的淡定
                System.out.println("金额数目(" + person.getMoney() + ")较大,无法批复该报销申请");
            }
        }
    }
}
