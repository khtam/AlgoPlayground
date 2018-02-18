package minMaxSum


fun minMaxSumOf(input: List<Long>): LongArray {
    val sortedList = input.sorted();
    val max = sortedList.subList(1,sortedList.size).reduce { acc, element -> acc + element };
    val min = sortedList.subList(0,sortedList.size-1).reduce { acc, element -> acc + element };
    return longArrayOf(min, max);
}