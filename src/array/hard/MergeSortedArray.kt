package array.hard

fun main() {
    var nums1 = intArrayOf(1,2,3,0,0,0)
    var nums2 = intArrayOf(2,5,6)
    merge(nums1, nums1.size - nums2.size, nums2, nums2.size)
    println(nums1.contentToString())
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1
    while(i >= 0 && j >= 0) {
        if(nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--]
        } else {
            nums1[k--] = nums2[j--]
        }
    }

    while(j >= 0) {
        nums1[k--] = nums2[j--]
    }
}