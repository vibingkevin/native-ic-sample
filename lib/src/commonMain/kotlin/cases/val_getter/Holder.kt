package cases.val_getter
class Holder {
    var calls: Int = 0
    val value: Any = "OK"
        get() { calls++; return field }
}
