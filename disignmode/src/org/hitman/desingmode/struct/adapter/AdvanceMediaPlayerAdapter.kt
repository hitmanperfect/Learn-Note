package org.hitman.desingmode.struct.adapter


/**
 * A 需要适配成 B，对于命名，有几种常见例子
 * - 以被适配的名字命名，表名2者关系 AtoBAdapter  , 或者 BAdapterForA
 * - 以目标接口名， 比如 AdvanceMediaPlayerAdapter ，
 * -
 *
 * 最终需要什么，就适配成什么样子，A是被适配的对象，B是被适配以后的样子
 * */
class AdvanceMediaPlayerAdapter(val mediaPlayer: IMediaPlayer):IAdvanceMediaPlayer {
    override fun playVlc(url: String) {
        mediaPlayer.play("vlc","xxxx")
    }

    override fun playMkv(url: String) {
        println("sorry, the mkv type is not supported for IMediaPlayer ,url :  ${url}")
    }
}