package graph

fun numEnclaves(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    val vis = Array(rows) { BooleanArray(cols) }

    val direction = arrayOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1
    )

    // DFS from boundary
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    dfs(grid, vis, direction, i, j)
                }
            }
        }
    }

    // Count enclaves
    var res = 0
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == 1 && !vis[i][j]) {
                res++
            }
        }
    }

    return res
}

fun dfs(
    grid: Array<IntArray>,
    vis: Array<BooleanArray>,
    direction: Array<Pair<Int, Int>>,
    r: Int,
    c: Int
) {
    vis[r][c] = true

    for (dir in direction) {
        val tr = r + dir.first
        val tc = c + dir.second

        if (tr in grid.indices &&
            tc in grid[0].indices &&
            !vis[tr][tc] &&
            grid[tr][tc] == 1
        ) {
            dfs(grid, vis, direction, tr, tc)
        }
    }
}