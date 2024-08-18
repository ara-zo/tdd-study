package com.example.tdd

import java.io.File

object MathUtils {

    fun sum(dataFile: File): Long {
        var sum = 0L

        dataFile.forEachLine { line ->
            val number = line.toIntOrNull()
            if (number != null) {
                sum += number
            }
        }

        return sum
    }
}