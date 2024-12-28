package domain

import domain.strategy.MineCellGenerator

@JvmInline
value class Cells(private val cells: List<Cell>) {
    fun numberOfTotalCells(): Int = cells.size

    companion object {
        fun of(mineCellGenerator: MineCellGenerator): Cells {
            val mineCells = mineCellGenerator.execute()
            return Cells(mineCells.toList())
        }
    }
}
