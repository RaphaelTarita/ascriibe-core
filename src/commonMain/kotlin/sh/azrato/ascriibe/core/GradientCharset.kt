package sh.azrato.ascriibe.core

import com.soywiz.kds.SortedMap

public class GradientCharset(private val chars: SortedMap<Double, Char>) {
    public constructor(arr: CharArray) : this(arr.associateByIndexed { idx, _ -> (idx + 1).toDouble() / arr.size }.toSortedMap())

    public constructor(str: String) : this(str.toCharArray())

    public operator fun get(key: Double): Char {
        return chars.nearestHigh(key)?.let { chars[it] } ?: throw IllegalArgumentException("key '$key' out of range (must be in [0; 1])")
    }

    public operator fun set(key: Double, value: Char) {
        chars.nearestHigh(key)?.let { chars[it] = value } ?: throw IllegalArgumentException("key '$key' out of range (must be in [0; 1])")
    }

    public operator fun get(range: ClosedRange<Double>): CharArray {
        val list = chars.toList()
        return list.subList(
            (list.indexOfFirst { (k, _) -> k > range.start } - 1).coerceAtLeast(0),
            (list.indexOfLast { (k, _) -> k < range.endInclusive } + 2).coerceAtMost(list.size)
        )
            .map { it.second }
            .toCharArray()
    }
}