package sh.azrato.ascriibe.core

import kotlin.math.ulp

public operator fun Double.rangeTo(other: Double): DoubleRange {
    return DoubleRange(this, other)
}

public infix fun Double.until(other: Double): DoubleRange {
    return DoubleRange(this, other - other.ulp)
}