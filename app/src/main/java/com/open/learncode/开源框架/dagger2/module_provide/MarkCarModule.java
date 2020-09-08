package com.open.learncode.开源框架.dagger2.module_provide;

import dagger.Module;
import dagger.Provides;

@Module
public class MarkCarModule {

    public MarkCarModule() { }

    @Provides
    Engine provideEngine() {
        return new Engine("齿轮");
    }
}
