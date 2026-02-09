package binarysearch

fun main() {
    println(upperBound(intArrayOf(1,2,2,3), 2))
    println(upperBound(intArrayOf(3,5,8,9,15,19), 9))
}

fun upperBound(arr: IntArray, target: Int): Int {
    var ans = arr.size // default value if not found
    var low = 0
    var high = arr.size - 1
    while (low <= high) {
        val mid = (low + high) / 2
        when {
            arr[mid] <= target -> low = mid + 1
            arr[mid] > target -> {
                ans = mid
                high = mid - 1
            }
        }
    }
    return ans
}