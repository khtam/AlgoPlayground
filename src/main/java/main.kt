import minMaxSum.minMaxSumOf
import stairCase.printStairCase

fun main(args: Array<String>) {
    calculateMinMaxSum()
}

private fun calculateMinMaxSum() {
    val listOfLongInput = readLine()!!.split(" ").map { it.toLong() };
    val result = minMaxSumOf(listOfLongInput);
    println(result[0].toString()+" "+result[1].toString());
}

private fun takeInStairCaseSize() {
    val count: Int = readLine()!!.toInt()
    printStairCase(count);
}

private fun calculateFractions() {
    val count: Int = readLine()!!.toInt();
    val input: IntArray = readLine()!!.split(" ").map { it.toInt() }.toIntArray();
    val (positive, negative, zero) = plusMinus.calculate(count, input);
    println(positive);
    println(negative);
    println(zero);
}

private fun calculateDiagonalDifference() {
    val dimension: Int = readLine()!!.toInt();
    val matrix = Array(dimension) { IntArray(dimension) };
    for (index in 0 until dimension) {
        matrix[index] = readLine()!!.split(" ").map(String::toInt).toIntArray()
    }
    println("The result is :" + diagonalDifference.calculate(dimension, matrix));
}