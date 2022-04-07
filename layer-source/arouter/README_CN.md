#### 版本说明
- ARouter
- [GitHub地址](https://github.com/alibaba/ARouter)
- 导包
```groovy
// 根目录的 build.gradle
buildscript {
    dependencies {
        classpath 
        // ARouter
        classpath "com.alibaba:arouter-register:1.0.2"
    }
}

// 模块的 build.gradle
plugins {
    id 'kotlin-kapt'
}
kapt {
    arguments {
        // 根据模块名来命名路由根节点
        arg("AROUTER_MODULE_NAME", project.getName())
        // 生成 Json 文件
        arg("AROUTER_GENERATE_DOC", "enable")
    }
}
dependencies {
    // ARouter
    implementation 'com.alibaba:arouter-api:1.5.2'
    // 注意这里的 arouter-compiler 不能使用 1.5.2 版本，不然会编译不过
    kapt 'com.alibaba:arouter-compiler:1.2.2'
}
```
- 源码版本最后更新时间：2022年03月28日