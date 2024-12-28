package domain

class MineSweeperGame(private val mineBoard: MineBoard) {
    fun isContinueGame(): Boolean {
        when {
            mineBoard.hasMineExploded() -> return false
            mineBoard.isCleared() -> return false
        }
        return true
    }
}
