#### 说明文档
- Retrofit
- [GihHub 地址](https://github.com/square/retrofit/tree/master)
- 导包
```groovy
// 模块的 build.gradle
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
// 基本属性数据转换器
implementation 'com.squareup.retrofit2:converter-scalars:2.9.0'
//  Gson 数据转换器
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
// Rxjava 适配器（可选）
implementation 'com.squareup.retrofit2:adapter-rxjava2:2.7.2'
// OkHttp
implementation 'com.squareup.okhttp3:okhttp:4.9.1'
implementation 'com.squareup.okhttp3:logging-interceptor:4.9.1'
// RxJava RxAndroid RxKotlin（可选）
implementation 'io.reactivex.rxjava2:rxjava:2.1.6'
implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
implementation 'io.reactivex.rxjava2:rxkotlin:2.2.0'
// Kotlin 协程（可选）
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7'
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7'
```
- 源码版本最后更新时间：2021年05月25日