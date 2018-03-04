package timeConversion

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TimeConversionKtTest{

    @Test
    fun shouldConvertTime() {
        //Given
        val timeString = "07:05:45PM"

        //When
        val convertedString = convertTime(timeString);

        //Then
        assertThat(convertedString).isEqualTo("19:05:45");
    }

    @Test
    fun shouldConvertMidNight() {
        //Given
        val timeString = "00:15:45AM"

        //When
        val convertedString = convertTime(timeString);

        //Then
        assertThat(convertedString).isEqualTo("00:15:45");
    }

    @Test
    fun shouldConvertNoon() {
        //Given
        val timeString = "12:15:45PM"

        //When
        val convertedString = convertTime(timeString);

        //Then
        assertThat(convertedString).isEqualTo("12:15:45");
    }
}