package coinOnTable

class CoinOnTableGame(input: String, row: Int, column: Int) {

    private val destination: Pair<Int, Int>;
    private val initialState: Array<CharArray>;

    init {
        var parsedArray = Array(row, { CharArray(column, { '0' }) })
        var endCoordinates = Pair(0, 0);
        val rows = input.chunked(column);

        for (i in 0 until row) {
            for (j in 0 until column) {
                val cell = rows.get(i).get(j)
                parsedArray[i][j] = cell;
                if (cell == '*') {
                    endCoordinates = Pair(i, j);
                }
            }
        }
        initialState = parsedArray;
        destination = endCoordinates;
    }

    fun minOperations(rounds: Int): Int {
        val minStepsNeeded = destination.first + destination.second;
        if (rounds < minStepsNeeded)
            return  -1;
        return 0;
    }

}