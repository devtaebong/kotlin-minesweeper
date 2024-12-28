package controller

import domain.Cells
import domain.MineBoard
import domain.MineSweeperGame
import domain.MineSweeperMetric
import domain.strategy.MineCellGenerator
import domain.strategy.RandomMineCellGenerator
import view.InputView
import view.OutputView

class MineSweeperController {
    fun run() {
        val mineSweeperMetric = initializeMineSweeperMetric()
        val mineCellGenerator: MineCellGenerator = RandomMineCellGenerator(mineSweeperMetric)
        val cells = Cells.of(mineCellGenerator)
        val mineBoard = MineBoard(cells)

        OutputView.showMineSweeperBoard(mineBoard)

        gameLoop(mineBoard)
    }

    private fun gameLoop(mineBoard: MineBoard) {
        val mineSweeperGame = MineSweeperGame(mineBoard)
        while (mineSweeperGame.isContinueGame()) {
            val requestOpenCoordinate = InputView.askMineCoordinate()
            mineSweeperGame.openAdjacentCell(requestOpenCoordinate)
            OutputView.showMineSweeperBoard(mineBoard)
        }

        val result = mineSweeperGame.getGameResult()
        OutputView.showGameResult(result)
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
