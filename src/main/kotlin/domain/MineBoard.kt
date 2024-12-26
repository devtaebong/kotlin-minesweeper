package domain

class MineBoard private constructor(private val cell: List<Cell>) {
    fun cellsSize() = 9

    companion object {
        fun of(mineSweeperMetric: MineSweeperMetric): MineBoard {
            return MineBoard(emptyList())
        }
    }
}
