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

    private fun play(game: Game) {
        showHelloMessages(game)
        while (!game.isGameOver()) {
            showCurrentState(game)
            processTurnAndShowGuessResult(game)
        }
        showGameOverMessages(game)
    }

    private fun showHelloMessages(game: Game) {
        Display.showWelcomeMessage()
        Display.showCurrentDifficulty(game.difficulty)
    }

    private fun showCurrentState(game: Game) {
        Display.showHangmanDrawing(game.remainingAttempts)
        Display.showMaskedWord(game.maskedWord)
        Display.showGuessedLetters(game.guessedLetters)
    }

    private fun processTurnAndShowGuessResult(game: Game) {
        val letter = InputManager.chooseLetter()
        val isCorrect = game.guess(letter)
        Display.showGuessResult(letter, isCorrect)
    }

    private fun showGameOverMessages(game: Game) {
        Display.showGameOver(game.isWin(), game.word)
    }
}