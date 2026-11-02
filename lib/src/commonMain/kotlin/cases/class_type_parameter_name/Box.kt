package cases.class_type_parameter_name
class Box<out R> {
    fun value(): R = error("Not called")
}
