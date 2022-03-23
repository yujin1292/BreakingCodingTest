class Solution {

    val dc = intArrayOf(0, 1, -1)
    val dr = intArrayOf(1, 0, -1)

    fun solution(n: Int): IntArray {
        var answer = mutableListOf<Int>()
        val triangle = Array(n+1){Array(n+1){0} }
        var size = n
        var number = 0
        var row = 0
        var col = 1

        repeat(n) {
            val direction = it % 3
            repeat(size) {
                row +=dr[direction]
                col +=dc[direction]
                number++

                triangle[row][col] = number
            }
            size--
        }

        for( i in 1 .. n){
            for ( j in 1..i){
                answer.add(triangle[i][j])
            }
        }

        return answer.toIntArray()
    }
}