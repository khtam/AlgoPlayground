package coinOnTable

fun isGoalAchieved(board: Array<CharArray>, startingPosition: Pair<Int, Int>, expectedNumberOfSteps: Int, destination: Pair<Int, Int>): Boolean {
    val countingIterator = BoardIterator(board, destination);
    val remainingSteps = countingIterator.nextStep(startingPosition, expectedNumberOfSteps);
    if (remainingSteps > -1)
        return true;
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