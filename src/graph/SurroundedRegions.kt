package graph

fun solve(board: Array<CharArray>) {
    if (board.isEmpty()) return

    val rows = board.size
    val cols = board[0].size

    val vis = Array(rows) { BooleanArray(cols) }
    val direction = arrayOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1
    )

    // Run DFS from boundary 'O's
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    dfs(board, vis, direction, i, j)
                }
            }
        }
    }

    // Flip remaining unvisited 'O's
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (!vis[i][j] && board[i][j] == 'O') {
                board[i][j] = 'X'
            }
        }
    }
}

fun dfs(
    board: Array<CharArray>,
    vis: Array<BooleanArray>,
    direction: Array<Pair<Int, Int>>,
    r: Int,
    c: Int
) {
    vis[r][c] = true

    for (dir in direction) {
        val tr = r + dir.first
        val tc = c + dir.second

        if (tr in board.indices &&
            tc in board[0].indices &&
            !vis[tr][tc] &&
            board[tr][tc] == 'O'
        ) {
            dfs(board, vis, direction, tr, tc)
        }
    }
}