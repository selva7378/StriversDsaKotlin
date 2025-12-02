package array.medium

fun main() {
    printSubArrayMaxSubArray(intArrayOf(2, 3, 5, -2, 7, -4))
}

fun printSubArrayMaxSubArray(nums: IntArray) {
    var res = Int.MIN_VALUE
    var sum = 0
    var ansStart = 0
    var ansEnd = 0
    var start = 0
    for ((index,num) in nums.withIndex()) {
        if (sum == 0) {
            start = index
        }
        sum += num

        if (sum > res) {
            res = sum
            ansStart = start
            ansEnd = index
        }
        if (sum < 0) {
            sum = 0
        }
    }

    for ( i in ansStart..ansEnd) {
        print("${nums[i]},")
    }
}