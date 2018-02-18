package birthdayCakeCandle

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BirthdayCakeCandleKtTest {

    @Test
    fun shouldReturnCandlesBlown() {
        //Given
        val candleHeights:List<Long> = listOf(3,2,1,3);

        //When
        val blownCandles = birthdayCakeCandle.countCandles(candleHeights);

        //Then
        assertThat(blownCandles).isEqualTo(2);
    }
}