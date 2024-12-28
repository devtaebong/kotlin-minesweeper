package domain

sealed interface Cell {
    fun isMineCell(): Boolean

    class MineCell(private val coordinate: Coordinate) : Cell {
        override fun isMineCell(): Boolean = true
    }

    class EmptyCell(private val coordinate: Coordinate) : Cell {
        override fun isMineCell(): Boolean = false
    }
}
