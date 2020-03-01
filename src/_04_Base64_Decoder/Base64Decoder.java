package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text. Each number 0-63 is
	 * mapped to a character. NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE
	 * ENCODING! Since the numbers 0 through 63 can be represented using 6 bits,
	 * every four (4) characters will represent twenty four (24) bits of data. 4 * 6
	 * = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being
	 * converted do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML
	 * file (for web development), so that way a web site does not have to look for
	 * an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */

	final static char[] base64Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };

	// 1. Complete this method so that it returns the element in
	// the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c) {
		int i = 0;
		while (c != base64Chars[i]) {
			i += 1;
		}
		return (byte) i;
	}

	// 2. Complete this method so that it will take in a string that is 4
	// characters long and return an array of 3 bytes (24 bits). The byte
	// array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s) {
		String last = "";
		for (int j = 0; j < s.length(); j++) {
			String test = "";
			int i = 0;
			while (s.charAt(j) != base64Chars[i]) {
				i += 1;
			}
			test = Integer.toBinaryString(i);
			while (test.length() % 6 != 0) {
				test = "0" + test;
			}
			last += test;
		}
		String temp1 = last.substring(0, 8);
		String temp2 = last.substring(8, 16);
		String temp3 = last.substring(16, 24);
		int result0 = Integer.parseInt(temp1, 2);
		int result1 = Integer.parseInt(temp2, 2);
		int result2 = Integer.parseInt(temp3, 2);

		byte[] results = new byte[3];
		results[0] = (byte) result0;
		results[1] = (byte) result1;
		results[2] = (byte) result2;

		return results;
	}

	// 3. Complete this method so that it takes in a string of any length
	// and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		int i = 0;
		
		byte[] results = new byte[file.length()];
		byte[] temp = new byte[3];
		while (i < file.length()) {
			String s = file.substring(i, i + 4);
			
			temp = convert4CharsTo24Bits(s);
			for (int j = 0; j < 3; j++) {
				results[j + i] = temp[j];
				System.out.println(results[j + i]);
			}
			i += 4;
		}
		return results;
	}
}
