package cases.default_parameter_presence
// Omitting y still calls the default stub after the default value of x is removed.
fun bar(): Int = foo("x")
