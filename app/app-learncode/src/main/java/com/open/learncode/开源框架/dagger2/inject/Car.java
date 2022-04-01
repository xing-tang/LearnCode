package com.open.learncode.开源框架.dagger2.inject;


import javax.inject.Inject;

public class Car {

    @Inject
    Engine engine;

    public Car() {
        // DaggerCarComponent.create().inject(this);
    }

    public Engine getEngine() {
        return this.engine;
    }
}