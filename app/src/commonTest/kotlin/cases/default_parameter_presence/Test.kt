package cases.default_parameter_presence

import kotlin.test.*

@Test
fun runTest() {
    assertEquals(2, bar())
    assertEquals(4, foo("abc"))
}
