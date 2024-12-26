package domain

import constants.MineSweeperConstants.MINIMUM_HEIGHT
import constants.MineSweeperConstants.MINIMUM_MINE_COUNT
import constants.MineSweeperConstants.MINIMUM_WIDTH

data class MineSweeperMetric(private val row: Int, private val col: Int, private val mineCount: Int) {
    init {
        require(row >= MINIMUM_HEIGHT) { "높이는 $MINIMUM_HEIGHT 이상입니다. value: $row" }
        require(col >= MINIMUM_WIDTH) { "너비는 $MINIMUM_WIDTH 이상입니다. value: $col" }
        require(
            mineCount >= MINIMUM_MINE_COUNT && row * col >= mineCount,
        ) { "지뢰 개수는 전체 칸의 개수보다 많을 수 없습니다. row: $row, col: $col value: $mineCount" }
    }
}
