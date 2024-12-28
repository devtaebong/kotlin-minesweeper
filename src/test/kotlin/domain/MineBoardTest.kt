package domain

import domain.strategy.RandomMineCellGenerator
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MineBoardTest : DescribeSpec({
    describe("`MineSweeperMetric`으로 `MineBoard`를 생성한다.") {
        lateinit var mineSweeperMetric: MineSweeperMetric
        beforeTest { mineSweeperMetric = MineSweeperMetric(3, 3, 1) }

        context("row x col = cell.size()") {
            it("should be true") {
                val cells = Cells.of(RandomMineCellGenerator(mineSweeperMetric))
                val sut = MineBoard(cells)
                sut.cellsSize() shouldBe 9
            }
        }
    }
})
