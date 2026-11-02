package cases.class_type_parameter_name

import kotlin.reflect.KVariance
import kotlin.test.*

@Test
fun test() {
    assertEquals(KVariance.OUT, declaredVariance())
    assertEquals("R", declaredTypeParameterName())
}
