package array.hard

fun main() {

}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val res = mutableListOf<IntArray>()
    sort(intervals)
    var currentStart = intervals[0][0]
    var currentEnd = intervals[0][1]
    for(i in 1 until intervals.size) {
        val start = intervals[i][0]
        val end = intervals[i][1]
        if(currentEnd >= start) {
            currentEnd = maxOf(currentEnd, end)
        }else {
            res.add(intArrayOf(currentStart, currentEnd))
            currentStart = start
            currentEnd = end
        }
    }
    res.add(intArrayOf(currentStart, currentEnd))
    return res.toTypedArray()
}

fun sort(intervals: Array<IntArray>) {
    for(i in 0 until intervals.size) {
        for(j in 0 until (intervals.size - i - 1)) {
            if(intervals[j][0] > intervals[j+1][0]){
                val temp = intervals[j]
                intervals[j] = intervals[j+1]
                intervals[j+1] = temp
            }
        }
    }
}