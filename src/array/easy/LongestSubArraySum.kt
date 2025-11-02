package array.easy

import java.util.Collections
import java.util.PriorityQueue

// Longest Subarray with given Sum K(Positives)

fun main() {
    var arr1 = arrayOf(2, 3 ,4)
    var arr2 = arrayOf(2, 3 ,5, 1, 0)
//    println(longestSubArrayWithGivenSum(arr1, 5))
//    println(longestSubArrayWithGivenSum(arr2, 10))
    println(arr1)
}

fun longestSubArrayWithGivenSum(arr: Array<Int>, target: Int): Int {
    var res = 0
    var preSum = 0
    var map = mutableMapOf<Int, Int>()
    for (i in 0 until arr.size) {
        preSum += arr[i]
        if (preSum == target) {
            res = i + 1
        }
        map.put(preSum, i)
        var rem = preSum - target
        var len = i - map.getOrDefault(rem, 0)
        res = if (len > res) len else res
    }
    return res
}

fun numberAppearsOnce(list: MutableList<Int>, ele: Int): Int {
    val map = mutableMapOf(0 to 0)
    var preSum = 0
    var res = 0
    for((index, num) in list.withIndex()) {
        preSum += num
        map[preSum] = index + 1
        val rem = preSum - ele
        if(map.contains(rem)){
            var len = index + 1 - (map[rem] ?: 0)
            res = if(len > res)  len else res
        }
    }
    return res
}