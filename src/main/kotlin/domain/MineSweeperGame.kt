package domain

class MineSweeperGame(private val mineBoard: MineBoard) {
    fun isContinueGame(): Boolean {
        when {
            mineBoard.isAnyMineCellOpened() -> return false
            mineBoard.isAllEmptyCellsOpened() -> return false
        }
        return true
    }
}
