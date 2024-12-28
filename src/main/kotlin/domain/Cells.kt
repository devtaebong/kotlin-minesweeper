package domain

import domain.strategy.MineCellGenerator

data class Cells(private val cells: List<Cell>) {
    companion object {
        fun of(mineCellGenerator: MineCellGenerator): Cells {
            val mineCells = mineCellGenerator.execute()
            return Cells(mineCells.toList())
        }
    }
}
