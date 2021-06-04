package javaQuiz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

public class TheoryResult{
	TreeSet<Student> ts = new TreeSet<Student>();	//����� ����
	
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;
	
	public TheoryResult(){
		fileInput();
	}
	
	public void fileOutput() {// ���Ͽ� ����
		try { 
			outputStream = new ObjectOutputStream(new FileOutputStream("theoryResult.dat"));
			outputStream.writeObject(this.ts);
			outputStream.close();
		}catch(IOException e) {
			
		}
	}
	
	public void fileInput() { //���� �б� + TreeSet�� ����
		try {
			inputStream = new ObjectInputStream(new FileInputStream("theoryResult.dat"));
			this.ts = (TreeSet<Student>) inputStream.readObject();
			inputStream.close();
		}catch(FileNotFoundException e) {

		}catch(IOException e) {

		} catch (ClassNotFoundException e) {

		}
	}
}