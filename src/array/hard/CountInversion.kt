package array.hard


fun main() {
    var arr1 = intArrayOf(1, 2, 3, 4, 5)
    var arr2 = intArrayOf(5,4,3,2,1)
    var arr3 = intArrayOf(5,3,2,1,4)
    println(mergeSort(arr1, 0, arr1.size-1))
    println(mergeSort(arr2, 0, arr2.size-1))
    println(mergeSort(arr3, 0, arr3.size-1))
}

fun mergeSort(arr: IntArray, low: Int, high: Int): Int {
    var count = 0
    if (low >= high) return count
    val middle = (low + high) / 2
    count += mergeSort(arr, low, middle)
    count += mergeSort(arr, middle + 1, high)
    count+= merge(arr, low, middle, high)
    return count
}

fun merge(arr: IntArray, low: Int, middle: Int, high: Int): Int {
    var temp = Array(high - low + 1) {0}
    var left = low
    var right = middle + 1
    var k = 0
    var count = 0

    while (left <= middle && right <= high) {
        if (arr[left] <= arr[right]) {
            temp[k++] = arr[left++]
        }else {
            temp[k++] = arr[right++]
            count += (middle - left + 1)
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

    return count
}