package renderer

object HangmanDrawings {
    const val HANGMAN_STAGE_6 = """
        ------
        |    |
        |
        |
        |
        |
    """

    const val HANGMAN_STAGE_5 = """
        ------
        |    |
        |    O
        |
        |
        |
    """

    const val HANGMAN_STAGE_4 = """
        ------
        |    |
        |    O
        |    |
        |
        |
    """

    const val HANGMAN_STAGE_3 = """
        ------
        |    |
        |    O
        |   /|
        |
        |
    """

    const val HANGMAN_STAGE_2 = """
        ------
        |    |
        |    O
        |   /|\\
        |
        |
    """

    const val HANGMAN_STAGE_1 = """
        ------
        |    |
        |    O
        |   /|\\
        |   /
        |
    """

    const val HANGMAN_STAGE_0 = """
        ------
        |    |
        |    O
        |   /|\\
        |   / \\
        |
    """
}
