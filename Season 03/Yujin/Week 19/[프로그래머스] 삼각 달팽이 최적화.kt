class Solution {

    val dc = intArrayOf(0, 1, -1)
    val dr = intArrayOf(1, 0, -1)

    fun solution(n: Int): IntArray {
        val triangle = IntArray(n*(n+1)/2){0}
        var size = n
        var number = 0
        var row = 0
        var col = 0

        repeat(n) {
            val direction = it % 3
            repeat(size) {
                row +=dr[direction]
                col +=dc[direction]
                number++

                triangle[((row-1)*row/2) + col] = number
            }
            size--
        }

        return triangle
    }
}