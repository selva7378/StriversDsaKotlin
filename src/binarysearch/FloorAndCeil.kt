package binarysearch


fun main() {

    println(findFloor(intArrayOf(3, 4, 4, 7, 8, 10), 5))
    println(findCeil(intArrayOf(3, 4, 4, 7, 8, 10), 5))

    println(findFloor(intArrayOf(3, 4, 4, 7, 8, 10), 8))
    println(findCeil(intArrayOf(3, 4, 4, 7, 8, 10), 8))
}

fun findFloor(arr: IntArray, num: Int): Int {
    var ans = -1
    var low = 0
    var high = arr.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            arr[mid] <= num -> {
                ans = arr[mid]
                low = mid + 1
            }
            else -> {
                high = mid - 1
            }
        }
    }
    return ans
}

fun findCeil(arr: IntArray, num: Int): Int {
    var ans = -1
    var low = 0
    var high = arr.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            arr[mid] >= num -> {
                ans = arr[mid]
                high = mid - 1
            }
            else -> {
                low = mid + 1
            }
        }
    }
    return ans
}