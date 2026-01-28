package graph

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {

    val set = mutableSetOf<String>()
    for (word in wordList) set.add(word)

    if (!set.contains(endWord)) return 0

    val queue = ArrayDeque<Pair<String, Int>>()
    queue.add(beginWord to 1)

    while (queue.isNotEmpty()) {
        val (word, steps) = queue.removeFirst()

        if (word == endWord) return steps

        val arr = word.toCharArray()

        for (i in arr.indices) {
            val original = arr[i]

            for (ch in 'a'..'z') {
                if (ch == original) continue

                arr[i] = ch
                val newWord = String(arr)

                if (set.contains(newWord)) {
                    queue.add(newWord to steps + 1)
                    set.remove(newWord) // 🔥 very important
                }
            }

            arr[i] = original // restore
        }
    }

    return 0
}