package graph

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    var originalColor = image[sr][sc]
    if(originalColor == color) return image
    var queue = ArrayDeque<Pair<Int, Int>>()
    var directions = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
    queue.add(sr to sc)
    image[sr][sc] = color
    while(queue.isNotEmpty()) {
        val pos = queue.removeFirst()
        for(dir in directions) {
            val tr = pos.first + dir.first
            val tc = pos.second + dir.second
            if(tr >= 0 &&
                tr < image.size &&
                tc >= 0 &&
                tc < image[0].size &&
                image[tr][tc] == originalColor) {
                image[tr][tc] = color
                queue.add(tr to tc)
            }
        }
    }
    return image
}