package cases.class_variance

import kotlin.reflect.KVariance
import kotlin.test.*

@Test
fun test() {
    assertEquals(KVariance.OUT, declaredVariance())
    assertEquals("T", declaredTypeParameterName())
}
