#### 说明文档
- Lifecycle
- [官方网站](https://developer.android.com/jetpack/androidx/releases/lifecycle?hl=zh-cn)
- [官方文档](https://developer.android.com/topic/libraries/architecture/lifecycle?hl=zh-cn)
- 导包
```groovy
// 只有 Lifecycles（不带 ViewModel 或 LiveData）
implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.4.1'
// 注释处理器
kapt 'androidx.lifecycle:lifecycle-compiler:2.4.1'
// 替换 - 如果使用 Java8，请使用此注释处理器，而不是 lifecycle-compiler 注释处理器
implementation 'androidx.lifecycle:lifecycle-common-java8:2.4.1'
// 可选 - 在 Service 中实现 LifecycleOwner 的助手
implementation 'androidx.lifecycle:lifecycle-service:2.4.1'
// 可选 - ProcessLifecycleOwner 给整个 App 前后台切换提供生命周期监听
implementation 'androidx.lifecycle:lifecycle-process:2.4.1'

// LiveData
implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.1'
// 可选：对 LiveData 的 ReactiveStreams 支持
implementation 'androidx.lifecycle:lifecycle-reactivestreams-ktx:2.4.1'
// 可选 - LiveData 的测试助手
testImplementation 'androidx.arch.core:core-testing:2.1.0'

// ViewModel
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1'
// 用于 Compose 的 ViewModel 实用程序
implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1'
// ViewModel 的已保存状态模块
implementation 'androidx.lifecycle:lifecycle-viewmodel-savedstate:2.4.1'
```
- 源码版本最后更新时间：2022年4月1日
