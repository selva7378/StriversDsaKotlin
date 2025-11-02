package array.easy

fun zerosToEnd(arr: Array<Int>) {
    var i = 0
    var j = 0
    for( i in 0 until arr.size) {
        if(arr[i] != 0) {
            var temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            j++
        }
    }
}

