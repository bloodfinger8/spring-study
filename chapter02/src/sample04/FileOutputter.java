package sample04;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath, fileName;
	
	public FileOutputter() {
		System.out.println("FileOutputter 기본 생성자");
	}
	
	public void setFilePath(String filePath) {
		System.out.println("setFilePath method");
		this.filePath = filePath;
	}
	public void setFileName(String fileName) {
		System.out.println("setFileName method");
		this.fileName = fileName;
	}

	@Override
	public void output(String message) {
		System.out.println("output method");
		try {
			FileWriter fileWriter = new FileWriter(filePath+fileName);
			fileWriter.write(message);
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
