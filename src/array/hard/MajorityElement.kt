package array.hard

// n/3 times

fun majorityElement(nums: IntArray): List<Int> {
    var ele1 = 0
    var ele2 = 0
    var vote1 = 0
    var vote2 = 0
    val list = mutableListOf<Int>()
    for(num in nums) {
        if(num != ele2 && vote1 == 0) {
            ele1 = num
            vote1++
        } else if(num != ele1 && vote2 == 0) {
            ele2 = num
            vote2++
        } else if(num == ele1) {
            vote1++
        } else if(num == ele2) {
            vote2++
        }else {
            vote1--
            vote2--
        }
    }

    var count1 = 0
    var count2 = 0
    for(num in nums) {
        if(ele1 == num) {
            count1++
        }
        if(ele2 == num) {
            count2++
        }
    }
    if(count1 > nums.size / 3) {
        list.add(ele1)
    }
    if(ele1 != ele2) {
        if(count2 > nums.size / 3) {
            list.add(ele2)
        }}
    return list
}