package sh.azrato.ascriibe.core

import com.soywiz.kds.SortedMap

internal fun <K> CharArray.associateByIndexed(keySelector: (Int, Char) -> K): Map<K, Char> {
    val map = LinkedHashMap<K, Char>(size.coerceAtLeast(16))
    for ((idx, c) in withIndex()) {
        map[keySelector(idx, c)] = c
    }
    return map
}

internal fun <K : Comparable<K>, V> Map<K, V>.toSortedMap(): SortedMap<K, V> {
    val sortedMap: SortedMap<K, V> = SortedMap()
    for ((k, v) in this) {
        sortedMap[k] = v
    }
    return sortedMap
}

