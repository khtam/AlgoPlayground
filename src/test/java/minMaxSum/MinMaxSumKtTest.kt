package minMaxSum

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MinMaxSumKtTest {

    @Test
    fun minMaxSum() {
        //Given
        val inputList = listOf<Long>(1, 2, 3, 4, 5);

        //When
        val result = minMaxSumOf(inputList);

        //Then
        assertThat(result).containsExactly(10, 14);
    }
}