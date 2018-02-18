package timeConversion

fun convertTime(input: String): String {
    val (hour, minutes, secondsAndSuffix) = input.split(":");
    val seconds = secondsAndSuffix.subSequence(0,2);
    val suffix = secondsAndSuffix.subSequence(2,4);
    if (suffix == "PM") {
        val convertedHour = hour.toInt() + 12;
        return if (hour == "12"){
            "$hour:$minutes:$seconds";
        } else{
            convertedHour.toString() + ":" + minutes + ":" + seconds;
        }
    } else if (suffix == "AM"){
        return if (hour == "12"){
            "00:$minutes:$seconds";
        } else {
            "$hour:$minutes:$seconds";
        }
    }
    return "";
}