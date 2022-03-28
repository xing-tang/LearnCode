package com.open.learncode.开源框架.dagger2.module_provide;

import dagger.Component;

@Component(modules = {MarkCarModule.class})
public interface CarComponent {
    void inject(Car car);

}
