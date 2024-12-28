package domain

data class Coordinate(val row: Row, val col: Col) {
    companion object {
        operator fun invoke(
            row: Int,
            col: Int,
        ): Coordinate {
            return Coordinate(Row(row), Col(col))
        }
    }
}
