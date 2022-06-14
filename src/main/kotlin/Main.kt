import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {
    val setA = listOf(1, 2, 3, 4)

    println("The subsets of $setA are: ${findAllUniqueSubsets(setA)}")

    testNumberOfPossibleSubSets(setA)
}

fun findAllUniqueSubsets(list: List<Int>): MutableList<List<Int>> {

    val result = mutableListOf<List<Int>>(listOf())

    var i = 0
    while (i < list.size) {
        val currentNumber = list[i]
        var j = 0
        val count = result.size
        while (j < count) {
            val newList = result[j].toMutableList()
            newList.add(currentNumber)
            result.add(newList)
            j++
        }
        i++
    }
    return result
}

fun testNumberOfPossibleSubSets(list: List<Int>) {

    val base = 2
    val n = list.size
    val result = base.toDouble().pow(n.toDouble())

    val numberOfSubsets = findAllUniqueSubsets(list).size.toDouble()

    println("${result == numberOfSubsets}, Are expected ${result.roundToInt()} subsets for this set. The final count is ${numberOfSubsets.roundToInt()}")
}