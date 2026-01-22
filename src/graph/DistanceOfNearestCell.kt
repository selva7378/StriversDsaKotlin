package graph

fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size

    val ans = Array(m) { IntArray(n) }
    val queue = ArrayDeque<Pair<Int, Int>>()

    // Step 1: Initialize
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (mat[i][j] == 0) {
                ans[i][j] = 0
                queue.add(i to j)       // multi-source
            } else {
                ans[i][j] = -1         // unvisited
            }
        }
    }

    val directions = arrayOf(
        1 to 0, -1 to 0, 0 to 1, 0 to -1
    )

    // Step 2: BFS
    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()

        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy

            if (nx in 0 until m &&
                ny in 0 until n &&
                ans[nx][ny] == -1
            ) {
                ans[nx][ny] = ans[x][y] + 1
                queue.add(nx to ny)
            }
        }
    }

    return ans
}