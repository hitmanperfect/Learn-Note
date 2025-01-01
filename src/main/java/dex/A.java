package dex;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class A {
     int a = 3;
     {
        new RuntimeException().printStackTrace();
         new Runnable(){
             @Override
             public void run() {
                 System.out.println(a);
             }
         };
    }

    public static void main(String[] args) {
        int[] s = new int[3];
        System.out.println(s.getClass());
    }

    void get(int c){
         int b = 3;
        new Runnable(){
            int b = 4;
            @Override
            public void run() {
                System.out.println(c);
            }
        };
    }
}
