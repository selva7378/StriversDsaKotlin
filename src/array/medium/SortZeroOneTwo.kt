package array.medium

fun main() {
    var arr1 = arrayOf(2,0,2,1,1,0)
    var arr2 = arrayOf(2,0,1)
    sortZeroOneTwo(arr1)
    sortZeroOneTwo(arr2)
    print(arr1.contentToString())
    print(arr2.contentToString())
}

fun sortZeroOneTwo(arr: Array<Int>) {
    var low = 0
    var mid = 0
    var high = arr.size - 1
    while (mid <= high) {
        when (arr[mid]) {
            0 -> {
                swap(arr, low, mid)
                low++
                mid++
            }
            1 -> mid++
            2 -> {
                swap(arr, mid, high)
                high--
            }
        }
    }
}

fun swap(arr: Array<Int>, i: Int, j: Int) {
    var temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}