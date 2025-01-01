fun main(args: Array<String>) {


    val ts = System.currentTimeMillis()
    val secondsOneDay = 24 * 60 * 60
    val dateIndex = ts / 1000 / secondsOneDay
    val seconds = (ts / 1000) % secondsOneDay
    val minIndex = seconds / 60
    val halfMinIndex = seconds / 30
    println("dateIndex:${dateIndex}, minIndex: ${minIndex}, halfIndex : ${halfMinIndex}")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")


    val list = mutableListOf(1, 2, 3, 4, 4, 5, 6, 6, 6, 7)
    println("before is ${list}")
    val iterator = list.iterator()
    while (iterator.hasNext()) {
        val next = iterator.next()
        if (next % 2 == 0) {
            iterator.remove()
        }
    }
    println("after is ${list}")
}