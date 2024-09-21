package repository

import game.Difficulty
import java.io.InputStream
import java.lang.RuntimeException

class DictionaryRepository {
    companion object {
        private const val FILE_NAME = "/words.txt"
        private val dictionary = setDictionaryFromFile(FILE_NAME)

        private fun setDictionaryFromFile(fileName: String): List<String> {
            val listOfWords = mutableListOf<String>()
            val inputStream: InputStream = object {}.javaClass.getResourceAsStream(fileName)
                ?: throw RuntimeException("Файл $fileName не найден")

            inputStream.bufferedReader().useLines { lines ->
                lines.forEach { listOfWords.add(it) }
            }

            if (listOfWords.isNotEmpty()) return listOfWords
            else throw RuntimeException("Словарь пуст")
        }
    }

    fun getWordByDifficulty(difficulty: Difficulty): String {
        val filteredWords = when (difficulty) {
            Difficulty.EASY -> dictionary.filter { it.length <= 3 }
            Difficulty.MEDIUM -> dictionary.filter { it.length in 4..5 }
            Difficulty.HARD -> dictionary.filter { it.length > 5 }
        }
        return filteredWords.randomOrNull() ?: throw RuntimeException("Ошибка в инициализации слова")
    }
}
