import diagonalDifference.calculate

fun main(args: Array<String>) {
    calculateDiagonalDifference();
}

private fun calculateDiagonalDifference() {
    val dimension: Int = readLine()!!.toInt();
    val matrix = Array(dimension) { IntArray(dimension) };
    for (index in 0 until dimension) {
        matrix[index] = readLine()!!.split(" ").map(String::toInt).toIntArray()
    }
    println("The result is :"+calculate(dimension, matrix));
}