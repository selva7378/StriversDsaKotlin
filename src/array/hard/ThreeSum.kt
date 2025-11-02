package array.hard

fun main() {
    println(threeSum(intArrayOf(-1,0,1,2,-1,-4)))
}

fun threeSum(nums: IntArray): List<List<Int>> {
//    nums.sort()
    val list = mutableListOf(mutableListOf<Int>())
    for(i in 0 until nums.size) {
        if(i != 0 && nums[i] == nums[i - 1]) continue

        var j = i + 1
        var k = nums.size - 1
        while(j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if(sum > 0) k--
            else if(sum < 0) j++
            else {
                list.add(mutableListOf(nums[i], nums[j], nums[k]))
                j++
                k--
                while(j < k) {
                    if(nums[j] == nums[j - 1]) j++
                    if(nums[k] == nums[k + 1]) k--
                }
            }
        }
    }
    return list
}