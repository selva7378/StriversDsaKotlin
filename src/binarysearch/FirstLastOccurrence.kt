package binarysearch

fun firstAndLastPositions(nums: IntArray, target: Int): IntArray {
    var first = -1
    first = firstOccurrence(nums, target)
    if(first == -1) return intArrayOf(-1, -1)
    return intArrayOf(first, lastOccurrence(nums, target))
}

fun firstOccurrence(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var ans  = -1
    while(low <= high) {
        val mid = low + (high - low) / 2
        if(nums[mid] == target) {
            ans = mid
            high = mid - 1
        }else if(nums[mid] > target) {
            high = mid - 1
        }else {
            low = mid + 1
        }
    }
    return ans
}

fun lastOccurrence(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var ans  = -1
    while(low <= high) {
        val mid = low + (high - low) / 2
        if(nums[mid] == target) {
            ans = mid
            low = mid + 1
        }else if(nums[mid] > target) {
            high = mid - 1
        }else {
            low = mid + 1
        }
    }
    return ans
}