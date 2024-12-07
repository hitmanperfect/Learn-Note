package org.hitman.desingmode.struct.facade

interface ILog {
    fun log(str:String)
}

interface ITrack {
    fun track(str:String)

}

interface IDb {
    fun writeDb(str:String)
}

val log = object :ILog{
    override fun log(str: String) {
        println("log : ${str}")
    }
}

val track = object :ITrack{
    override fun track(str: String) {
        println("track : ${str}")
    }
}

val db = object :IDb{
    override fun writeDb(str: String) {
        println("writeDb : ${str}")
    }
}