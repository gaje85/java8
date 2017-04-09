package com.training.java8file;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExamples {
	
	public static void main(String[] args) {
		Path path = Paths.get("c:\\data\\myfile.txt");
		Path projects = Paths.get("d:\\data", "projects");
	}

}
