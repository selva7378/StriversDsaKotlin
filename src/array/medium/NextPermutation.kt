package array.medium

fun main() {

}

fun nextPermutation(nums: IntArray): Unit {
    var index = -1
    for(i in (nums.size - 1) downTo 1) {
        if(nums[i - 1] < nums[i]) {
            index = i - 1
            break
        }
    }

    if(index == -1) {
        reverse(nums)
        return
    }

    for(i in (nums.size - 1) downTo (index + 1)) {
        if(nums[i] > nums[index]) {
            var temp = nums[i]
            nums[i] = nums[index]
            nums[index] = temp
            break
        }
    }
    reverse(nums, index + 1)
}

fun reverse(nums: IntArray, start: Int = 0, end: Int = nums.size - 1) {
    var i = start
    var j = end
    while (i < j) {
        var temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
        i++
        j--
    }
}