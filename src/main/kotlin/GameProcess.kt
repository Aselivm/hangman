import game.Game
import game.GameBuilder
import input.InputManager
import display.Display

class GameProcess {
    fun startGameLoop() {
        do {
            val difficulty = InputManager.chooseDifficulty()
            play(GameBuilder.createGame(difficulty))
        } while (InputManager.playAgain())
        Display.showThankYouMessage()
    }

    private fun play(currentGame: Game) {
        showHelloMessages(currentGame)
        while (!currentGame.isGameOver()) {
            showCurrentState(currentGame)
            processTurnAndShowGuessResult(currentGame)
        }
        showGameOver(currentGame)
    }

    private fun showHelloMessages(currentGame: Game) {
        Display.showWelcomeMessage()
        Display.showCurrentDifficulty(currentGame.difficulty)
    }

    private fun showCurrentState(currentGame: Game) {
        Display.showHangmanDrawing(currentGame.remainingAttempts)
        Display.showMaskedWord(currentGame.maskedWord)
        Display.showGuessedLetters(currentGame.guessedLetters)
    }

    private fun processTurnAndShowGuessResult(currentGame: Game) {
        val letter = InputManager.chooseLetter()
        val isCorrect = currentGame.guess(letter)
        Display.showGuessResult(letter, isCorrect)
    }

    private fun showGameOver(currentGame: Game) {
        Display.showGameOver(currentGame.isWin(), currentGame.word)
    }
}