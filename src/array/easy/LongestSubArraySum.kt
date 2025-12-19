package array.easy

import java.util.Collections
import java.util.PriorityQueue

// Longest Subarray with given Sum K(Positives)

fun main() {
    var arr1 = intArrayOf(2, 3 ,4)
    var arr2 = intArrayOf(2, 3 ,5, 1, 0)
    println(longestSubArrayWithGivenSum(arr1, 5))
    println(longestSubArrayWithGivenSum(arr2, 10))
    println(arr1)
}


fun longestSubArrayWithGivenSum(arr: IntArray, target: Int): Int {
    val map = mutableMapOf<Int, Int>()
    var preSum = 0
    var res = 0

    map[0] = -1   // base case

    for (i in arr.indices) {
        preSum += arr[i]

        if (!map.containsKey(preSum)) {
            map[preSum] = i
        }

        val rem = preSum - target
        if (map.containsKey(rem)) {
            res = maxOf(res, i - map[rem]!!)
        }
    }
    return res
}
