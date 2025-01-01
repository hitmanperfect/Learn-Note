package jjava.mem_layout;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteOrder;

public class EndianTest {
    public static void main(String[] args) {
	  try {
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		Unsafe UNSAFE = (Unsafe) theUnsafe.get(null);
		long a = UNSAFE.allocateMemory(4);
		UNSAFE.putInt(a, 0x01020304);
		//存放此int类型数据，实际存放占4个字节，01,02,03，04
		byte b = UNSAFE.getByte(a);
		//通过getByte方法获取刚才存放的int，取第一个字节
		//如果是大端，int类型顺序存放—》01,02,03,04  ，取第一位便是0x01
		//如果是小端，int类型顺序存放—》04,03,02,01  ，取第一位便是0x04
		ByteOrder byteOrder = null;
		switch (b) {
		    case 0x01:
			   byteOrder = ByteOrder.BIG_ENDIAN;
			  break;
		    case 0x04:
			  byteOrder = ByteOrder.LITTLE_ENDIAN;
			  break;
		    default:
			  assert false;
			  byteOrder = null;
		}
		System.out.println(byteOrder);
	  } catch (Exception e) {
	      e.printStackTrace();
	  }

    }

}
