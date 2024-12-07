package org.hitman.desingmode.struct.facade

object UtilFacade {

    fun writeLog(logStr:String){
        log.log(logStr)
    }
    fun track(trackStr:String){
        track.track(trackStr)
    }
    fun writeDb(dbStr:String){
        db.writeDb(dbStr)
    }
}