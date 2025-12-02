package array.medium

fun main() {

}


fun maxProfit(prices: IntArray): Int {
    var bestBuy = Int.MAX_VALUE
    var profit = 0
    for(num in prices) {
        if (num < bestBuy) {
            bestBuy = num
            continue
        }

        val tempProfit = num - bestBuy

        if (tempProfit > profit) {
            profit = tempProfit
        }
    }
    return profit
}