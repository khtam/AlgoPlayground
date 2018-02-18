package diagonalDifference

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class DiagonalDifferenceKtTest {

    @Test
    fun calculate() {
        //Given
        val dimension = 3;
        val matrix = arrayOf(intArrayOf(11, 2, 4), intArrayOf(4, 5, 6), intArrayOf(10, 8, -12));

        //When
        val result = calculate(dimension, matrix);

        //then
        assertThat(result).isEqualTo(15);
        assertThat(result).isGreaterThan(0)
    }
}