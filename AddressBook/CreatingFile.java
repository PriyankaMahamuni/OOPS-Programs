package com.bridgeit.ObjectOrintedPrograming.AddressBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
public class CreatingFile extends FileOpearation {
	public static List<Person> personList = null;
	public static ObjectMapper objectmapper=new ObjectMapper();

	public static void setList(List<Person> personList) {
		CreatingFile.personList = personList;
	}

	public static List<Person> getList() {
		return personList;
	}

	public static File createNewFile(String fileName, String fileExtension) {
		File file = FileOpearation.getPathOfFile(fileName, fileExtension);
		try {
			@SuppressWarnings({ "unused", "resource" })
			FileWriter newFileWritten = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return file;
	}
}