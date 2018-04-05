package coinOnTable

import kotlin.math.abs

class BoardIterator(val board: Array<CharArray>, val destination: Pair<Int, Int>) {

    private val numberOfRows = board.size;
    private val numberOfColumns = board[0].size;
    val projectedMinSteps = mutableListOf<Int>();

    fun nextStep(position: Pair<Int, Int>, steps: Int): Int {
        val x = position.first;
        val y = position.second;

        if (x >= numberOfRows || y >= numberOfColumns)
            return -1;

        calculateRemainingSteps(x, y, steps);

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

    private fun calculateRemainingSteps(x: Int, y: Int, steps: Int) {
        val distanceFromDestination = abs(destination.first - x) + abs(destination.second - y);
        projectedMinSteps.add(steps + distanceFromDestination);
    }
}