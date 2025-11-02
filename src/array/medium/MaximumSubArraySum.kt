package array.medium

fun main() {
    println(kadanesAlgo(listOf(2, 3, 5, -2, 7, -4)))
    println(kadanesAlgo(listOf(-2, -3, -7, -2, -10, -4)))
}

fun kadanesAlgo(nums: List<Int>): Int{
    var res = Int.MIN_VALUE
    var sum = 0
    for (num in nums) {
        sum += num

        res = if (sum > res) sum else res
        if (sum < 0) {
            sum = 0
        }
    }
    return res
}


