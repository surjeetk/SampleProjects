package com.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//String stringLines=new String(Files.readAllBytes(Paths.get("K:/MyEclipseWorkspace/AdvJavaWorkspace/SampleFiles/Test1.txt")));
//			System.out.println(stringLines);
			
			
			Files.lines(Paths.get("K:/MyEclipseWorkspace/AdvJavaWorkspace/SampleFiles/Test1.txt"))
			.map(s->s+" hello")
			.filter(s->!s.isEmpty())
			.forEach(System.out::println);
			
			System.out.println("------");
	Files.readAllLines(Paths.get("K:/MyEclipseWorkspace/AdvJavaWorkspace/SampleFiles/Test1.txt"))
	.forEach(System.out::println);
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
