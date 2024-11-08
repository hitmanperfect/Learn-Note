package org.hitman.desingmode.struct.proxy;

import java.lang.reflect.Method;

public class Logger {
    static void beforeMethod(Method m){
        System.out.println("before method: " + m.getName());
    }
    static void afterMethod(Method m){
        System.out.println("after method: " + m.getName());
    }
}
