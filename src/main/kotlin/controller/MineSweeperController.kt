package controller

import domain.Board
import view.InputView

class MineSweeperController {
    fun run() {
        val rowSize = InputView.inputRowSize()
        val colSize = InputView.inputColumnSize()
        val mineCount = InputView.inputMineCount()

        val board = Board(height = rowSize, width = colSize, mineCount = mineCount)
    }
}
