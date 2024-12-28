package controller

import domain.MineSweeperMetric
import view.InputView

class MineSweeperController {
    fun run() {
    }

    private fun inputMineSweeperMetric(): MineSweeperMetric {
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
