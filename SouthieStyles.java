// Arafat Rahaman
// March 14, 2022
// Assignment 7. Southie Styles
				
/*
	This program will take in and read a text file that contains the script to Jaws
	the movie and output a new text file that contains the southie-style version of it.
*/

import java.util.Scanner;
import java.io.*;
public class SouthieStyles {
	
	public static Boolean LenVowWickCheck(String word) {
		word = word.toLowerCase();
		if (word.length() == 1) {
			return true;
		} else if (word.equals("wicked")) {
			return true;
		}else if (word.equals("Wicked")) {
			return true;	
		} else if (word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u")) {
			return true;
		} else {
			return true;
		}
	}
	
	
	public static String wordTranslator(String word) {
		
		if (word.equals("a") || word.equals("A") || word.equals("I") || word.equals("wicked") || word.equals("Wicked") || word.equals("WICKED")) {
			return word;
		}
		
		if (word.equals("very")) {
			return "wicked";
		}else if (word.equals("Very")) {
			return ("Wicked");
		}else if (word.equals("VERY")) {
			return ("WICKED");
		}
		
		
		if (word.length() > 2 && (word.charAt(word.length()-1) == 'r') && (word.charAt(word.length()-2) == 'e') && (word.charAt(word.length()-3) == 'e')){
			word = word.substring(0, word.length()-1) + "yah";
		} else if (word.length() >2 && (word.charAt(word.length()-1) == 'r') && (word.charAt(word.length()-2) == 'i')) {
			word = word.substring(0, word.length()-1) + "yah";
		} else if (word.length() >2 && (word.charAt(word.length()-1) == 'r') && (word.charAt(word.length()-2) == 'o') && (word.charAt(word.length()-3) == 'o')){
			word = word.substring(0, word.length()-1) + "wah";
		}
		
		// Takes care all of the fully capitalized words
		if (word.length() > 2 && (word.charAt(word.length()-1) == 'R') && (word.charAt(word.length()-2) == 'E') && (word.charAt(word.length()-3) == 'E')){
			word = word.substring(0, word.length()-1) + "YAH";
		} else if (word.length() >2 && (word.charAt(word.length()-1) == 'R') && (word.charAt(word.length()-2) == 'I')) {
			word = word.substring(0, word.length()-1) + "YAH";
		} else if (word.length() >2 && (word.charAt(word.length()-1) == 'R') && (word.charAt(word.length()-2) == 'O') && (word.charAt(word.length()-3) == 'O')){
			word = word.substring(0, word.length()-1) + "WAH";
		}
		
		// Capital + Lower Case A
		if (word.contains("ar")) {
			word = word.replace("ar", "ah");
		}
		
		if (word.contains("Ar")) {
			word = word.replace("Ar", "Ah");
		}
		
		if (word.contains("AR")) {
			word = word.replace("AR", "AH");
		}
		
		// Capital + Lower Case E
		if (word.contains("er")) {
			word = word.replace("er", "eh");
		}
		
		if (word.contains("Er")) {
			word = word.replace("Er", "Eh");
		}
		
		if (word.contains("ER")) {
			word = word.replace("ER", "EH");
		}
		
		// Capital + Lower Case I
		if (word.contains("ir")) {
			word = word.replace("ir", "ih");
		}
		
		if (word.contains("Ir")) {
			word = word.replace("Ir", "Ih");
		}
		
		if (word.contains("IR")) {
			word = word.replace("IR", "IH");
		}
		
		// Capital + Lower Case O
		if (word.contains("or")) {
			word = word.replace("or", "oh");
		}
		
		if (word.contains("Or")) {
			word = word.replace("Or", "Oh");
		}
		
		if (word.contains("OR")) {
			word = word.replace("OR", "OH");
		}
		
		// Capital + Lower Case U
		if (word.contains("ur")) {
			word = word.replace("ur", "uh");
		}
		
		if (word.contains("Ur")) {
			word = word.replace("Ur", "Uh");
		}
		
		if (word.contains("UR")) {
			word = word.replace("UR", "UH");
		}		
		
		// Word Ends with A, ordered here thus tunar won't change to tunah
		if (word.charAt(word.length()-1) == 'a') {
			word = word + "r";
		}
		
		if (word.charAt(word.length()-1) == 'A') {
			word = word + "R";
		}
		
		return word;
	}

	
	
	public static String changeLine(String Line) {
		String newLine = "";
		
		Scanner lineScanner = new Scanner (Line);
		
		while (lineScanner.hasNext()) {
			String word = lineScanner.next();
			
			if (word.contains(".")) {
					newLine = newLine + wordTranslator(word.substring(0, word.length()-1)) + ". ";
			} else {
					newLine = newLine + wordTranslator(word) + " ";
			}	
		}
		
		return newLine;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner script = new Scanner (new File ("JawsScript.txt"));
		PrintWriter outToFile = new PrintWriter (new File ("SouthieJawsScript.txt"));
		
		while (script.hasNextLine()) {
			String line = script.nextLine();
			outToFile.println(changeLine(line));
		}
		outToFile.close();
		
	}

}