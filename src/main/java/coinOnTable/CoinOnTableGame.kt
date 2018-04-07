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

    fun findMinOperation(expectedNumberOfSteps: Int): Int {
        val minNumberStepsNeeded = destination.first + destination.second;

        if (expectedNumberOfSteps < minNumberStepsNeeded)
            return -1;

        if (reachesDestinationWithinExpectation(initialBoard, Pair(0, 0), expectedNumberOfSteps)) return 0

        //modify board here
        return 0;
    }

    private fun reachesDestinationWithinExpectation(board: Array<CharArray>, startingPosition: Pair<Int, Int>, expectedNumberOfSteps: Int): Boolean {
        val countingIterator = BoardIterator(board, destination);
        val remainingSteps = countingIterator.nextStep(startingPosition, expectedNumberOfSteps);
        if (isGoalAchieved(remainingSteps))
            return true;
        return false
    }

    private fun isGoalAchieved(remainingSteps: Int) = remainingSteps > -1

}