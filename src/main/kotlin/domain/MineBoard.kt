package domain

class MineBoard(private val cells: Cells) {
    fun cellsSize() = cells.numberOfTotalCells()
}
