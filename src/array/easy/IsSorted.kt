package array.easy

fun isSorted(arr: Array<Int>) : Boolean {
    for(i in 0..arr.size - 2) {
        if( arr[i] > arr[i+ 1]) return false
    }
    return true
}