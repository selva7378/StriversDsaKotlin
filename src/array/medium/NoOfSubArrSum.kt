package array.medium


fun main() {
    print(subarraySum(intArrayOf(1,2,3,4), 6))
}


fun subarraySum(nums: IntArray, k: Int): Int {
    var res = 0
    var preSum = 0
    val map = mutableMapOf(0 to 1)
    for(num in nums) {
        preSum += num
        var rem = preSum - k
        if(map[rem] != null) {
            res += map[rem]!!
        }
        map[preSum] = ( map[preSum] ?: 0 ) + 1
    }
    return res
}