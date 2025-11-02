package array.easy

fun unionTwoSortedArray(arr1: Array<Int>, arr2: Array<Int>) {
    var i = 0
    var j = 0
    while(i < arr1.size && j < arr2.size) {
        if(arr1[i] < arr2[j]) {
            print(arr1[i])
            i++
        } else if(arr2[j] < arr1[i]){
            print(arr2[j])
            j++
        }else{
            print(arr1[i])
            i++; j++
        }
    }

    while (i < arr1.size){
        print(arr1[i])
        i++
    }
    while (j < arr2.size){
        print(arr2[j])
        j++
    }
}