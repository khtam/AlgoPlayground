package plusMinus

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PlusMinusKtTest {

    @Test
    fun shouldProduceFractions() {
        //Given
        val size = 6;
        val inputArray: IntArray = intArrayOf(-4, 3, -9, 0, 4, 1);

        //When
        val outputArray: List<String> = calculate(size, inputArray);

        //Then
        assertThat(outputArray).containsExactly("0.500000", "0.333333", "0.166667");
    }
}