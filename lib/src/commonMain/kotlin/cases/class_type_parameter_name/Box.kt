package cases.class_type_parameter_name
class Box<out T> {
    fun value(): T = error("Not called")
}
