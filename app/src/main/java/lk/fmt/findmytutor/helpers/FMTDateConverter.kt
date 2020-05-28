package lk.fmt.findmytutor.helpers

import java.text.SimpleDateFormat
import java.util.*

object FMTDateConverter {

    /**
     * Parses a string to date
     * e.g 2020-04-27T13:55:21.194
     */
    fun stringToDate(stringDate: String): Date? {
        val datePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS"
        val sdf = SimpleDateFormat(datePattern)
        val date: Date? = sdf.parse(stringDate)

        return date
    }

}