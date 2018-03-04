package plusMinus

fun calculate(size: Int, inputArray: IntArray): List<String> {
    var positiveCount = 0.0;
    var negativeCount = 0.0;

    inputArray.forEach({
        if (it > 0)
            positiveCount++;
        else if (it < 0)
            negativeCount++;
    })

    val positiveFraction: String = formatDouble(positiveCount, size);
    val negativeFraction: String = formatDouble(negativeCount, size);
    val zeroFraction: String = formatDouble(size - positiveCount - negativeCount, size);
    return listOf(positiveFraction, negativeFraction, zeroFraction);
}

private fun formatDouble(positiveCount: Double, size: Int) = "%.6f".format(positiveCount / size)