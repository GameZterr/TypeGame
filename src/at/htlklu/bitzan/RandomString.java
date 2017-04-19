package at.htlklu.bitzan;

import java.util.ArrayList;
import java.util.Random;

public class RandomString {
	private Random r = new Random();
	private String randomString = "a";
	public static int difficulty = 0;
	
	public void RandomString(){
		
	}
	public String generate(){
	if(difficulty == 2){
	String[] medium = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3","4","5","6","7","8","9"};
	return medium[r.nextInt(medium.length)];
	}
	if(difficulty == 0 || difficulty == 1) {
	String[] easy = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	return easy[r.nextInt(easy.length)];
	}
	if(difficulty == 3){
	String[] hard = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
			"@", "€", "-", "+", "#", "*", "~", "<", ">", "!", "°", "?", "&", "%", "µ", "=", ";",":"};
	return hard[r.nextInt(hard.length)];
	}
	if(difficulty == 4){
	String[] extreme = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
			"@", "€", "-", "+", "#", "*", "~", "<", ">", "!", "°", "?", "&", "%", "µ", "=", ";",":",
			"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",};
	return extreme[r.nextInt(extreme.length)];
	}
	return randomString;
	}

}
