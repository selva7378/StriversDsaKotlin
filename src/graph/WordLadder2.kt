package graph
// This solution doesn't work on leetcode
fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    val queue = ArrayDeque<MutableList<String>>()
    val visitedWordsByLevel = mutableListOf<String>()
    val set = wordList.toMutableSet()
    var level = 0
    val ans = mutableListOf<List<String>>()
    queue.add(mutableListOf(beginWord))
    visitedWordsByLevel.add(beginWord)
    while(queue.isNotEmpty()) {
        val wordList = queue.removeFirst()

        if(wordList.size > level) {
            level++
            for(word in visitedWordsByLevel) {
                set.remove(word)
            }
        }
        val currWord = wordList[wordList.size - 1]

        if(currWord == endWord) {
            if(ans.isEmpty()) {
                ans.add(wordList)
            }else if(ans[0].size == wordList.size) {
                ans.add(wordList)
            }
        }

        val arr = currWord.toCharArray()
        for(i in 0 until arr.size) {
            val original = arr[i]
            for(j in 'a'..'z') {
                arr[i] = j
                val newWord = String(arr)
                if(set.contains(newWord)) {
                    visitedWordsByLevel.add(newWord)
                    wordList.add(newWord)
                    queue.add(wordList.toMutableList())
                    wordList.removeAt(wordList.size - 1)
                }
            }
            arr[i] = original
        }
    }
    return ans
}