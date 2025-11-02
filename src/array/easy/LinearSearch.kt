package array.easy

fun linearSearch(arr: Array<Int>, num: Int): Int {
    for(i in 0 until arr.size){
        if(arr[i] == num){
            return i
        }
    }
    return -1
}