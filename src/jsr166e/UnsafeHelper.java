package jsr166e;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeHelper {
	
	public static Unsafe unsafe;
	static {
		Field f;
		try {
			f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Unsafe getUnsafe() {
		return unsafe;
	}
}
