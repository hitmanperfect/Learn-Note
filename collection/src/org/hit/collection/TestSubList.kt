package org.hit.collection

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5)
    println(list.subList(list.size - 3, list.size))
}