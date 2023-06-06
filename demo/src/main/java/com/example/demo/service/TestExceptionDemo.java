package com.example.demo.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

public class TestExceptionDemo {

	public static void main(String[] args) {
            try {
                demoException();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (JAXBException e) {
                System.out.println(e.getMessage());
            }
	}

	public static void demoException() throws IOException, FileNotFoundException, JAXBException{
		
	}
}