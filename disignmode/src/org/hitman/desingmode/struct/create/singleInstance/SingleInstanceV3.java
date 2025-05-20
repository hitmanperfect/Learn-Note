package org.hitman.desingmode.struct.create.singleInstance;

/**
 * 饿汉式，early create mode
 * 和静态内部类对比缺点： 静态内部类是懒加载，而这个
 */
public class SingleInstanceV3 {
    private SingleInstanceV3() {
    }

    private static final SingleInstanceV3 INSTANCE = new SingleInstanceV3();

    public static SingleInstanceV3 getInstance() {
        return INSTANCE;
    }
}
