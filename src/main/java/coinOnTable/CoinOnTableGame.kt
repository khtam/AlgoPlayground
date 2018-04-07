package coinOnTable

class CoinOnTableGame(input: String, row: Int, column: Int) {

    private val destination: Pair<Int, Int>;
    private val initialBoard: Array<CharArray>;

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
        initialBoard = parsedArray;
        destination = endCoordinates;
    }

    fun evaluate(expectedNumberOfSteps: Int): Int {
        val minNumberStepsNeeded = destination.first + destination.second;

        if (expectedNumberOfSteps < minNumberStepsNeeded)
            return -1;

        val countingIterator = BoardIterator(initialBoard, destination);
        val remainingSteps = countingIterator.nextStep(Pair(0, 0), expectedNumberOfSteps);

        if (remainingSteps > -1)
            return 0;

        //modify board here
        return 0;
    }

}