package renderer

import game.Difficulty

object Display {
    fun showWelcomeMessage() {
        println("Добро пожаловать в игру Хенгман!")
    }

    fun showDifficultyOptions() {
        println("Выберите сложность (1 - Легкий, 2 - Средний, 3 - Сложный):")
    }

    fun showCurrentDifficulty(difficulty: Difficulty) {
        println("Текущий уровень сложности: $difficulty")
    }

    fun showInvalidDifficultyChosen() {
        println("Некорректный ввод. Пожалуйста, выберите 1, 2 или 3.")
    }

    fun showLetterPrompt() {
        println("Введите букву:")
    }

    fun showInvalidLetterInput() {
        println("Ошибка ввода. Пожалуйста, введите корректную русскую букву.")
    }

    fun showCorrectGuess(letter: Char) {
        println("Правильный ввод: буква '$letter' присутствует в слове!")
    }

    fun showIncorrectGuess(letter: Char) {
        println("Неправильный ввод: буква '$letter' отсутствует в слове.")
    }

    fun showGameOver(isWin: Boolean, word: String) {
        val message = if (isWin) {
            "Поздравляем! Вы угадали слово: $word"
        } else {
            "Игра окончена. Загаданное слово было: $word"
        }
        println(message)
    }

    fun showMaskedWord(maskedWord: String) {
        println("Загаданное слово: $maskedWord")
    }

    fun showPlayAgainPrompt() {
        println("Хотите сыграть снова? (да/нет)")
    }

    fun showThankYouMessage() {
        println("Спасибо за игру!")
    }

    fun showGuessedLetters(guessedLetters: String) {
        println("Guessed letters: $guessedLetters")
    }

    fun showHangmanDrawing(attemptsLeft: Int) {
        val hangman = when (attemptsLeft) {
            6 -> HangmanDrawings.HANGMAN_STAGE_6
            5 -> HangmanDrawings.HANGMAN_STAGE_5
            4 -> HangmanDrawings.HANGMAN_STAGE_4
            3 -> HangmanDrawings.HANGMAN_STAGE_3
            2 -> HangmanDrawings.HANGMAN_STAGE_2
            1 -> HangmanDrawings.HANGMAN_STAGE_1
            0 -> HangmanDrawings.HANGMAN_STAGE_0
            else -> throw IllegalArgumentException("Invalid number of attempts left: $attemptsLeft. Must be between 0 and 6.")
        }
        println(hangman)
    }
}
