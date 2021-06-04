package javaQuiz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

public class LabResult{
	TreeSet<Student> ts = new TreeSet<Student>(); //사용자 정보
	
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;
	
	public LabResult(){
		fileInput();
	}
	
	public void fileOutput() {// 파일에 쓰기
		try { 
			outputStream = new ObjectOutputStream(new FileOutputStream("labResult.dat"));
			outputStream.writeObject(this.ts);
			outputStream.close();
			
		}catch(IOException e) {
			System.err.println("Problem with file output.");
		}
	}
	
	public void fileInput() {//파일 읽기 + TreeSet에 저장
		try {
			inputStream = new ObjectInputStream(new FileInputStream("labResult.dat"));
			this.ts = (TreeSet<Student>) inputStream.readObject();
			inputStream.close();
		}catch(FileNotFoundException e) {

		}catch(IOException e) {

		} catch (ClassNotFoundException e) {
			
		}
	}
}