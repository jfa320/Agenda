package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class mainprueba 
{
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties p = new Properties();
		p.load(new FileReader("C:\\acceso.properties"));
		System.out.println(p);
			
	}

}
