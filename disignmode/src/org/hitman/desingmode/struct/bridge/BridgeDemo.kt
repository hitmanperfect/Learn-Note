package org.hitman.desingmode.struct.bridge

class BridgeDemo {
    fun test(){
        val circle = Circle()
        val rectangle = Rectangle()
        val redDraw = RedDraw()
        val greenDraw = GreenDraw()
        redDraw.draw(circle)
        redDraw.draw(rectangle)
        greenDraw.draw(circle)
        greenDraw.draw(rectangle)
    }
}

fun main(){
    val bridgeDemo = BridgeDemo()
    bridgeDemo.test()
}