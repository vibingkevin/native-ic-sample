package cases.val_getter

import kotlin.test.*

@Test fun test() {
    val holder = Holder()
    assertEquals(2, checkedLength(holder))
    assertEquals(4, holder.calls)
}
