package array.easy

fun removeDuplicates(arr: Array<Int>) : Unit {
    var j = 0
    for (i in 0..arr.size-1) {
        if(arr[i] != arr[j]){
            j++
            val temp = arr[j]
            arr[j] = arr[i]
            arr[i] = temp
        }
    }
}