package com.open.learncode.开源框架.dagger2.inject;

import javax.inject.Inject;

public class Engine {

    @Inject
    Engine(){}

    public void run(){
        System.out.println("汽车引擎转起来了~~~");
    }
}
