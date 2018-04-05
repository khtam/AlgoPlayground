package coinOnTable

class BoardIterator(val board: Array<CharArray>) {

    val numberOfRows = board.size;
    val numberOfColumns = board[0].size;

    fun nextStep(position: Pair<Int, Int>, steps: Int): Int {
        val x = position.first;
        val y = position.second;
        if (x >= numberOfRows || y >= numberOfColumns)
            return -1;
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