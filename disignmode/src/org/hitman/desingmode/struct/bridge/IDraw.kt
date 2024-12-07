package org.hitman.desingmode.struct.bridge

interface IDraw {
    fun draw(shape: Shape)
}

class RedDraw : IDraw {
    override fun draw(shape: Shape) {
        println("draw with red color: ${shape.getName()}")
    }
}

class GreenDraw : IDraw {
    override fun draw(shape: Shape) {
        println("draw with green color: ${shape.getName()}")
    }
}