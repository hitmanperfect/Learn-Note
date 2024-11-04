package org.hitman.desingmode.proxy;

public class Dog implements IBark{
    @Override
    public void bark(String msg) {
        System.out.println(msg);
    }
}
