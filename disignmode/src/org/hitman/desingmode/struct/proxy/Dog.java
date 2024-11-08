package org.hitman.desingmode.struct.proxy;

public class Dog implements IBark{
    @Override
    public void bark(String msg) {
        System.out.println(msg);
    }
}
