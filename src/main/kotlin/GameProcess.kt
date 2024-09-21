import game.Game
import game.GameBuilder
import input.InputManager
import display.Display

class GameProcess {
    fun start() {
        do {
            play(GameBuilder.createGame(InputManager.chooseDifficulty()))
        } while (InputManager.playAgain())
        Display.showThankYouMessage()
    }

    private fun play(currentGame: Game) {
        Display.showWelcomeMessage()
        Display.showCurrentDifficulty(currentGame.difficulty)

        while (!currentGame.isGameOver()) {
            Display.showHangmanDrawing(currentGame.remainingAttempts)
            Display.showMaskedWord(currentGame.maskedWord)
            Display.showGuessedLetters(currentGame.guessedLetters)

            val letter = InputManager.chooseLetter()
            if (currentGame.guess(letter)) {
                Display.showCorrectGuess(letter)
            } else {
                Display.showIncorrectGuess(letter)
            }
        }

        Display.showGameOver(currentGame.isWin(), currentGame.word)
    }
}