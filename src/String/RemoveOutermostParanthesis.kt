package String

fun main() {

}

fun removeOuterParentheses(s: String): String {
    var level = 0
    var res = ""
    for(letter in s) {
        if( letter == '(') {
            if (level > 0) {
                res += letter
            }
            level++
        } else if(letter  == ')') {
            level--
            if(level > 0) {
                res += letter
            }
        }
    }
    return res
}