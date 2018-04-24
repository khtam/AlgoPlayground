package coinOnTable

class BoardModifier(val destination: Pair<Int, Int>) {

    val instructionSet = setOf<Char>('U', 'D', 'L', 'R');

    fun modifyWithLeastNumberOfOperations(board: Array<CharArray>, remainingSteps: Int, numberOfOperations: Int, iteratedPositionList: List<Pair<Int, Int>>): Int {
        val listOfOperations = mutableListOf<Int>();
        val numberOfRows = board.size;
        val numberOfColumns = board[0].size;

        println("layer:$numberOfOperations")

//        if (numberOfOperations == numberOfRows * numberOfColumns)
//            return -1;

        board.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, originalInstruction ->
                val currentPosition = Pair(rowIndex, columnIndex);
                if (isUniqueIteration(rowIndex, columnIndex, iteratedPositionList) && !isDestination(currentPosition))
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
                if (isUniqueIteration(rowIndex, columnIndex, iteratedPositionList) && !isDestination(currentPosition)) {
                    val newPositionList = iteratedPositionList + currentPosition;
                    instructionSet
                            .filter { instruction -> instruction != originalInstruction }
                            .filter { instruction -> !instructionPointingOutOfBounds(currentPosition, instruction, numberOfRows, numberOfColumns) }
                            .map { instruction ->
                                val newBoard = cloneBoard(board);
                                newBoard[currentPosition.first][currentPosition.second] = instruction;
                                listOfOperations.add(modifyWithLeastNumberOfOperations(
                                        newBoard, remainingSteps, numberOfOperations + 1, newPositionList));
                            }
                }
            }
        }

        val leastAmountOfOperations = listOfOperations
                .filter { number -> number > -1 }
                .sorted()
                .firstOrNull();

        return leastAmountOfOperations ?: -1;
    }

    private fun isDestination(currentPosition: Pair<Int, Int>) = currentPosition.first == destination.first && currentPosition.second == destination.second;

    private fun cloneBoard(board: Array<CharArray>): Array<CharArray> {
        return Array<CharArray>(board.size) { board[it].copyOf() };
    }

    private fun isUniqueIteration(rowIndex: Int, columnIndex: Int, positionList: List<Pair<Int, Int>>): Boolean {
        var isUnique = true;
        positionList.forEach { position ->
            isUnique = isUnique && !(rowIndex == position.first && columnIndex == position.second)
        }
        return isUnique;
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