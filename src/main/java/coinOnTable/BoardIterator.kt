package coinOnTable

import kotlin.math.abs

class BoardIterator(val board: Array<CharArray>, val destination: Pair<Int, Int>) {

    private val numberOfRows = board.size;
    private val numberOfColumns = board[0].size;
    val distancesFromDestination = mutableListOf<Int>();

    fun nextStep(position: Pair<Int, Int>, remainingSteps: Int): Int {
        val x = position.first;
        val y = position.second;

        if (x >= numberOfRows || y >= numberOfColumns || remainingSteps < 0)
            return -1;

        calculateRemainingSteps(x, y, remainingSteps);

        val instruction = board[x][y];
        when (instruction) {
            'U' -> return nextStep(Pair(x - 1, y), remainingSteps - 1);
            'D' -> return nextStep(Pair(x + 1, y), remainingSteps - 1);
            'L' -> return nextStep(Pair(x, y - 1), remainingSteps - 1);
            'R' -> return nextStep(Pair(x, y + 1), remainingSteps - 1);
            '*' -> return remainingSteps;
        }
        return -1;
    }

    private fun calculateRemainingSteps(x: Int, y: Int, steps: Int) {
        val distanceFromDestination = abs(destination.first - x) + abs(destination.second - y);
        distancesFromDestination.add(distanceFromDestination);
    }
}