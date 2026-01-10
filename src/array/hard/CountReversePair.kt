package array.hard

fun main () {
    var arr1 = intArrayOf(1,3,2,3,1)
    var arr2 = intArrayOf(3,2,1,4)
    var arr3 = intArrayOf(5,3,2,1,4)
    println(mergeSort(arr1, 0, arr1.size-1))
    println(mergeSort(arr2, 0, arr2.size-1))
    println(mergeSort(arr3, 0, arr3.size-1))
}
private fun mergeSort(nums: IntArray, low: Int, high: Int): Int {
    var count = 0
    if(low >= high) return count
    var mid = (low + high) / 2
    count += mergeSort(nums, low, mid)
    count += mergeSort(nums, mid+1, high)
    count += countReversePairs(nums, low, mid, high)
    merge(nums, low, mid, high)
    return count
}

fun countReversePairs(nums: IntArray, low: Int, mid: Int, high: Int): Int {
    var res = 0
    var right = mid + 1
    for(i in low..mid) {
        while(right <= high && nums[i] > (2L * nums[right]).toLong()) right++
        res += (right - (mid + 1))
    }
    return res
}

private fun merge(arr: IntArray, low: Int, middle: Int, high: Int) {
    var temp = Array(high - low + 1) {0}
    var left = low
    var right = middle + 1
    var k = 0

    while (left <= middle && right <= high) {
        if (arr[left] <= arr[right]) {
            temp[k++] = arr[left++]
        }else {
            temp[k++] = arr[right++]
        }
    }

    while (left <= middle) {
        temp[k++] = arr[left++]
    }

    while (right <= high) {
        temp[k++] = arr[right++]
    }

    left = low
    while (left <= high) {
        arr[left] = temp[left - low]
        left++
    }

}