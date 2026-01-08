package array.hard

fun main() {
    print(repeatingMissingNumber(intArrayOf(3, 5, 4, 1, 1)).contentToString())
    print(repeatingMissingNumber(intArrayOf(1, 2, 3, 6, 7, 5, 7)).contentToString())
}

fun repeatingMissingNumber(nums: IntArray): IntArray {
    val n: Long = nums.size.toLong()
    var s: Long = 0
    var sn: Long = (n * (n + 1)) / 2
    var s2: Long = 0
    var s2n: Long = (n * (n + 1) * (2 * n + 1)) / 6
    for(num in nums) {
        s += num
        s2 += num * num
    }
    var val1 = s - sn  //x - y
    var val2 = s2 - s2n
    val2 = val2 / val1//x + y
    val x = (val1 + val2) / 2
    val y = x - val1
    return intArrayOf(x.toInt(), y.toInt())
}