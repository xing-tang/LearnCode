package com.open.learncode.开源框架.dagger2.module_provide;

import javax.inject.Inject;

public class Engine {

    private String attribute;

    @Inject
    Engine(String attribute) {
        this.attribute = attribute;
    }

    public void run() {
        System.out.println("汽车" + attribute + "转起来了~~~");
    }
}
