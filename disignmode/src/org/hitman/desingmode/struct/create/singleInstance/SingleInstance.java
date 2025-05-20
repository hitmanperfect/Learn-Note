package org.hitman.desingmode.struct.create.singleInstance;

/***
 * 静态内部类，实现单例模式
 * 特点：懒加载，JVM内部保证只创建一个实例
 *
 */
public class SingleInstance {
    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    private static class SingleInstanceHolder {
        private static final SingleInstance INSTANCE = new SingleInstance();
    }

}
