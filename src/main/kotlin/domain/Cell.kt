package domain

sealed interface Cell {
    class MineCell(private val coordinate: Coordinate) : Cell

    class EmptyCell(private val coordinate: Coordinate) : Cell
}
