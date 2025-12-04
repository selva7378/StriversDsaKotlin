package array.medium


fun main() {
    leaderInArray(intArrayOf(4, 7, 1, 0))
    leaderInArray(intArrayOf(10, 22, 12, 3, 0, 6))
}


fun leaderInArray(nums: IntArray) {
    var max = Int.MIN_VALUE
    for(num in nums.reversedArray()) {
        if (num > max) {
            max = num
            println(max)
        }
    }
}