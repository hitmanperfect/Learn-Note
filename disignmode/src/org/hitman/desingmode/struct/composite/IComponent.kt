package org.hitman.desingmode.struct.composite

import java.lang.RuntimeException


interface IComponent {
    fun getName(): String
    fun add(component: IComponent)
    fun remove(component: IComponent)
    fun get(index: Int): IComponent?
    fun getAll():List<IComponent>?
}

class MyFile(val mName: String) : IComponent {
    override fun getName(): String {
        return mName
    }

    override fun add(component: IComponent) {
        println("error: FileComponent can not add component")
    }

    override fun remove(component: IComponent) {
        println("error: FileComponent can not remove component")
    }

    override fun get(index: Int): IComponent? {
        println("error: FileComponent can not get component")
//        throw RuntimeException("error: FileComponent can not get component")
        return null
    }

    override fun getAll(): List<IComponent>? {
        println("error: FileComponent can not getAll")
        return null
//        TODO("Not yet implemented")
    }
}

class MyDirecotry(val mName:String):IComponent{
    private val arrarList = mutableListOf<IComponent>()
    override fun getName(): String {
        return mName
    }

    override fun add(component: IComponent) {
        arrarList.add(component)
    }

    override fun remove(component: IComponent) {
        arrarList.remove(component)
    }

    override fun get(index: Int): IComponent {
        if (index>=arrarList.size) {
            throw RuntimeException("error: index :${index}, listSize ：${arrarList.size}")
        }else{
            return arrarList[index]
        }
    }

    override fun getAll(): List<IComponent>? {
        return arrarList
    }
}