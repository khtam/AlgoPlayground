package coinOnTable

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MinOperationsKtTest(private val row: Int, private val column: Int, private val rounds: Int, private val expectedResult: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
                arrayOf(2,2,3,0),
                arrayOf(2,2,1,1)
        )
    }

    @Test
    fun minOperations() {

        val result = minOperations(row, column, rounds, "");

        assertThat(result).isEqualTo(expectedResult)
    }
}