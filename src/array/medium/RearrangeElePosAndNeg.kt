package array.medium

fun main() {

}

fun rearrangeArray(nums: IntArray): IntArray {
    val arr = IntArray(nums.size) {0}
    var pInd = 0
    var nInd = 1
    for (i in 0 until nums.size) {
        if (nums[i] < 0) {
            arr[nInd] = nums[i]
            nInd += 2
        } else {
            arr[pInd] = nums[i]
            pInd += 2
        }
    }
    return arr
}