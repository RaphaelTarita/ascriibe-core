import sh.azrato.ascriibe.core.GradientCharset
import sh.azrato.ascriibe.core.toSortedMap

fun main() {

    val charmap = mapOf(
        0.1 to '0',
        0.5 to '4',
        0.6 to '5',
        0.9 to '8',
        1.0 to '9'
    ).toSortedMap()
    val charset = GradientCharset(charmap)
    println(charset[0.2])
    println(charset[0.3..0.7])
}