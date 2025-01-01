package jjava.serialization;

import java.io.Serializable;

/**
 *
 */
public class SerializationDemo implements Serializable {
//    public static final long serialVersionUID = 1L;
    int a = 6;
    int b = 4;
//    transient int c = 5;

    void plus_i(){
        a = ++a;
    }
}
