package cs3560Assignment1;
//@author: David Maestas
//Date last modified: 9/28/2020
//purpose: a class that is used to randomly generate student IDs 
//	out of strings.

import java.util.Random;

public class Student{
	

	//generates a random username for the student
	public static String generateName() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String nameID = "";
		Random r1 = new Random();
		char[] randLetters = new char[5];
		
		for(int i = 0; i < randLetters.length; i++) {
			randLetters[i] = alphabet.charAt(r1.nextInt(alphabet.length())); 
		}//end for
		
		for(int i = 0; i < randLetters.length; i++) {
			nameID += randLetters[i];
		}//end for
		
		return nameID;
	}//end generateName
	
	

	
}
