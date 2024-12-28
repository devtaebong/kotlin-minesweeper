package domain

sealed interface Cell {
    val coordinate: Coordinate
    val status: CellStatus

    fun isMineCell(): Boolean

    class MineCell(
        override val coordinate: Coordinate,
        private var _status: CellStatus = CellStatus.CLOSED,
    ) : Cell {
        override val status: CellStatus
            get() = _status

        override fun isMineCell(): Boolean = true
    }

    class EmptyCell(
        override val coordinate: Coordinate,
        private var _status: CellStatus = CellStatus.CLOSED,
    ) : Cell {
        override val status: CellStatus
            get() = _status

        override fun isMineCell(): Boolean = false
    }
}
