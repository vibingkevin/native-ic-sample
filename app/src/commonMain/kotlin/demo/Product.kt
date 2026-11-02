package demo

// 产品入口实际调用每个场景，Linux 可执行文件和 iOS framework 共用。
fun snapshot(): String = listOf(
    cases.inline_external.result(),
    cases.inline_default.computedDefaultValue(),
    try { cases.val_getter.checkedLength(cases.val_getter.Holder()).toString() }
    catch (_: ClassCastException) { "ClassCastException" },
    cases.annotation.selected(),
    cases.class_variance.declaredVariance(),
    cases.class_type_parameter_name.declaredTypeParameterName(),
    cases.function_type_parameter_name.declaredTypeParameterName(),
    cases.default_parameter_presence.bar(),
).joinToString("|")
