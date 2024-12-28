package domain.strategy

import domain.Cell

interface MineCellGenerator {
    fun execute(): Set<Cell>
}
