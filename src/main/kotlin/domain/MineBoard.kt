package domain

class MineBoard(private val cells: Cells) {
    fun cellsSize() = cells.numberOfTotalCells()

    fun hasMineExploded(): Boolean {
        return cells.isAnyMineCellOpened()
    }

    fun isCleared(): Boolean {
        return cells.isAllEmptyCellsOpened()
    }
}
