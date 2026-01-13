package array.hard

fun main() {
    print(maxProduct(intArrayOf(1,2,3,4,5,0)))
    print(maxProduct(intArrayOf(1,2,-3,0,-4,-5)))
}

fun maxProduct(nums: IntArray): Int {
    var res = Int.MIN_VALUE
    var pref = 1
    var suf = 1
    for(i in 0..(nums.size - 1)) {
        if(pref == 0) pref = 1
        if(suf == 0) suf = 1
        pref *= nums[i]
        suf *= nums[nums.size - 1 - i]
        res = maxOf(res, pref, suf)
    }
    return res
}