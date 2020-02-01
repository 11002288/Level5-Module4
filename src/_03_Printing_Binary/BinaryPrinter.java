package _03_Printing_Binary;

public class BinaryPrinter {
	// Complete the methods below so they print the passed in parameter in binary.
	// Use bit shifting and bit masking to print the binary numbers.
	// Do not use the Integer.toBinaryString method!
	// Don't be afraid to use the methods that are already complete to finish the
	// others.
	// Create a main method to test your methods.

	public static void printByteBinary(byte b) {
		int i = (int)b;
		printIntBinary(i);
	}

	public static void printShortBinary(short s) {
		int i = (int)s;
		printIntBinary(i);
	}

	public static void printIntBinary(int i) {
		String s = "";
	    while (i > 0)
	    {
	        s =  ( (i % 2 ) == 0 ? "0" : "1") +s;
	        i = i / 2;
	    }
	    System.out.println(s);

	}

	public static void printLongBinary(long l) {
		int i = (int)l;
		printIntBinary(i);
	}

	public static void main(String[] args) {
		printByteBinary((byte) 10);
		printShortBinary((short) 20);
		printIntBinary(30);
		printLongBinary(37);
		
	}
}
