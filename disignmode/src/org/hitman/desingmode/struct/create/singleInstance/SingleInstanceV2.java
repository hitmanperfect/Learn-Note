package org.hitman.desingmode.struct.create.singleInstance;

/**
 * DCL （Double check lock ,双重检测锁）+ 懒汉式 实现单例
 * 1.为什么需要用volatile ? 保证可见性，禁止指令重排序，
 */
public class SingleInstanceV2 {
    private SingleInstanceV2() {
    }

    private static volatile SingleInstanceV2 INSTANCE;

    public static SingleInstanceV2 getInstance() {

        if (INSTANCE == null) {
            synchronized (SingleInstanceV2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingleInstanceV2();
                }
            }
        }
        return INSTANCE;
    }
}
