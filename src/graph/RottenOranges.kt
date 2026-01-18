package graph

fun orangesRotting(grid: Array<IntArray>): Int {
    var rottenOranges = ArrayDeque<Pair<Int, Int>>()
    var totalOranges = 0
    var countRotten = 0
    var time = 0
    for(i in 0 until grid.size) {
        for(j in 0 until grid[0].size) {
            if(grid[i][j] != 0) totalOranges++
            if(grid[i][j] == 2) {
                rottenOranges.add(i to j)
            }
        }
    }

    var fourDirections = arrayOf(1 to 0, -1 to 0, 0 to -1, 0 to 1)

    while(rottenOranges.isNotEmpty()) {
        var k = rottenOranges.size
        countRotten += k

        for(i in 0 until k) {
            var pos = rottenOranges.removeFirst()
            for(dir in fourDirections) {
                var tempx = pos.first + dir.first
                var tempy = pos.second + dir.second
                if(tempx >= 0 && tempx < grid.size && tempy >= 0 && tempy < grid[0].size && grid[tempx][tempy] == 1) {
                    grid[tempx][tempy] = 2
                    rottenOranges.add(tempx to tempy)
                }
            }
        }

        if(rottenOranges.isNotEmpty()) time++
    }
    return if (totalOranges == countRotten) time else -1
}