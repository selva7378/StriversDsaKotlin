package binarysearch

fun searchInsert(nums: IntArray, target: Int): Int {
    var ans = nums.size
    var low = 0
    var high = nums.size - 1
    while(low <= high) {
        var mid = low + (high - low) / 2
        when {
            nums[mid] >= target -> {
                ans = mid
                high = mid - 1
            }
            else -> low = mid + 1
        }
    }
    return ans
}