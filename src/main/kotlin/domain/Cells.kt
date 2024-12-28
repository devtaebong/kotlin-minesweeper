package domain

import domain.strategy.MineCellGenerator

@JvmInline
value class Cells(private val cells: List<Cell>) {
    fun numberOfTotalCells(): Int = cells.size

    fun isAnyMineCellOpened(): Boolean {
        return cells
            .filter { it.isMineCell() }
            .any { it.status == CellStatus.OPEN }
    }

    fun isAllEmptyCellsOpened(): Boolean {
        return cells
            .filter { it.isMineCell().not() }
            .all { it.status == CellStatus.OPEN }
    }

    companion object {
        fun of(mineCellGenerator: MineCellGenerator): Cells {
            val mineCells = mineCellGenerator.execute()
            return Cells(mineCells.toList())
        }
    }
}
