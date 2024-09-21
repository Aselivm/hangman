import game.Game
import game.GameBuilder
import manager.InputManager
import renderer.Display

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
            processTurn(currentGame)
        }

        Display.showGameOver(currentGame.isWin(), currentGame.word)
    }

    private fun processTurn(currentGame: Game) {
        val letter = InputManager.chooseLetter()

        if (currentGame.guess(letter)) {
            Display.showCorrectGuess(letter)
        } else {
            Display.showIncorrectGuess(letter)
        }
    }
}