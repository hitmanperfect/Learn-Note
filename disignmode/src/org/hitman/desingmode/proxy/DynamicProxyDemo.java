package org.hitman.desingmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

interface IHelloWorld {
    void sayHelloWorld(String string);
}
class HelloWorld implements IHelloWorld{
    @Override
    public void sayHelloWorld(String string) {
        System.out.println(string);
    }
}

//切的是方法的执行，method粒度
/**
 * 面向切面：切的是方法的执行，method粒度
 * 使用场景，每个功能可以有个单独的代理，比如LoggerHandelr 主要是打印方法执行前后的日志，也可以有其他场景的代理
 * */


class LoggerHandler implements InvocationHandler {
    Object delegate;

    public LoggerHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Logger.beforeMethod(method);
        System.out.println("proxyInfo, class : " + proxy.getClass() + " ,supClass: " + proxy.getClass().getSuperclass() +
                " ,interfaces : " + Arrays.toString(proxy.getClass().getInterfaces()));
        System.out.println("args.size = " + args.length);
        System.out.println("methodInfo: paramsCount: " + method.getParameterCount());
        Object res = method.invoke(delegate, args);
        Logger.afterMethod(method);
        return res;
    }
}

public class DynamicProxyDemo {
    public static void main(String[] args) {
        testProxyHelloWorld();
//        testProxyBarK();
    }

    static void testProxyHelloWorld(){
        IHelloWorld delegate = new HelloWorld();
        LoggerHandler handler = new LoggerHandler(delegate);
        IHelloWorld proxy = (IHelloWorld)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),delegate.getClass().getInterfaces(),handler );
        proxy.sayHelloWorld("hello ,java !");
    }
}


