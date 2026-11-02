package cases.val_getter

import kotlin.test.*

@Test
fun test() {
    assertFailsWith<ClassCastException> { checkedLength(Holder()) }
}
