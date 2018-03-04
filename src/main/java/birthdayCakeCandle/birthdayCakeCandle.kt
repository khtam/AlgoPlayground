package birthdayCakeCandle

fun countCandles(candleHeights: List<Long>): Int {
    val sortedCandleHeights = candleHeights.sorted();
    return sortedCandleHeights.count({
        it == sortedCandleHeights.last()
    });
}