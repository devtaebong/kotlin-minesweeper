package domain

class MineSweeperGame(private val mineBoard: MineBoard) {
    fun isContinueGame(): Boolean {
        when {
            mineBoard.isAnyMineCellOpened() -> return false
            mineBoard.isAllEmptyCellsOpened() -> return false
        }
        return true
    }

    fun openAdjacentCell(coordinate: Coordinate) {
        val queue: ArrayDeque<Coordinate> = ArrayDeque()
        queue.add(coordinate)

        while (queue.isNotEmpty()) {
            processCell(queue)
        }
    }

    private fun processCell(queue: ArrayDeque<Coordinate>) {
        val current = queue.removeFirst()
        val cell = mineBoard.getCell(current)

        if (shouldSkipCell(cell)) return

        mineBoard.openCell(current)

        if (shouldAddAdjacentCells(cell)) {
            val adjacentCoordinates = mineBoard.getAdjacentCoordinates(cell)
            queue.addAll(adjacentCoordinates)
        }
    }

    private fun shouldSkipCell(cell: Cell): Boolean {
        return cell.isMineCell() || cell.status == CellStatus.OPEN
    }

    private fun shouldAddAdjacentCells(cell: Cell): Boolean {
        return cell is Cell.EmptyCell && mineBoard.countAdjacentMines(cell) == 0
    }

    fun getGameResult(): GameResult =
        when {
            mineBoard.isAllEmptyCellsOpened() -> GameResult.SUCCESS
            else -> GameResult.FAILURE
        }
}
