package org.hitman.desingmode.struct.facade

fun main(){

    testFacade()
}

fun testFacade(){
    UtilFacade.writeLog("this is test log str")
    UtilFacade.track("this is test track str")

    UtilFacade.writeDb("this is test db str")

}