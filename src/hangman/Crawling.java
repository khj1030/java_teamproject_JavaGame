package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {

	
	private static ObjectOutputStream outputStream_level1 = null;
	private static ObjectOutputStream outputStream_level2 = null;
	private static ObjectOutputStream outputStream_level3 = null;
	
//	private static final String dir = "C:\\Users\\김현지\\eclipse-workspace\\teamproject\\src\\";
	
	public static final String srcPath="src";
	public static final String packageName="hangman";
	
	private static String lavel1_fileName = "level1_word.dat";
	private static String lavel2_fileName = "level2_word.dat";
	private static String lavel3_fileName = "level3_word.dat";
	

	private static boolean check_null = false;
	
	private static ArrayList<String> level1_list = null;
	private static ArrayList<String> level2_list = null;
	private static ArrayList<String> level3_list = null;
	
	public static void main(String[] args) {
		
		level1_list = new ArrayList<String>();
		level2_list = new ArrayList<String>();
		level3_list = new ArrayList<String>();
		
//		String moodCheckFileName="fire6.gif";//이미지
		String currentProjPath="";
		try {
			currentProjPath=new File(".").getCanonicalPath();
		}catch(IOException e) {
			e.printStackTrace();
		}
		String filePath1= currentProjPath+"/"+srcPath+"/"+packageName+"/"+lavel1_fileName;
		String filePath2= currentProjPath+"/"+srcPath+"/"+packageName+"/"+lavel2_fileName;
		String filePath3= currentProjPath+"/"+srcPath+"/"+packageName+"/"+lavel3_fileName;
		
		
		try {
			outputStream_level1 = 
					new ObjectOutputStream(new FileOutputStream(filePath1));
			outputStream_level2 = 
					new ObjectOutputStream(new FileOutputStream(filePath2));
			outputStream_level3 = 
					new ObjectOutputStream(new FileOutputStream(filePath3));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		
		for(int i=1; i<=40; i+=2) {
			String url = "https://englishprofile.org/american-english?start="+(20*i);
			Document doc = null;   

			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Elements element = doc.select("#reportList > tbody");

			System.out.println("============================================================");
			
			Iterator<Element> ie1 = element.select("td").iterator();
			while (ie1.hasNext()) {
				
				String word = ie1.next().text();
				
				if(word.indexOf(" ") != -1) {
					check_null = true;
				}
				if(!check_null) {
					if(word.length() <= 5) {
						level1_list.add(word);
					} else if(5 < word.length() && word.length() <= 10) {
						level2_list.add(word);
					} else {
						level3_list.add(word);
					}
					
					System.out.print(word.length()+" " );
					System.out.println(word);
					
				}
				
				check_null = false;
				ie1.next();
				ie1.next();
				ie1.next();
				ie1.next();
				ie1.next();
			}
			
		}
		
		try {
			outputStream_level1.writeObject(level1_list);
			outputStream_level2.writeObject(level2_list);
			outputStream_level3.writeObject(level3_list);
			
			outputStream_level1.close();
			outputStream_level2.close();
			outputStream_level3.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}