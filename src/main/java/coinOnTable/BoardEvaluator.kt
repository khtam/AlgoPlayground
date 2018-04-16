package coinOnTable

fun isGoalAchieved(board: Array<CharArray>, expectedNumberOfSteps: Int, destination: Pair<Int, Int>): Boolean {
    val startingPosition = Pair(0, 0);
    val countingIterator = BoardIterator(board, destination);
    val remainingSteps = countingIterator.nextStep(startingPosition, expectedNumberOfSteps);
    if (remainingSteps > -1) {
        board.forEach { row ->
            row.forEach { print(it) }
            println()
        }
        return true;
    }
    return false
}

fun isOutOfBounds(board: Array<CharArray>, position: Pair<Int, Int>): Boolean {
    val numberOfRows = board.size;
    val numberOfColumns = board[0].size;
    val x = position.first;
    val y = position.second;
    if (x >= numberOfRows || y >= numberOfColumns || x < 0 || y < 0)
        return true;
    return false;
}