import kotlin.random.Random

object var9 {
    fun randomArray(n: Int): Array<Int> {
        val array = Array<Int>(n) { 0 }
        for (id in array.indices) {
            array[id] = Random.nextInt(4)
        }
        return array
    }

    fun customArray(array: Array<Int>): Array<Int> {
        var newArray = emptyArray<Int>()
        //val newArray = Array<Int>(n) { 0 }
        var j = 0
        for (i in array.indices) {
            if (array[i] == 0) {
                newArray += i
                j++
            }
        }
        return newArray
    }
}