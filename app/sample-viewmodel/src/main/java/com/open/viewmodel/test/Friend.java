package com.open.viewmodel.test;

/**
 * Friend
 *
 * @Description: xxx
 * @Author: xing.tang
 */
public class Friend implements IShow {

    private IShow mShow;

    public Friend(IShow iShow) {
        mShow = iShow;
    }

    @Override
    public void buy() {
        mShow.buy();
    }
}
