package array.easy

fun leftRotateArray(arr: Array<Int>, noOfPosition: Int) {
    reverse(arr, 0, noOfPosition - 1)
    reverse(arr, noOfPosition, arr.size - 1)
    reverse(arr, 0, arr.size - 1)
}

fun reverse(arr: Array<Int>, start: Int, end: Int ) {
    var start = start
    var end = end
    while (start < end){
        var temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp
        start++; end--
    }
}