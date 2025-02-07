package org.hit.collection

fun main() {
    val l2 = mutableListOf(1,2)
    val list = mutableListOf(1, 2, 3, 4, 5)
    val diff= list.size- l2.size
    var newList = list.subList(diff,list.size)
    println("sss" + newList.toString())
//    val list1 = list.subList(0,10)
//    println("list1 is $list1")
    val expectSize = 3;
    println(list.subList(list.size - expectSize, list.size))
    val ts = System.currentTimeMillis()
      val MILLI_SECOND_COUNT_ONE_DAY = 24 * 60 * 60 * 1000
    val stepDuration = 30*1000
    val index = ts  % MILLI_SECOND_COUNT_ONE_DAY / stepDuration
    println("index is $index , modify ${index+8*120}" )

    val config1 = RequestPredictConfig(false,"1",1L,2L)
    val config2 = RequestPredictConfig(false,"1",1L,2L,3L)
    println(Int.MAX_VALUE)
}

data class RequestPredictConfig(
    val enable: Boolean,                  //开关
    val bizTag: String,                  //业务标识，全局唯一
    var thresholdQuickResponse: Long,    //快速响应阈值，未完成ttfb且弱网时触发回调,ms
    var thresholdMaxWait: Long,          //最大等待阈值，未完成网络请求会触发回调,ms
    var thresholdTimeoutAsFail: Long = 10 * 1000 ,   //超时认做失败的阈值
)
