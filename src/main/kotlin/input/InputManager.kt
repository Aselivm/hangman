package input

import game.Difficulty
import display.Display

object InputManager {

    fun chooseDifficulty(): Difficulty {
        Display.showDifficultyOptions()
        while (true) {
            val difficulty = when (input()) {
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
            val inputGuess = input()
            if (inputGuess != null && inputGuess.length == 1 && isRussianLetter(inputGuess[0])) {
                return inputGuess[0]
            } else {
                Display.showInvalidLetterInput()
            }
        }
    }

    fun playAgain(): Boolean {
        while (true) {
            Display.showPlayAgainPrompt()
            when (input()) {
                "да" -> return true
                "нет" -> return false
                else -> {
                    println("Пожалуйста, введите 'да' или 'нет'.")
                }
            }
        }
    }

    private fun input(): String? {
        return readlnOrNull()?.trim()?.lowercase()
    }

    private fun isRussianLetter(char: Char): Boolean {
        return char in 'А'..'я' || char == 'Ё' || char == 'ё'
    }
}