package controller

import domain.Cells
import domain.MineBoard
import domain.MineSweeperMetric
import domain.strategy.MineCellGenerator
import domain.strategy.RandomMineCellGenerator
import view.InputView

class MineSweeperController {
    fun run() {
        val mineSweeperMetric = initializeMineSweeperMetric()
        val mineCellGenerator: MineCellGenerator = RandomMineCellGenerator(mineSweeperMetric)
        val cells = Cells.of(mineCellGenerator)
        val mineBoard = MineBoard(cells)
    }

    private fun initializeMineSweeperMetric(): MineSweeperMetric {
        val mineBoardHeight = InputView.inputMineBoardHeight()
        val mineBoardWidth = InputView.inputMineBoardWidth()
        val mineCount = InputView.inputMineCount()
        return MineSweeperMetric(
            mineBoardHeight = mineBoardHeight,
            mineBoardWidth = mineBoardWidth,
            mineCount = mineCount,
        )
    }
}
