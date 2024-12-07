package org.hitman.desingmode.struct.composite

import java.lang.StringBuilder

class CompositeDemo {
    val compenent = MyDirecotry("tmp")
    fun init() {
        compenent.add(MyFile("fileA"))
        compenent.add(MyDirecotry("directoryB"))
        compenent.add(MyFile("fileC"))
        compenent.add(MyDirecotry("directoryD"))
    }

    override fun toString(): String {
        val sb = StringBuilder()
        compenent.getAll()?.let {
            for (comp in it) {
                sb.append(comp.getName()).append(",")
            }
        }
        return sb.toString()
    }
}

fun main(){
    val demo = CompositeDemo()
    demo.init()
    println(demo.toString())
}