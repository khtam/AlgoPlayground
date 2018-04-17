package coinOnTable

class BoardModifier(val destination: Pair<Int, Int>) {

    val instructionSet = setOf<Char>('U', 'D', 'L', 'R');

    fun modifyWithLeastNumberOfOperations(board: Array<CharArray>, position: Pair<Int, Int>, remainingSteps: Int, numberOfOperations: Int): Int {
        val listOfOperations = mutableListOf<Int>();
        val numberOfRows = board.size;
        val numberOfColumns = board[0].size;

        if (isOutOfBounds(board, position))
            return -1;

        board.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, originalInstruction ->
                val currentPosition = Pair(rowIndex, columnIndex);
                if (isUniqueIteration(numberOfOperations, rowIndex, position, columnIndex))
                    instructionSet
                            .filter { instruction -> instruction != originalInstruction }
                            .filter { instruction -> !instructionPointingOutOfBounds(currentPosition, instruction, numberOfRows, numberOfColumns) }
                            .map { instruction ->
                                val newBoard = cloneBoard(board);
                                newBoard[currentPosition.first][currentPosition.second] = instruction;
                                if (isGoalAchieved(newBoard, remainingSteps, destination))
                                    return numberOfOperations + 1;
                            }
            }
        }

        board.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, originalInstruction ->
                val currentPosition = Pair(rowIndex, columnIndex);
                instructionSet
                        .filter { instruction -> instruction != originalInstruction }
                        .filter { instruction -> !instructionPointingOutOfBounds(currentPosition, instruction, numberOfRows, numberOfColumns) }
                        .map { instruction ->
                            val newBoard = cloneBoard(board);
                            newBoard[currentPosition.first][currentPosition.second] = instruction;
                            listOfOperations.add(modifyWithLeastNumberOfOperations(newBoard, currentPosition, remainingSteps, numberOfOperations + 1));
                        }
            }
        }

        val leastAmountOfOperations = listOfOperations
                .filter { number -> number > -1 }
                .sorted()
                .firstOrNull();

        return leastAmountOfOperations ?: -1;
    }

    private fun cloneBoard(board: Array<CharArray>): Array<CharArray> {
        return Array<CharArray>(board.size) { board[it].copyOf() };
    }

    private fun isUniqueIteration(numberOfOperations: Int, rowIndex: Int, position: Pair<Int, Int>, columnIndex: Int) =
            !(numberOfOperations > 0 && rowIndex == position.first && columnIndex == position.second)

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