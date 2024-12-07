package org.hitman.desingmode.struct.bridge

abstract class Shape {
    abstract fun getName(): String
}

class Rectangle : Shape() {
    override fun getName(): String {
        return "rectangle"
    }
}

class Circle : Shape() {
    override fun getName(): String {
        return "circle"
    }
}