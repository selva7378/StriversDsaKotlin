package binarysearch

fun main () {
    println(count(intArrayOf(2, 2 , 3 , 3 , 3 , 3 , 4), 3))
    println(count(intArrayOf(1, 1, 2, 2, 2, 2, 2, 3), 2))
}


fun count(arr: IntArray, target: Int): Int {
    var positions = firstAndLastPositions(arr, target)
    if (positions[0] == -1) return 0
    return (positions[1] - positions[0] + 1)
}