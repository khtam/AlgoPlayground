package coinOnTable

class BoardModifier(val destination: Pair<Int, Int>) {

    val instructionSet = setOf<Char>('U', 'D', 'L', 'R');

    fun modifyWithLeastNumberOfOperations(board: Array<CharArray>, position: Pair<Int, Int>, remainingSteps: Int, numberOfOperations: Int): Int {
        val listOfOperations = mutableListOf<Int>();
        val numberOfRows = board.size;
        val numberOfColumns = board[0].size;

        if (isOutOfBounds(board, position))
            return -1;

        instructionSet
                .filter { instruction -> !instruction.equals(board[position.first][position.second]) }
                .filter { instruction -> !instructionPointingOutOfBounds(position, instruction, numberOfRows, numberOfColumns) }
                .map { instruction ->
                    val newBoard = board.copyOf();
                    newBoard[position.first][position.second] = instruction;
                    if (isGoalAchieved(newBoard, remainingSteps, destination))
                        return numberOfOperations + 1;

                    val movedDown = Pair(position.first + 1, position.second);
                    val operationsForMovingDownwards = modifyWithLeastNumberOfOperations(newBoard, movedDown, remainingSteps, numberOfOperations + 1);
                    listOfOperations.add(operationsForMovingDownwards);

                    val movedRight = Pair(position.first, position.second + 1);
                    val operationsForMovingRight = modifyWithLeastNumberOfOperations(newBoard, movedRight, remainingSteps, numberOfOperations + 1);
                    listOfOperations.add(operationsForMovingRight);
                }
        val leastAmountOfOperations = listOfOperations
                .filter { number -> number > -1 }
                .sorted()
                .firstOrNull();

        return leastAmountOfOperations ?: -1;
    }

    private fun instructionPointingOutOfBounds(position: Pair<Int, Int>, instruction: Char, numberOfRows: Int, numberOfColumns: Int): Boolean {
        if (position.first == 0 && instruction == 'U')
            return true;

        if (position.first == numberOfRows && instruction == 'D')
            return true;

        if (position.second == 0 && instruction == 'L')
            return true;

        if (position.second == numberOfColumns && instruction == 'R')
            return true;

        return false;
    }

}