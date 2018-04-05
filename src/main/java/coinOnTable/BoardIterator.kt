package coinOnTable

import kotlin.math.abs

class BoardIterator(val board: Array<CharArray>, val destination: Pair<Int, Int>) {

    val numberOfRows = board.size;
    val numberOfColumns = board[0].size;
    val distancesFromDestination = mutableListOf<Int>();

    fun nextStep(position: Pair<Int, Int>, steps: Int): Int {
        val x = position.first;
        val y = position.second;

        if (x >= numberOfRows || y >= numberOfColumns)
            return -1;

        val distanceFromDestination = abs(destination.first - x) + abs(destination.second - y);
        distancesFromDestination.add(distanceFromDestination);

        val instruction = board[x][y];
        when (instruction) {
            'U' -> return nextStep(Pair(x - 1, y), steps + 1);
            'D' -> return nextStep(Pair(x + 1, y), steps + 1);
            'L' -> return nextStep(Pair(x, y - 1), steps + 1);
            'R' -> return nextStep(Pair(x, y + 1), steps + 1);
            '*' -> return steps;
        }
        return -1;
    }
}