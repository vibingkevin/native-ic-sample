# native-ic-sample

Kotlin/Native Debug IC 增量传播用例。`lib` 放声明，`app` 放产品调用方；
`commonTest` 放功能断言，产品代码不依赖测试。第一笔起均支持 Linux x64、iOS arm64 和 iOS 模拟器 arm64。

## 构建产品（fuzzer 使用）

```sh
./gradlew :app:linkDebugExecutableLinuxX64
./gradlew :app:linkDebugFrameworkIosSimulatorArm64
./gradlew :app:linkDebugFrameworkIosArm64
```

Linux 产物为 `app/build/bin/linuxX64/debugExecutable/app.kexe`；iOS 产物为对应目标
`debugFramework/NativeIcSample.framework`。iOS 需在安装 Xcode 的 Mac 上构建。
产品入口 `demo.snapshot()` 调用全部场景，Linux 主函数输出结果；iOS 可通过 framework 调用。

## 单独验证功能

```sh
./gradlew :app:linuxX64Test
./gradlew :app:iosSimulatorArm64Test
```

这些命令用于验证 demo，不是 fuzzer 的构建任务。
可加 `-Pkotlin.native.home=/path/to/dist` 指定 Native 编译器。

## 提交场景

首笔包含全部场景的初始状态和功能断言。后续每项独立修改、再恢复，调用方保持原样：

- inline 外部符号身份：first → second。
- inline 默认参数体：77 → 88。
- val getter：稳定读取 → 第二次读取返回其他类型。
- 声明注解：abs → toupper。
- 类类型参数 variance：T → out T。
- 类类型参数名称：T → R。
- 函数类型参数名称：T → R。
- 默认参数存在性：删除 x 的默认值，仍省略 y 调用。
- getter 局部实现：计数 +1 → +2 → +1；返回值不变。

每笔保留并更新对应功能断言。直接按提交顺序回放，无需应用 patch。
不设置任何内联选项，使用编译器默认行为。这些场景检查增量传播是否正确，
不表示社区编译器一定存在对应错误。
