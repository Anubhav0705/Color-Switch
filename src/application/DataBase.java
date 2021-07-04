package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataBase {
	
	
	public static void serialize() throws FileNotFoundException, IOException
	 {
		 SavedGame1 saveGame =new SavedGame1();
		 ObjectOutputStream out=null;
		 try {
			 out=new ObjectOutputStream(new FileOutputStream("out.txt"));
			 out.writeObject(saveGame);
		 }
		 finally {
			 out.close();
		 }
	 }
	 
	 public static void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		 ObjectInputStream in =null;
		 try {
			 in=new ObjectInputStream(new FileInputStream("out.txt"));
			 SavedGame1 saveGame=(SavedGame1)in.readObject();
		 }
		 finally {
			 in.close();
		 }
	 }

}
