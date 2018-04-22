package coinOnTable

class CoinOnTableGame(input: String, row: Int, column: Int) {

    private val destination: Pair<Int, Int>;
    private val initialBoard: Array<CharArray>;
    private val boardModifier: BoardModifier;

    init {
        var parsedArray = Array(row, { CharArray(column, { '0' }) })
        var endCoordinates = Pair(0, 0);
        validateInput(input, row, column)
        val rows = input.chunked(column);

        for (i in 0 until row) {
            for (j in 0 until column) {
                val cell = rows.get(i).get(j)
                parsedArray[i][j] = cell;
                print(cell);
                if (cell == '*') {
                    endCoordinates = Pair(i, j);
                }
            }
            println()
        }
        println("*********************")
        initialBoard = parsedArray;
        destination = endCoordinates;
        boardModifier = BoardModifier(destination);
    }

    fun findMinOperation(expectedNumberOfSteps: Int): Int {
        val minNumberStepsNeeded = destination.first + destination.second;

        if (expectedNumberOfSteps < minNumberStepsNeeded)
            return -1;

        if (isGoalAchieved(initialBoard, expectedNumberOfSteps, destination)) return 0;

        return boardModifier.modifyWithLeastNumberOfOperations(initialBoard, expectedNumberOfSteps, 0, listOf());
    }

    private fun validateInput(input: String, row: Int, column: Int) {
        //To-do: Add Test
        if (input.length != row * column)
            throw IllegalArgumentException("Input does not match dimension!");
        if (input.count { char -> char.equals('*') } != 1)
            throw IllegalArgumentException("Invalid number of destination defined!");
    }

}