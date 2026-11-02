package demo

import kotlin.test.Test
import kotlin.test.assertEquals

@Test fun productIncludesEveryCase() {
    assertEquals(8, snapshot().split('|').size)
}
