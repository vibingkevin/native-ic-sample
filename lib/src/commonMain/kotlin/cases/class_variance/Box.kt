package cases.class_variance
class Box<out T> {
    fun value(): T = error("Not called")
}
