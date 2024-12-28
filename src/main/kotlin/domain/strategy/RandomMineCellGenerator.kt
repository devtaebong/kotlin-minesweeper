package domain.strategy

import domain.Cell
import domain.MineSweeperMetric

class RandomMineCellGenerator(private val mineSweeperMetric: MineSweeperMetric) : MineCellGenerator {
    override fun execute(): Set<Cell> {
        return emptySet()
    }
}
