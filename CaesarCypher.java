/* Caesar Cipher
 * Simple encryption technique
 */

package caesarcipher;

import java.util.Scanner;

public class CaesarCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int shift = 0;
		title();
		shift = cipherShift(sc, shift);
		encode(sc, shift);
	}
	
	public static void title() {
		System.out.println("*---------------------------------*");
		System.out.println("|                                 |");
		System.out.println("|          CAESAR CYPHER          |");
		System.out.println("|                                 |");
		System.out.println("*---------------------------------*\n");
	}
	
	public static int cipherShift(Scanner sc, int shift) {
		System.out.print("Enter the length of shift: ");
		shift = sc.nextInt();
		sc.nextLine();	// Clear scanner -> goes to next line
		return shift;
	}
	
	public static void encode(Scanner sc, int shift) {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char [] arr = letters.toCharArray();
		StringBuilder encoded = new StringBuilder("");
		
		System.out.print("Enter text to encode: ");	
		String text = sc.nextLine();
		text = text.toUpperCase();
		
		for(int i = 0; i < text.length(); i++) {
			int idx = letters.indexOf(text.charAt(i));
			if(text.charAt(i) == ' '){
				encoded.append(" ");
				continue;
			}
			
			if(idx - shift < 0) {
				idx = letters.indexOf(text.charAt(i)) - shift;
				encoded.append(arr[(letters.length()) + idx]);
			} else {
				encoded.append(arr[idx - shift]);
			}
		}
		System.out.println(encoded);
		sc.close();
	}

}
