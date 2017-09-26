import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PalindromeReader
{
	private static String phrase;
	private static PalindromeReader reader = new PalindromeReader();
	private static boolean status = true;
	
	public void readFile() 
    {
    	try
    	{
    		File inputFile = new File("Palindrome.dat");
    		Scanner input = new Scanner(inputFile);
    		phrase = input.nextLine().toLowerCase(); // make lowercase because that doesn't matter
    		input.close();
    	} 
    	catch (IOException e) 
    	{
    		System.err.println("IOException in reading input file!!!");
    	}	
    } //end readFile()
	
	public static boolean isaPalindrome(String expr)
	{
		if(phrase.length() == 2 && phrase.charAt(phrase.length()-1) == phrase.charAt(0))
			status = true;
		else if(phrase.length() == 1)
			status = true;
		else if(phrase.charAt(phrase.length()-1) == phrase.charAt(0) && phrase.length() != (1 | 2))
		{
			phrase = phrase.substring(1, phrase.length()-1);
			//System.out.println(phrase);
			//System.out.println(phrase.length());
			reader.isaPalindrome(phrase);
		}
		else if(phrase.charAt(phrase.length()-1) != phrase.charAt(0))
			status = false;
		return status;
	}
	
	public static void main(String[] args)
	{
		reader.readFile();
		System.out.println(reader.isaPalindrome(phrase));
	}
}