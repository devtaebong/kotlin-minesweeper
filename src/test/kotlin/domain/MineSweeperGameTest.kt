package domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MineSweeperGameTest : DescribeSpec({
    describe("isContinueGame Test") {
        lateinit var sut: MineSweeperGame

        context("하나 이상의 MineCell이 Open 되어 있는 경우") {
            beforeTest {
                val cells =
                    Cells(
                        listOf(
                            Cell.MineCell(Coordinate(1, 1)),
                            Cell.MineCell(Coordinate(2, 2)),
                            Cell.MineCell(Coordinate(3, 3), CellStatus.OPEN),
                        ),
                    )
                val mineBoard = MineBoard(cells)
                sut = MineSweeperGame(mineBoard)
            }

            it("should be false") {
                sut.isContinueGame() shouldBe false
            }
        }

        context("모든 MineCell이 Closed 상태인 경우") {
            beforeTest {
                val cells =
                    Cells(
                        listOf(
                            Cell.MineCell(Coordinate(1, 1)),
                            Cell.MineCell(Coordinate(2, 2)),
                            Cell.MineCell(Coordinate(3, 3)),
                        ),
                    )
                val mineBoard = MineBoard(cells)
                sut = MineSweeperGame(mineBoard)
            }

            it("should be true") {
                sut.isContinueGame() shouldBe true
            }
        }

        context("모든 Empty Cell이 Open인 경우") {
            beforeTest {
                val cells =
                    Cells(
                        listOf(
                            Cell.EmptyCell(Coordinate(1, 1), CellStatus.OPEN),
                            Cell.EmptyCell(Coordinate(2, 2), CellStatus.OPEN),
                            Cell.MineCell(Coordinate(3, 3)),
                            Cell.EmptyCell(Coordinate(4, 4), CellStatus.OPEN),
                        ),
                    )
                val mineBoard = MineBoard(cells)
                sut = MineSweeperGame(mineBoard)
            }

            it("should be false") {
                sut.isContinueGame() shouldBe false
            }
        }
    }
})
