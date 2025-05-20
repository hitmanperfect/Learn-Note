package org.hitman.desingmode.struct.create.factory.car

interface ICar {
    fun getName(): String
}

class Benchi: ICar{
    override fun getName() : String{
        return "benchi"
    }
}


class Baoma: ICar{
    override fun getName() : String{
        return "baoma"
    }
}