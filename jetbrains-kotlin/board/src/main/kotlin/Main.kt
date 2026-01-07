package org.example

fun main() {

}

fun createSquareBoard(width: Int): SquareBoard = Board(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = Game(Board(width))

data class Cell(val i: Int, val j: Int) {
    override fun toString()= "($i, $j)"
}

enum class Direction {
    UP, DOWN, RIGHT, LEFT;

    fun reversed() = when (this) {
        UP -> DOWN
        DOWN -> UP
        RIGHT -> LEFT
        LEFT -> RIGHT
    }
}

class Game<T>(
    private val board: Board
) : GameBoard<T>, SquareBoard by board {
    private val cellMap = mutableMapOf<Cell, T?>()

    override fun get(cell: Cell): T? = cellMap[cell]

    override fun set(cell: Cell, value: T?) {
        cellMap[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        return TODO()
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        return TODO()
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        return TODO()
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        return TODO()
    }
}

interface SquareBoard {
    val width: Int

    fun getCellOrNull(i: Int, j: Int): Cell?
    fun getCell(i: Int, j: Int): Cell

    fun getAllCells(): Collection<Cell>

    fun getRow(i: Int, jRange: IntProgression): List<Cell>
    fun getColumn(iRange: IntProgression, j: Int): List<Cell>

    fun Cell.getNeighbour(direction: Direction): Cell?
}

interface GameBoard<T> : SquareBoard {

    operator fun get(cell: Cell): T?
    operator fun set(cell: Cell, value: T?)

    fun filter(predicate: (T?) -> Boolean): Collection<Cell>
    fun find(predicate: (T?) -> Boolean): Cell?
    fun any(predicate: (T?) -> Boolean): Boolean
    fun all(predicate: (T?) -> Boolean): Boolean
}

class Board(override val width: Int) : SquareBoard {
    val array = Array(width) { i ->
        Array(width) { j ->
            Cell(i + 1, j + 1)
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return try {
            getCell(i, j)
        } catch (_: Exception) {
            null
        }
    }

    override fun getCell(i: Int, j: Int): Cell {
        return if (i in 1..width && j in 1..width) array[i - 1][j - 1]
        else throw IllegalArgumentException()
    }

    override fun getAllCells(): Collection<Cell> = array.flatten()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val result = mutableListOf<Cell?>()

        jRange.forEach { j ->
            result += getCellOrNull(i, j)
        }

        return result.filterNotNull()
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val result = mutableListOf<Cell?>()

        iRange.forEach { i ->
            result += getCellOrNull(i, j)
        }

        return result.filterNotNull()
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        return when (direction) {
            Direction.UP -> getCellOrNull(this.i - 1, this.j)
            Direction.DOWN -> getCellOrNull(this.i + 1, this.j)
            Direction.RIGHT -> getCellOrNull(this.i, this.j + 1)
            Direction.LEFT -> getCellOrNull(this.i, this.j - 1)
        }
    }
}