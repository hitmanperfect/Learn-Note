package jjava.mem_layout;

import org.openjdk.jol.info.ClassLayout;

/**
 *
 */
public class JOLTest {
    int i1;
    int i2;
    byte b1;
    byte b2;
    byte b3;
    byte b4;
    short s1;
    short s2;
    long l1;
    long l2;


    public static void main(String[] args) {
	  System.out.println(ClassLayout.parseInstance(new JOLTest()).toPrintable());
    }
}
