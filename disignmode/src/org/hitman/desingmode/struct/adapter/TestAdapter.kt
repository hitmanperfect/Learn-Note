package org.hitman.desingmode.struct.adapter

fun main(){
    testAdapter()
}

private fun testAdapter(){
    val advancePlayerA = object :IAdvanceMediaPlayer{
        override fun playVlc(url: String) {
            println("start play vlc : ${url}")
        }

        override fun playMkv(url: String) {
            println("start play mkv : ${url}")
        }
    }

    val advancePlayerB = AdvanceMediaPlayerAdapter(object :IMediaPlayer{
        override fun play(type: String, url: String) {
            println("start play, type is  ${type}, url is : ${url}")
        }
    })

    advancePlayerA.playVlc("aaaaaaaaa")
    advancePlayerA.playMkv("bbbbbbbbb")

    advancePlayerB.playVlc("aaaaaaaaa")
    advancePlayerB.playMkv("bbbbbbbbb")
}