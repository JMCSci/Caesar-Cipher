/* Caesar Cipher
 * Simple encryption technique
 * Shifts to the left
 */

package caesarcipher;

import java.util.Scanner;

public class CaesarCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int shift = 0;
		String text = "";
		title();
		shift = cipherShift(sc, shift);
		text = encode(sc, shift, text);
		decode(text, shift);
	}
	
	public static void title() {
		System.out.println("*---------------------------------*");
		System.out.println("|                                 |");
		System.out.println("|          CAESAR CIPHER          |");
		System.out.println("|                                 |");
		System.out.println("*---------------------------------*\n");
	}
	
	public static int cipherShift(Scanner sc, int shift) {
		boolean shiftValue = true;
		while(shiftValue) {
			System.out.print("Enter the length of shift: ");
			shift = sc.nextInt();
			sc.nextLine();		// Clear scanner -> goes to next line
			if(shift > 26) {	// Up to 26 shifts
				shiftValue = true;
				System.out.println("Invalid shift value\n");
				continue;
			}
			shiftValue = false;
		}
		return shift;
	}
	
	public static String encode(Scanner sc, int shift, String text) {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char [] arr = letters.toCharArray();
		StringBuilder encoded = new StringBuilder("");
		
		System.out.print("Enter text to encode: ");	
		text = sc.nextLine();
		text = text.toUpperCase();
		
		for(int i = 0; i < text.length(); i++) {
			int idx = letters.indexOf(text.charAt(i));
			if(text.charAt(i) == ' '){
				encoded.append(" ");
				continue;
			}
			
			if(Character.isDigit(text.charAt(i))){
				encoded.append(text.charAt(i));
				continue;
			}
			
			if(idx - shift < 0) {
				idx = letters.indexOf(text.charAt(i)) - shift;
				encoded.append(arr[(letters.length()) + idx]);
			} else {
				encoded.append(arr[idx - shift]);
			}
		}
		System.out.println("Encoded: " + encoded);
		sc.close();
		return encoded.toString();
	}
	
	public static String decode(String text, int shift) {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char [] arr = letters.toCharArray();
		StringBuilder decode = new StringBuilder("");
		
		for(int i = 0; i < text.length(); i++) {
			int idx = letters.indexOf(text.charAt(i));	// Find index of letter in char array
			if(text.charAt(i) == ' '){
				decode.append(" ");
				continue;
			}
			
			if(Character.isDigit(text.charAt(i))){
				decode.append(text.charAt(i));
				continue;
			}
		
			if(idx + shift > letters.length() - 1) {
				idx = letters.indexOf(text.charAt(i)) + shift;
				decode.append(arr[idx - letters.length()]);
			} else {
				decode.append(arr[idx + shift]);
			}
		}
		System.out.println("Decoded: " + decode.toString());
		return decode.toString();
	}

}
