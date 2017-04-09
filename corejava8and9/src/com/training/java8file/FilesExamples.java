package com.training.java8file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesExamples {
	
	public static void main(String[] args)  {
		// create dir
		Path path = Paths.get("data/subdir");

		try {
		    Path newDir = Files.createDirectory(path);
		} catch(FileAlreadyExistsException e){
		   e.printStackTrace();
		} catch (IOException e) {
		   e.printStackTrace();
		}
		
		// copy
		Path sourcePath      = Paths.get("data/logging.properties");
		Path destinationPath = Paths.get("data/logging-copy.properties");

		try {
		    Files.copy(sourcePath, destinationPath);
		} catch(IOException | NullPointerException e) {
		    
		   e.printStackTrace();
		}
		
		// move 
		Path sourcePathOne      = Paths.get("data/logging-copy.properties");
		Path destinationPathOne = Paths.get("data/subdir/logging-moved.properties");

		try {
		    Files.move(sourcePathOne, destinationPathOne,
		            StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
		    //moving file failed.
		    e.printStackTrace();
		}
		
		// file write
		//Get the file reference
		Path pathOne = Paths.get("c:/output.txt");
		 
		//Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(pathOne)) 
		{
		    writer.write("Hello World !!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String content = "Hello World !!";
		try {
			Files.write(Paths.get("c:/output.txt"), content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Listin files
		try (Stream<Path> stream = Files.list(Paths.get(""))) {
		    String joined = stream
		        .map(String::valueOf)
		        .filter(pathTwo -> !pathTwo.startsWith("."))
		        .sorted()
		        .collect(Collectors.joining("; "));
		    System.out.println("List: " + joined);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// read lines
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get("res/nashorn1.js"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		// memory efficient read 
		try (Stream<String> stream = Files.lines(Paths.get("res/nashorn1.js"))) {
		    stream
		        .filter(line -> line.contains("print"))
		        .map(String::trim)
		        .forEach(System.out::println);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
