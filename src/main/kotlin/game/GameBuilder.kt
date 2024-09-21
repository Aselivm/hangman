package game

import repository.DictionaryRepository

object GameBuilder {

    private const val ATTEMPTS_IN_TOTAL = 6

    private val dictionaryRepository = DictionaryRepository()

    fun createGame(difficulty: Difficulty): Game {
        val word = dictionaryRepository.getWordByDifficulty(difficulty)
        return Game(word, ATTEMPTS_IN_TOTAL, difficulty)
    }
}
