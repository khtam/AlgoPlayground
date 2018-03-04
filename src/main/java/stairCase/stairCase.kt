package stairCase

fun printStairCase(size: Int) {
    (1..size).forEach({
        (1..size - it).forEach { print(' ') }
        (1..it).forEach { print('#') }
        println()
    })
}