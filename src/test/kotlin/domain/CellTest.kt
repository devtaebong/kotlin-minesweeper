package domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class CellTest : DescribeSpec({
    describe("isMineCell test") {
        context("지뢰 셀인 경우") {
            it("should be true") {
                Cell.MineCell(Coordinate(1, 1)).isMineCell().shouldBeTrue()
            }
        }

        context("빈 셀인 경우") {
            it("should be false") {
                Cell.EmptyCell(Coordinate(1, 1)).isMineCell().shouldBeFalse()
            }
        }
    }
})
