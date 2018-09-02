package com.java8;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Misc {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String str=String.join(",", "Harry","Larry","Suresh");
		System.out.println(str);
		
		
		StringJoiner sj=new StringJoiner(",","{","}");
		
		sj.setEmptyValue("No values set yet");
		System.out.println(sj);
		
		sj.add("Rupesh")
		.add("Ramesh")
		.add("Prabhu");
		System.out.println(sj);
		
		System.out.println(System.getProperty("user.dir"));
		//File as stream
		/*Path filePath=FileSystems.getDefault().
				getPath("K:\\MyEclipseWorkspace\\AdvJavaWorkspace\\SampleJavaProject\\src\\sampleFile.txt");*/
		
		Path filePath=Paths.get("src","files","sample.txt");
		String searchTerm="fourth";
		
		try(Stream<String> lines=Files.lines(filePath)){
			
			Optional<String> line=lines.filter(l->l.contains(searchTerm)).findFirst();
			
			if(line.isPresent()){
				System.out.println("Found:"+line.get());
			}
			else{
				System.out.println("Not Found");
			}
			
		} 
		
				
	}

}
