package coinOnTable

fun minOperations(row: Int, column: Int, rounds: Int, input: String): Int {
    val initialState = parseInput(input, row, column);
    return 0;
}

fun parseInput(input: String, row: Int, column: Int): Array<CharArray> {
    var parsedArray = arrayOf(charArrayOf());
    val rows = input.chunked(column);

    for (i in 0 until row){
        for (j in 0 until column){
            parsedArray[i][j] = rows.get(i).get(j);
        }
    }

    return parsedArray;
}
