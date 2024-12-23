package domain

sealed interface Cell {
    val coordinate: Coordinate
    val status: CellStatus

    fun isMineCell(): Boolean

    fun open()

    data class MineCell(
        override val coordinate: Coordinate,
        private var _status: CellStatus = CellStatus.CLOSED,
    ) : Cell {
        override val status: CellStatus
            get() = _status

        override fun open() {
            _status = CellStatus.OPEN
        }

        override fun isMineCell(): Boolean = true
    }

    data class EmptyCell(
        override val coordinate: Coordinate,
        private var _status: CellStatus = CellStatus.CLOSED,
    ) : Cell {
        override val status: CellStatus
            get() = _status

        override fun open() {
            _status = CellStatus.OPEN
        }

        override fun isMineCell(): Boolean = false
    }
}
