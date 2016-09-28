package com.codiscope.jaks.triggers.java.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadAllLine {

	public static void main(String[] args) {

	    Path wiki_path = Paths.get("C:/tutorial/wiki", "wiki.txt");

	    Charset charset = Charset.forName("ISO-8859-1");
	    try {
	      List<String> lines = Files.readAllLines(wiki_path, charset);

	      for (String line : lines) {
	        System.out.println(line);
	      }
	    } catch (IOException e) {
	      System.out.println(e);
	    }

	  }
}
