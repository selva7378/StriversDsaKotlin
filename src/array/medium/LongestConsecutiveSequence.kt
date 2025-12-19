package array.medium

fun longestConsecutive(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    for(num in nums) {
        set.add(num)
    }
    var res = 0

    for(num in nums) {
        if(num - 1 !in set) {
            var temp = num
            var tempRes = 0
            while(temp in set){
                temp++
                tempRes++
            }
            if(tempRes > res) {
                res = tempRes
            }
        }
    }
    return res
}