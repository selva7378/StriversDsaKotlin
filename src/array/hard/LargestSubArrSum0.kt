package array.hard

fun main() {
    print(largestSubArrSum(intArrayOf(9, -3, 3, -1, 6, -5), 0))
    print(largestSubArrSum(intArrayOf(6, -2, 2, -8, 1, 7, 4, -10), 0))
}

fun largestSubArrSum(nums: IntArray, target: Int): Int {
    var preSum = 0
    var res = 0
    val map = mutableMapOf<Int, Int>()   // preSum -> first index
    map[0] = 0    // before starting

    for (i in nums.indices) {
        preSum += nums[i]

        val rem = preSum - target

        if (map.containsKey(rem)) {
            val len = i + 1 - map[rem]!!
            if (len > res) res = len
        }

        // store first occurrence only
        if (!map.containsKey(preSum)) {
            map[preSum] = i + 1
        }
    }
    return res
}