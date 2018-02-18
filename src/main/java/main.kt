import birthdayCakeCandle.countCandles
import minMaxSum.minMaxSumOf
import stairCase.printStairCase
import timeConversion.convertTime

fun main(args: Array<String>) {
    convertTimeFrom()
}

fun convertTimeFrom() {
    val time = readLine()!!;
    println(convertTime(time));
}

fun countBlownCandles() {
    val numberOfCandles = readLine()!!.toInt();
    val candleHeights = readLine()!!.split(" ").map { it.toLong() };
    println(countCandles(candleHeights));
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