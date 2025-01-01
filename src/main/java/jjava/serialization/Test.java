package jjava.serialization;

import jjava.TestClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 */
public class Test {
    static String filePath = "./src/jjava/serialization/cache_v1.txt";

    public static void main(String[] args) {
	  try {
//		generateFileFromObject();
		genetareObjectFromFile();
	  } catch (Exception e) {
		e.printStackTrace();
	  }
    }

    private static void generateFileFromObject() {
	  try {
		SerializationDemo demo = new SerializationDemo();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(demo);
		oos.flush();
	  } catch (Exception e) {
		e.printStackTrace();
	  }
    }

    private static void genetareObjectFromFile() {
	  try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		SerializationDemo demo =(SerializationDemo) ois.readObject();
		System.out.println(demo.a);
//		System.out.println(demo.b);

	  } catch (Exception e) {
	      e.printStackTrace();
	  }

    }
}