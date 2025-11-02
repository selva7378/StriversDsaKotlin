package array.hard

fun main() {

}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    nums.sort()
    val list = mutableListOf<List<Int>>()
    for(i in 0 until nums.size) {
        if(i > 0 && nums[i - 1] == nums[i]) continue
        for(j in i + 1 until nums.size) {
            if(j > i + 1 && nums[j - 1] == nums[j]) continue

            var k = j + 1
            var l = nums.size - 1
            while ( k < l) {
                val sum: Long = nums[i].toLong() + nums[j] + nums[k] + nums[l]
                if(sum == target.toLong()) {
                    list.add(listOf(nums[i], nums[j], nums[k], nums[l]))
                    k++
                    l--
                    while(k < l && nums[k - 1] == nums[k]) k++
                    while(k < l && nums[l + 1] == nums[l]) l--
                }else if(sum > target) {
                    l--
                }else {
                    k++
                }
            }
        }
    }
    return list
}