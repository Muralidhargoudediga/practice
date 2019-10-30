package org.mge.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		FileOutputStream fos = new FileOutputStream("myB.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		A a = new A();
//		a.a = 10;
//		a.s = "murali";
//		oos.writeObject(a);
		
		FileInputStream fis = new FileInputStream("myB.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		A a1 = (A) ois.readObject();
		a1.show();
		
		//oos.close();
		ois.close();
	}
}
