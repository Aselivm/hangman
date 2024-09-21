package manager

import game.Difficulty
import renderer.Display

object InputManager {

    fun chooseDifficulty(): Difficulty {
        Display.showDifficultyOptions()
        while (true) {
            val difficulty = when (readlnOrNull()?.trim()?.lowercase()) {
                "1" -> Difficulty.EASY
                "2" -> Difficulty.MEDIUM
                "3" -> Difficulty.HARD
                else -> {
                    Display.showInvalidDifficultyChosen()
                    continue
                }
            }
            Display.showCurrentDifficulty(difficulty)
            return difficulty
        }
    }

    fun chooseLetter(): Char {
        Display.showLetterPrompt()
        while (true) {
            val input = readlnOrNull()?.trim()?.lowercase()
            if (input != null && input.length == 1 && isRussianLetter(input[0])) {
                return input[0]
            } else {
                Display.showInvalidLetterInput()
            }
        }
    }

    fun playAgain(): Boolean {
        while (true) {
            Display.showPlayAgainPrompt()

            when (readlnOrNull()?.trim()?.lowercase()) {
                "да" -> return true
                "нет" -> return false
                else -> {
                    println("Пожалуйста, введите 'да' или 'нет'.")
                }
            }
        }
    }

    private fun isRussianLetter(char: Char): Boolean {
        return char in 'А'..'я' || char == 'Ё' || char == 'ё'
    }
}