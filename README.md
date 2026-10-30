# native-ic-sample

KLIB facts 反例。

两个模块：`lib` 放声明，`app` 放调用方和 `kotlin.test` 断言。
目标为 `iosSimulatorArm64`、`iosArm64`，使用社区 Kotlin 2.4.21。

这些是 **KLIB facts 传播门控的回归用例**：遗漏某项 fact 才会出错，
不是声称社区原版 2.4.21 已有这些问题。每个反例一笔提交。

## 运行

在安装 Xcode 的 Apple Silicon Mac 上，指定待验证的 Kotlin/Native dist：

```sh
./gradlew :app:iosSimulatorArm64Test -Pkotlin.native.home=/path/to/dist
# 应用某个 cases/<name>/change.patch，保留 build 目录与缓存
# 仍用同一条命令做增量构建
./gradlew :app:iosSimulatorArm64Test -Pkotlin.native.home=/path/to/dist
# clean 对照
./gradlew clean :app:iosSimulatorArm64Test -Pkotlin.native.home=/path/to/dist
```

真机目标的编译、链接：

```sh
./gradlew :app:linkDebugTestIosArm64 -Pkotlin.native.home=/path/to/dist
```

`change.patch` 修改提供方及测试期望，调用方代码保持原样。
用 `git apply cases/<name>/change.patch` 应用，`git apply -R` 还原；
切换到下一个反例前还原源码并 clean。`omit.patch` 应用到编译器仓库，
只撤掉该反例涉及的记录或门控逻辑，用于重现漏项；正常修复版应通过增量及 clean 两次断言。

编译参数关闭 KLIB 序列化前的模块内内联，与编译器原生 IC 回归保持一致，
使检查落在 Native 缓存传播阶段。

## 反例

| 目录 | 触发变化 | 遗漏时的实测结果 |
|---|---|---|
| [inline-external](cases/inline-external/change.patch) | inline 调用 first 改为 second | 预期 2，实际 1 |
| [inline-default](cases/inline-default/change.patch) | inline 默认值 77 改为 88 | 预期 130，实际 119 |
