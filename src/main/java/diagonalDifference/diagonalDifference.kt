package diagonalDifference;

import java.lang.Math.abs

fun calculate(dimension: Int = 0, matrix: Array<IntArray>): Int {
    var firstDiagonal = 0;
    var secondDiagonal = 0;
    for (index in 0 until dimension) {
        firstDiagonal += matrix[index][index]
        secondDiagonal += matrix[index][dimension - index - 1];
    }

    return abs(firstDiagonal - secondDiagonal);
}