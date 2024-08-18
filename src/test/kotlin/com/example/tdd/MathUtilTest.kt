package com.example.tdd

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.io.File
import java.io.IOException
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.test.assertEquals

@SpringBootTest
class MathUtilTest {

    @Test
    @DisplayName("파일이 없을때")
    fun noDataFile_Then_Exception() {
        givenNoFile("badpath.txt")

        val dataFile = File("badpath.txt")
        assertThrows<IllegalArgumentException> {
            MathUtils.sum(dataFile)
        }
    }

    private fun givenNoFile(path: String) {
        val file = File(path)
        if(file.exists()) {
            val deleted = file.delete()
            if(!deleted) throw RuntimeException("fail givenNoFile" + path)
        }
    }

    @Test
    @DisplayName("파일이 있을때")
    fun dataFileSumeTest() {
        givenDataFile("src/test/resources/datafile.txt", "1", "2", "3", "4")

        val dataFile = File("src/test/resources/datafile.txt")
        val sum = MathUtils.sum(dataFile)
        assertEquals(10L, sum)
    }

    private fun givenDataFile(path: String, vararg lines: String) {
        try {
            val dataPath = Path(path)
            if(Files.exists(dataPath)) {
                Files.delete(dataPath)
            }
            Files.write(dataPath, lines.toList())
        } catch(e: IOException) {
            throw RuntimeException(e)
        }
    }


}