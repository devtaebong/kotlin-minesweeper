package domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MineBoardTest : DescribeSpec({
    describe("`MineSweeperMetric`으로 `MineBoard`를 생성한다.") {
        lateinit var mineSweeperMetric: MineSweeperMetric
        beforeTest { mineSweeperMetric = MineSweeperMetric(3, 3, 1) }

        context("row x col = cell.size()") {
            it("should be true") {
                val cells =
                    Cells(
                        listOf(
                            Cell.EmptyCell(Coordinate(1, 1)),
                            Cell.MineCell(Coordinate(1, 2)),
                        ),
                    )
                val sut = MineBoard(cells)
                sut.cellsSize() shouldBe 9
            }
        }
    }
})
