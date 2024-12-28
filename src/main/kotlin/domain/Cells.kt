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

    fun get(coordinate: Coordinate): Cell {
        return cells.firstOrNull { it.coordinate == coordinate }
            ?: throw NoSuchElementException("Coordinate $coordinate not found")
    }

    fun getBoardHeight(): Row {
        return cells.maxBy { it.coordinate.row }.coordinate.row
    }

    fun getBoardWidth(): Col {
        return cells.maxBy { it.coordinate.col }.coordinate.col
    }

    companion object {
        fun of(mineCellGenerator: MineCellGenerator): Cells {
            val mineCells = mineCellGenerator.execute()
            return Cells(mineCells.toList())
        }
    }
}
