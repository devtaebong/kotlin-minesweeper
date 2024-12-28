package domain

class MineBoard(private val cells: Cells) {
    fun cellsSize() = cells.numberOfTotalCells()

    fun isAnyMineCellOpened(): Boolean {
        TODO("Not yet implemented")
    }

    fun isAllEmptyCellsOpened(): Boolean {
        TODO("Not yet implemented")
    }
}
